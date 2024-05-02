import com.movella.movelladot_pc_sdk.*;

import java.util.ArrayList;

public class Sync {

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

        for (XsDotDevice device : xdpcHandler.connectedDots())
        {
            // Make sure all connected devices have the same filter profile and outputrate
            if (device.setOnboardFilterProfile(new XsString("General")))
                System.out.println("Successfully set filter profile to General");
            else
                System.out.println("Failed to set filter profile!");

            if (device.setOutputRate(60))
                System.out.println("Successfully set output rate to 60 Hz");
            else
                System.out.println("Failed to set output rate!");
        }

        XsDotConnectionManager manager = xdpcHandler.manager();
        ArrayList<XsDotDevice> deviceList = xdpcHandler.connectedDots();
        System.out.println(String.format("\nStarting sync for connected devices... Root node: %s", deviceList.get(deviceList.size() - 1).bluetoothAddress()));
        System.out.println("This takes at least 14 seconds");
        if (!manager.startSync(deviceList.get(deviceList.size() - 1).bluetoothAddress()))
        {
            System.out.println(String.format("Could not start sync. Reason: %s", manager.lastResultText().toString()));
            if (manager.lastResult() != XsResultValue.XRV_SYNC_COULD_NOT_START)
            {
                System.out.println("Sync could not be started. Aborting.");
                xdpcHandler.cleanup();
                System.exit(-1);
            }

            // If (some) devices are already in sync mode. Disable sync on all devices first.
            manager.stopSync();
            System.out.println("Retrying start sync after stopping sync");
            if (!manager.startSync(deviceList.get(deviceList.size() - 1).bluetoothAddress()))
            {
                System.out.println(String.format("Could not start sync. Reason: %s. Aborting.", manager.lastResultText().toString()));
                xdpcHandler.cleanup();
                System.exit(-1);
            }
        }

        // Start live data output. Make sure root node is last to go to measurement.
        System.out.println("Putting devices into measurement mode: ");
        for (XsDotDevice device : deviceList)
            if (!device.startMeasurement(XsPayloadMode.ExtendedEuler))
            {
                System.out.println(String.format("Could not put device into measurement mode. Reason: %s", device.lastResultText().toString()));
                continue;
            }

        System.out.println("Starting measurement...");

        System.out.println("Main loop. Measuring data for 2 seconds.");
        System.out.println("-----------------------------------------");

        for (XsDotDevice device : deviceList)
            System.out.print(String.format("%-27s", device.bluetoothAddress()));
        System.out.print("\n");

        long startTime = XsTimeStamp.nowMs();
        while (XsTimeStamp.nowMs() - startTime <= 2000)
        {
            if (xdpcHandler.packetsAvailable())
            {
                for (XsDotDevice device : deviceList)
                {
                    // Retrieve a packet
                    XsDataPacket packet = xdpcHandler.getNextPacket(device.bluetoothAddress().toString());

                    if (packet.containsOrientation())
                    {
                        XsEuler euler = packet.orientationEuler();
                        System.out.print(String.format("TS:%8d, Roll:%7.2f| ", packet.sampleTimeFine(), euler.roll()));
                    }

                    packet.delete();
                }
                System.out.print("\n");
            }
        }
        System.out.println("\n-----------------------------------------");

        System.out.println("Stopping measurement...");
        for (XsDotDevice device : deviceList) {
            if (!device.stopMeasurement())
                System.out.print("Failed to stop measurement.");
        }

        System.out.println("Stopping sync...");
        if (!manager.stopSync())
            System.out.print("Failed to stop sync.");

        xdpcHandler.cleanup();
    }
}
