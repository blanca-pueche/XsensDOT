
import com.movella.movelladot_pc_sdk.*;

public class CalibrationExample {

    static{
        try {
            // Make sure to add the movelladot_pc_sdk dll to the PATH environment variable / Classpath so Java can find it
            System.loadLibrary("movelladot_pc_sdk_java64");
            System.out.println("Loaded Library");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native code library failed to load.\n" + e);
            System.exit(1);
        }
    }
    public static void main(String[] args) throws Exception {

        XdpcHandler xdpcHandler = new XdpcHandler();

        if (!xdpcHandler.initialize())
            System.exit(-1);

        xdpcHandler.scanForDots();

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

       //TODO write the function and make changes with quaternions
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

            System.out.println("Putting device into measurement mode: ");
            if (!device.startMeasurement(XsPayloadMode.ExtendedEuler))
            {
                System.out.println(String.format("Could not put device into measurement mode. Reason: %s", device.lastResultText().toString()));
                continue;
            }
        }

        for (XsDotDevice device : xdpcHandler.connectedDots())
            System.out.print(String.format("%-42s", device.bluetoothAddress()));
        System.out.print("\n");

        boolean orientationResetDone = false;
        long startTime = XsTimeStamp.nowMs();
        while (XsTimeStamp.nowMs() - startTime <= 1000*1) //in miliseconds (2 seconds)
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
                        XsQuaternion quat = packet.orientationQuaternion();
                        System.out.println("X: "+quat.x()+" Y: "+quat.y()+" Z: "+quat.z());
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
            xdpcHandler.cleanup();
        }
    }


