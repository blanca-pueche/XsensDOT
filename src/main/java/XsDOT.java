import com.movella.movelladot_pc_sdk.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;


public class XsDOT { //TODO handle exceptions
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
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        try {
            boolean program = true;
            while (program) {

                printMenu();

                Integer choice = Integer.parseInt(sc.nextLine()); //TODO error here!? look whats wrong and when it happens
                while (choice>8 || choice<0){
                    System.out.println("Not a valid number. Enter a number between 1 and 8");
                    choice = Integer.parseInt(sc.nextLine());
                }

                switch (choice) {
                    case 1: {
                        connectDOT();
                        break;
                    }
                    case 2: {
                        System.out.println("To perform an MFM, the sensor has to be parallel to the ground (orange side upwards), rotated 360º forward and after that, 360º sideways.\nThen, we need to turn it 90º clockwise (still parallel to the floor) and repeat the process.\nContinue doing so in all directions until it reaches 100%.");
                        mfm();
                        break;
                    }
                    case 3: {
                        System.out.println("How many seconds do you want to record?:");
                        Integer seconds = Integer.parseInt((sc.nextLine()));
                        startRecording(seconds);
                        break;
                    }
                    case 4: {
                        //TODO sync DOTs
                        break;
                    }
                    case 5: {
                        //TODO export data
                        break;
                    }
                    case 6: {
                        //TODO DOT info
                        infoDot();
                        break;
                    }
                    case 7: {
                        //TODO turn off
                        turnOff();
                        break;
                    }
                    case 8: {
                        System.out.println("Closing app...");
                        program = false;
                        turnOff();
                        break;
                    }

                }
                sc.nextLine();
            }
        }catch(NumberFormatException ex){
            System.out.println("  NOT A NUMBER. Closing application... \n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(xdpcHandler.manager()!=null) {
                xdpcHandler.cleanup();
            }
            sc.close();
        }
    }


    public static void printMenu(){
        System.out.println("-----------------MENU-----------------");
        System.out.println("   1: Connect DOT(s)");
        System.out.println("   2: Perform MFM");
        System.out.println("   3: Start recording");
        System.out.println("   4: Synchronize DOTs (connection + example recording)");
        System.out.println("   5: Export data");
        System.out.println("   6: Get info about DOTs"); // TODO make an option to rename DOT
        System.out.println("   7: Turn OFF DOTs");
        System.out.println("   8: Exit");
        System.out.println(" --- Choose an option: ");
        //TODO see if the number is between the ones on the menu
    }

    public static void connectDOT() throws Exception{
        if (!xdpcHandler.initialize())
            System.exit(-1);
        //scans for available DOTs
        xdpcHandler.scanForDots(sc);

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

            //System.out.println("Setting quaternion CSV output");
            //device.setLogOptions(XsLogOptions.Quaternion);
            System.out.println("Setting quaternion and euler CSV output");
            device.setLogOptions(XsLogOptions.QuaternionAndEuler);

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

        System.out.println("Main loop. Measuring data for " + seconds + " seconds.");
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

    public static void infoDot(){
        if (xdpcHandler.connectedDots().isEmpty())
        {
            System.out.println("There're no DOTs connected. Aborting");
            System.exit(-1);
        }
        boolean inputVal = true;
        for (XsDotDevice device : xdpcHandler.connectedDots()){
            System.out.println("Device info: ");
            System.out.println("--Bluetooth address: " + device.bluetoothAddress());
            System.out.println("--Device ID: " + device.deviceId());
            System.out.println("--Device state: " + device.deviceState());
            System.out.println("--Device ID: " + device.deviceTagName());
            while(inputVal) {
                System.out.println("--- Do you want to change tag name?: [y/n]");
                String change = sc.nextLine();
                if (change.equalsIgnoreCase("y")) {
                    changeName(device);
                    inputVal = false;
                } else if (change.equalsIgnoreCase("n")) {
                    inputVal = false;
                } else {
                    System.out.println("NOT A VALID INPUT: please try again");
                }
            }
        }
    }

    public static void changeName(XsDotDevice device){
        System.out.println("Has to be a non-empty string no longer than 16 characters");
        System.out.println("Please, enter new tag name: ");
        String name = sc.nextLine();
        XsString tagName = new XsString(name);
        if (!device.setDeviceTagName(tagName)){
            System.out.println(" Couldn't change the DOT tag name");
        } else {
            System.out.println(" Successful tag name change");
        }
    }

    public static void turnOff(){
        if (xdpcHandler.connectedDots().isEmpty())
        {
           System.out.println("There're no DOTs connected. Aborting");
           System.exit(-1);
        }
        for (XsDotDevice device : xdpcHandler.connectedDots()) {
            if (!device.powerOff())
                System.out.print("Failed to turn off");
            System.out.println("Successful Turn off");

        }
    }
}
