import com.movella.movelladot_pc_sdk.*;

public class RecordData {

    static{
        try {
            System.loadLibrary("movelladot_pc_sdk_java64");
            System.out.println("Loaded Library");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native code library failed to load.\n" + e);
            System.exit(1);
        }
    }
    public static void main(String[] args) throws Exception{
        XdpcHandler xdpcHandler = new XdpcHandler();

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

        //prepares DOTs for measuring
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

        //measuring
        System.out.println("Starting measurement...");
        System.out.println("    Main loop. Measuring data for 10 seconds.");
        System.out.println("    -----------------------------------------");
        for (XsDotDevice device : xdpcHandler.connectedDots())
            System.out.print(String.format("%-42s", device.bluetoothAddress()));
        System.out.print("\n");

        //recording loop
        boolean orientationResetDone = false;
        long startTime = XsTimeStamp.nowMs();
        while (XsTimeStamp.nowMs() - startTime <= 10000) //time in ms
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

        xdpcHandler.cleanup();

    }
}
