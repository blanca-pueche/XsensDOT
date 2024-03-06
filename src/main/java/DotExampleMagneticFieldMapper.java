import com.movella.movelladot_pc_sdk.*;

public class DotExampleMagneticFieldMapper {

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

        xdpcHandler.cleanup();
    }
}

