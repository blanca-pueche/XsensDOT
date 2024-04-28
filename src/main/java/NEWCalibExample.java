import com.movella.movelladot_pc_sdk.*;

import java.util.ArrayList;
import java.util.List;

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
        XsQuaternion q1 = new XsQuaternion();
        XsQuaternion q3 = new XsQuaternion();
        /*List<Double> w = new ArrayList<>();
        List<Double> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();
        List<Double> z = new ArrayList<>();
        Double wMean;
        Double xMean;
        Double yMean;
        Double zMean;*/
        while (XsTimeStamp.nowMs() - startTime <= 1000*8) //in miliseconds (8 seconds)
        {
            if (xdpcHandler.packetsAvailable())
            {
                System.out.print("\r");
                for (XsDotDevice device : xdpcHandler.connectedDots())
                {
                    // Retrieve a packet
                    XsDataPacket packet = xdpcHandler.getNextPacket(device.bluetoothAddress().toString());
                    XsEuler euler;
                    XsQuaternion quat;
                    if (packet.containsOrientation())
                    {
                        quat = packet.orientationQuaternion();
                        q1 = quat;
                    }
                    packet.delete();
                    q3.multiply(q1, q1.conjugate());
                    //System.out.println("W: "+q3.x()+" X: "+q3.x()+" Y: "+q3.y()+" Z: "+q3.z());
                    /*w.add(q3.w());
                    x.add(q3.x());
                    y.add(q3.y());
                    z.add(q3.z());*/
                    //TODO me voy a quedar con el ultimo e3, para facilitar el proceso
                    XsEuler e3 = new XsEuler(q3);
                    System.out.print(String.format("%-42s", device.bluetoothAddress()));
                    System.out.println("--------------------------------------e3--------------------------------------------");
                    System.out.println("Roll: "+e3.roll()+" Pitch: "+e3.pitch()+" Yaw: "+e3.yaw());

                }

                if (!orientationResetDone /*&& (XsTimeStamp.nowMs() - startTime) > 5000*/)
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
            /*wMean = calculateAverage(w);
            xMean = calculateAverage(x);
            yMean = calculateAverage(y);
            zMean = calculateAverage(z);
            XsQuaternion finalQuat = new XsQuaternion(wMean,xMean,yMean,zMean);
            XsEuler e3 = new XsEuler(finalQuat);

            //System.out.print(String.format("%-42s", device.bluetoothAddress()));
            System.out.println("--------------------------------------e3--------------------------------------------");
            System.out.println("Roll: "+e3.roll()+" Pitch: "+e3.pitch()+" Yaw: "+e3.yaw());*/
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

    /*public static Double calculateAverage(List <Double> array) {
        int sum = 0;
        for (int i=0; i< array.size(); i++) {
            sum += i;
        }
        return (double) (sum / array.size());
    }*/
}


