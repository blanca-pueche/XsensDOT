import com.movella.movelladot_pc_sdk.*;

public class connectDOT {

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

        for (XsDotDevice device : xdpcHandler.connectedDots()) {
            if (!device.powerOff())
                System.out.print("Failed to turn off");
            System.out.println("Successful Turn off");

        }

        xdpcHandler.cleanup();
    }



}
