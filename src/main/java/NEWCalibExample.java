import com.movella.movelladot_pc_sdk.*;

public class NEWCalibExample {

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
        while (XsTimeStamp.nowMs() - startTime <= 1000*0.5) //in miliseconds (0.5 seconds)
        {
            if (xdpcHandler.packetsAvailable())
            {
                System.out.print("\r");
                XsQuaternion q1 = new XsQuaternion();
                XsQuaternion q2 = new XsQuaternion();
                XsQuaternion q3 = new XsQuaternion();
                for (XsDotDevice device : xdpcHandler.connectedDots())
                {
                    // Retrieve a packet
                    XsDataPacket packet = xdpcHandler.getNextPacket(device.bluetoothAddress().toString());
                    XsEuler euler;
                    XsQuaternion quat;
                    if (packet.containsOrientation())
                    {
                        euler = packet.orientationEuler();
                        System.out.print(String.format("Roll:%7.2f, Pitch:%7.2f, Yaw:%7.2f| ", euler.roll(), euler.pitch(), euler.yaw()));
                        quat = packet.orientationQuaternion();
                        //TODO check this
                        if (q1.empty()){
                            q1 = quat;
                        } else {
                            q2 = quat;
                        }
                        System.out.println("W: "+quat.w()+" X: "+quat.x()+" Y: "+quat.y()+" Z: "+quat.z());
                        //XsEuler e1 = new XsEuler(quat);
                        //System.out.print(String.format("Roll_1:%7.2f, Pitch_1:%7.2f, Yaw_1:%7.2f| ", e1.roll(), e1.pitch(), e1.yaw()));
                    }
                    packet.delete();
                }
                q3.multiply(q1, q2.conjugate());
                System.out.println("--------------------------------------q3--------------------------------------------");
                System.out.println("W: "+q3.w()+" X: "+q3.x()+" Y: "+q3.y()+" Z: "+q3.z());

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


