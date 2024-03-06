import com.movella.movelladot_pc_sdk.*;
import java.io.BufferedReader;
import java.util.Scanner;


public class XsDOT {
    static{
        try {
            System.loadLibrary("movelladot_pc_sdk_java64");
            System.out.println("Loaded Library");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native code library failed to load.\n" + e);
            System.exit(1);
        }
    }

    private static XdpcHandler xdpcHandler = new XdpcHandler();
    public static void main(String[] args) throws Exception {

        boolean program = true;
        while(program) {
            System.out.println("-----------------MENU-----------------");
            System.out.println("   1: Connect DOT(s)");
            System.out.println("   2: Perform MFM");
            System.out.println("   3: Start recording");
            System.out.println("   4: Synchronize DOTs (connection + example recording)");
            System.out.println("   5: Export data");
            System.out.println("   6: Get info about DOTs"); // make an option to rename it
            System.out.println("   7: Exit");

            Scanner sc = new Scanner(System.in);
            Integer choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: {
                    connectDOT();
                }
                case 2: {
                    mfm();
                }
                case 3: {
                    System.out.println("How many seconds do you want to record?:");
                    Integer seconds = Integer.parseInt((sc.nextLine()));
                    startRecording(seconds);
                }
                case 4: {
                    //TODO
                }
                case 5: {
                    //TODO
                }
                case 6: {
                    //TODO
                }
                case 7: {
                    System.out.println("Closing app...");
                    program = false;
                }


            }
        }
        xdpcHandler.cleanup();
    }



    public static void connectDOT() throws Exception{
        if (!xdpcHandler.initialize())
            System.exit(-1);

        //scans for available DOTs
        xdpcHandler.scanForDots();

        if (xdpcHandler.detectedDots().empty())
        {
            System.out.println("No Movella DOT device(s) found. Aborting.");
            System.exit(-1);
        }

        //connects to DOTs
        xdpcHandler.connectDots();

        if (xdpcHandler.connectedDots().isEmpty())
        {
            System.out.println("Could not connect to any Movella DOT device(s). Aborting.");
            System.exit(-1);
        }

        // turn off DOTs
        /*for (XsDotDevice device : xdpcHandler.connectedDots()) {
            if (!device.powerOff())
                System.out.print("Failed to turn off");
            System.out.println("Successful Turn off");

        }*/
    }

    public static void mfm() throws Exception{
        if (xdpcHandler.connectedDots().isEmpty())
        {
            System.out.println("There're no DOTs connected. Aborting");
            System.exit(-1);
        }

        for (XsDotDevice device : xdpcHandler.connectedDots())
        {
            System.out.println(String.format("Start magnetic field mapping for: %s @ address: %s", device.deviceTagName(), device.bluetoothAddress()));
            if(!device.startMagneticFieldMapping())
            {
                System.out.println(String.format("Could not start magnetic field mapping. Reason: %s", device.lastResultText().toString()));
                continue;
            }

            // Add device to buffer to track MFM progress per device
            xdpcHandler.addDeviceToProgressBuffer(device.bluetoothAddress().toString());
        }

        System.out.println("Main loop. Logging data till we reach 100 %.");
        System.out.println("-----------------------------------------");

        boolean allDevicesDone = false;
        while(!allDevicesDone)
        {
            allDevicesDone = true;
            for (XsDotDevice device : xdpcHandler.connectedDots())
            {
                if (xdpcHandler.progress(device.bluetoothAddress().toString()) != 100)
                {
                    allDevicesDone = false;
                    break;
                }
            }

            Thread.yield();
        }

        System.out.println("\nAll devices Done with Magnetic Field Mapping.");
        System.out.println("-----------------------------------------");

        System.out.println("\nStopping magnetic field mapping...");
        for (XsDotDevice device : xdpcHandler.connectedDots())
        {
            if(!device.stopMagneticFieldMapping())
            {
                System.out.println("\nFailed to stop magnetic field mapping.");
            }
        }
    }
    public static void startRecording(int seconds) throws Exception{
        if (xdpcHandler.detectedDots().empty())
        {
            System.out.println("No Movella DOT device(s) found. Aborting.");
            System.exit(-1);
        }

        xdpcHandler.connectDots();

        if (xdpcHandler.connectedDots().isEmpty())
        {
            System.out.println("Could not connect to any Movella DOT device(s). Aborting.");
            System.exit(-1);
        }

        for (XsDotDevice device : xdpcHandler.connectedDots())
        {
            System.out.println("Available filter profiles: ");
            XsFilterProfileArray filterProfiles = device.getAvailableFilterProfiles();
            for (int j = 0; j < filterProfiles.size(); j++) {
                System.out.println(String.format("Found label: %s", filterProfiles.at(j).label().toString()));
            }

            System.out.println(String.format("Current filter profile: %s", device.onboardFilterProfile().label()));
            if (device.setOnboardFilterProfile(new XsString("General")))
                System.out.println("Successfully set filter profile to General");
            else
                System.out.println("Failed to set filter profile!");

            System.out.println("Setting quaternion CSV output");
            device.setLogOptions(XsLogOptions.Quaternion);

            final XsString logFileName = new XsString(String.format("logfile_" + "%s" + ".csv", device.bluetoothAddress().toString().replace(':', '-')));
            System.out.println(String.format("Enable logging to: %s", logFileName));

            if (!device.enableLogging(logFileName))
                System.out.println(String.format("Failed to enable logging. Reason: %s", device.lastResultText().toString()));

            System.out.println("Putting device into measurement mode: ");
            if (!device.startMeasurement(XsPayloadMode.ExtendedEuler))
            {
                System.out.println(String.format("Could not put device into measurement mode. Reason: %s", device.lastResultText().toString()));
                continue;
            }
        }

        System.out.println("Starting measurement...");

        System.out.println("Main loop. Measuring data for" + seconds + " seconds.");
        System.out.println("-----------------------------------------");

        for (XsDotDevice device : xdpcHandler.connectedDots())
            System.out.print(String.format("%-42s", device.bluetoothAddress()));
        System.out.print("\n");

        boolean orientationResetDone = false;
        long startTime = XsTimeStamp.nowMs();
        while (XsTimeStamp.nowMs() - startTime <= 1000*seconds) //in miliseconds
        {
            if (xdpcHandler.packetsAvailable())
            {
                System.out.print("\r");
                for (XsDotDevice device : xdpcHandler.connectedDots())
                {
                    // Retrieve a packet
                    XsDataPacket packet = xdpcHandler.getNextPacket(device.bluetoothAddress().toString());

                    if (packet.containsOrientation())
                    {
                        XsEuler euler = packet.orientationEuler();
                        System.out.print(String.format("Roll:%7.2f, Pitch:%7.2f, Yaw:%7.2f| ", euler.roll(), euler.pitch(), euler.yaw()));
                    }

                    packet.delete();
                }
                if (!orientationResetDone && (XsTimeStamp.nowMs() - startTime) > 5000)
                {
                    for (XsDotDevice device : xdpcHandler.connectedDots())
                    {
                        System.out.print(String.format("\nResetting heading for device %s: ", device.bluetoothAddress().toString()));
                        if (device.resetOrientation(XsResetMethod.XRM_Heading))
                            System.out.print("OK");
                        else
                            System.out.print(String.format("NOK: %s", device.lastResultText().toString()));
                    }
                    System.out.print("\n");
                    orientationResetDone = true;
                }
            }
        }
        System.out.println("\n-----------------------------------------");

        for (XsDotDevice device : xdpcHandler.connectedDots())
        {
            System.out.print(String.format("\nResetting heading for device %s: ", device.bluetoothAddress().toString()));
            if (device.resetOrientation(XsResetMethod.XRM_DefaultAlignment))
                System.out.print("OK");
            else
                System.out.print(String.format("NOK: %s", device.lastResultText().toString()));
        }
        System.out.println("\n");

        System.out.println("Stopping measurement...");
        for (XsDotDevice device : xdpcHandler.connectedDots()) {
            if (!device.stopMeasurement())
                System.out.print("Failed to stop measurement.");
            if (!device.disableLogging())
                System.out.print("Failed to disable logging.");
        }

    }
}
