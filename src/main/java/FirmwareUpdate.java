import com.movella.movelladot_pc_sdk.*;

public class FirmwareUpdate {

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
            System.out.println(String.format("Updating firmware for device: %s", device.deviceTagName().toString()));

            // Reset the update done flag to enable updating the next device in the example.
            xdpcHandler.resetUpdateDone();

            XsVersion firmwareFileVersion = device.startFirmwareUpdateFromServer();
            if (firmwareFileVersion.empty())
            {
                System.out.println(String.format("Did not find a new Firmware on the server, device result: %s", device.lastResultText().toString()));
                break;
            }
            System.out.println(String.format("Updating Firmware to version %s", firmwareFileVersion.toSimpleString()));
            while (!xdpcHandler.updateDone())
                Thread.sleep(100);
        }

        xdpcHandler.cleanup();
    }
}
