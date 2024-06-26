import com.movella.movelladot_pc_sdk.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;


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
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        try {
            boolean program = true;
            while (program) {
                printMenu();
                //Integer choice = Integer.parseInt(sc.nextLine());
                Integer choice = sc.nextInt(); // Read the integer input
                sc.nextLine();
                while (choice>7 || choice<0){
                    System.out.println("Not a valid number. Enter a number between 1 and 7");
                    //choice = Integer.parseInt(sc.nextLine());
                    choice = sc.nextInt(); // Read the integer input again
                    sc.nextLine();
                }

                switch (choice) {
                    case 1: {
                        connectDOT();
                        break;
                    }
                    case 2: {
                        System.out.println("If you want to perform the MFM on more than one sensor, please keep in mind that it will happen AT THE SAME TIME FOR ALL THE SENSORS");
                        System.out.println("Ask for help if needed, if not, do one sensor at a time.");
                        System.out.println("---------");
                        System.out.println("To perform an MFM, the sensor has to be parallel to the ground (orange side upwards), rotated 360º forward and after that, 360º sideways.\nThen, we need to turn it 90º clockwise (still parallel to the floor) and repeat the process.\nContinue doing so in all directions until it reaches 100%.");
                        System.out.println("Press Enter to continue...");
                        sc.nextLine();
                        mfm();
                        break;
                    }
                    case 3: {
                        System.out.println("How many seconds do you want to record?:");
                        Integer seconds = Integer.parseInt((sc.nextLine()));
                        if (xdpcHandler.connectedDots().size()==2){
                            startRecordingParallel(seconds);
                        } else {
                            startRecording(seconds);
                        }
                        break;
                    }
                    case 4: {
                        sync();
                        break;
                    }
                    case 5: {
                        infoDot();
                        break;
                    }
                    case 6: {
                        graphsIndiv();
                        if (xdpcHandler.connectedDots().size() == 2) {
                            graphsTwoSensors();
                        }
                        break;
                    }
                    case 7: {
                        System.out.println("Closing app...");
                        program = false;
                        turnOff();
                        if(xdpcHandler.manager()!=null) {
                            xdpcHandler.cleanup();
                        }
                        break;
                    }
                }
                System.out.println("When you are ready to continue click [ENTER]");
                if (sc.hasNextLine()) {
                    sc.nextLine(); // Consume newline
                }
            }
        }catch(NumberFormatException ex){
            System.out.println("  NOT A NUMBER. Closing application... \n");
            turnOff();
        } catch (IOException e) {
            e.printStackTrace();
            turnOff();
        } finally {
            sc.close();
        }
    }


    public static void printMenu(){
        System.out.println("-----------------MENU-----------------");
        System.out.println("   1: Connect DOT(s)");
        System.out.println("   2: Perform MFM");
        System.out.println("   3: Start recording");
        System.out.println("   4: Synchronize DOTs (connection + example recording)");
        System.out.println("   5: Get info about DOT(s)");
        System.out.println("   6: View last logs from DOT(s)");
        System.out.println("   7: Exit");
        System.out.println(" --- Choose an option: ");
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
    }

    public static void graphsIndiv() throws Exception {
        checkConnection();

        for (XsDotDevice device : xdpcHandler.connectedDots())
        {
            String logFileName = String.valueOf(new XsString(String.format("logfile_" + "%s" + ".csv", device.bluetoothAddress().toString().replace(':', '-'))));
            String fileName = new File(logFileName).getName();
            String plotTitle = fileName.substring(0, fileName.lastIndexOf('.'));

            // Read data from the file
            List<Double> sampleTime = new ArrayList<>();
            List<Double> eulerX = new ArrayList<>();
            List<Double> eulerY = new ArrayList<>();
            List<Double> eulerZ = new ArrayList<>();
            List<Double> freeAccX = new ArrayList<>();
            List<Double> freeAccY = new ArrayList<>();
            List<Double> freeAccZ = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(logFileName))) {
                String line;
                // Skip the first lines (headers)
                br.readLine();
                boolean headerSkipped = false;
                boolean header2Skipped = false;
                while ((line = br.readLine()) != null) {
                    if (!headerSkipped) {
                        headerSkipped = true;
                        continue;
                    }
                    String[] parts = line.split(",");
                    // Excludes the times where there is no data
                    if (parts.length < 7) {
                        continue;
                    }
                    sampleTime.add(Double.parseDouble(parts[0]));
                    eulerX.add(Double.parseDouble(parts[1]));
                    eulerY.add(Double.parseDouble(parts[2]));
                    eulerZ.add(Double.parseDouble(parts[3]));
                    freeAccX.add(Double.parseDouble(parts[4]));
                    freeAccY.add(Double.parseDouble(parts[5]));
                    freeAccZ.add(Double.parseDouble(parts[6]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            XYSeriesCollection eulerDataset = new XYSeriesCollection();
            eulerDataset.addSeries(createSeries(sampleTime, eulerX, "Euler X"));
            eulerDataset.addSeries(createSeries(sampleTime, eulerY, "Euler Y"));
            eulerDataset.addSeries(createSeries(sampleTime, eulerZ, "Euler Z"));

            XYSeriesCollection freeAccDataset = new XYSeriesCollection();
            freeAccDataset.addSeries(createSeries(sampleTime, freeAccX, "Free Acc X"));
            freeAccDataset.addSeries(createSeries(sampleTime, freeAccY, "Free Acc Y"));
            freeAccDataset.addSeries(createSeries(sampleTime, freeAccZ, "Free Acc Z"));

            //Euler angles chart
            JFreeChart eulerChart = ChartFactory.createXYLineChart(
                    "Euler Angles - " + plotTitle,
                    "Sample Time",
                    "Value",
                    eulerDataset
            );

            //Free acceleration chart
            JFreeChart freeAccChart = ChartFactory.createXYLineChart(
                    "Free Acceleration - " + plotTitle,
                    "Sample Time",
                    "Value",
                    freeAccDataset
            );

            ChartPanel eulerPanel = new ChartPanel(eulerChart);

            JFrame eulerFrame = new JFrame("Euler Angles Plot");
            eulerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            eulerFrame.getContentPane().add(eulerPanel);
            eulerFrame.pack();
            eulerFrame.setVisible(true);

            ChartPanel freeAccPanel = new ChartPanel(freeAccChart);

            JFrame freeAccFrame = new JFrame("Free Acceleration Plot");
            freeAccFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            freeAccFrame.getContentPane().add(freeAccPanel);
            freeAccFrame.pack();
            freeAccFrame.setVisible(true);
        }
    }

    public static void graphsTwoSensors() {

            String logFileName = "movementEuler.csv";
            String fileName = new File(logFileName).getName();
            String plotTitle = fileName.substring(0, fileName.lastIndexOf('.'));

            // Read data from the file
            List<Double> sampleTime = new ArrayList<>();
            List<Double> eulerX = new ArrayList<>();
            List<Double> eulerY = new ArrayList<>();
            List<Double> eulerZ = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(logFileName))) {
                String line;
                // Skip the first line (header)
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    // Excludes the times where there is no data
                    if (parts.length < 4) {
                        continue;
                    }
                    sampleTime.add(Double.parseDouble(parts[0]));
                    eulerX.add(parseDoubleWithComma(parts[1]));
                    eulerY.add(parseDoubleWithComma(parts[2]));
                    eulerZ.add(parseDoubleWithComma(parts[3]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            XYSeriesCollection eulerDataset = new XYSeriesCollection();
            eulerDataset.addSeries(createSeries(sampleTime, eulerX, "Euler X"));
            eulerDataset.addSeries(createSeries(sampleTime, eulerY, "Euler Y"));
            eulerDataset.addSeries(createSeries(sampleTime, eulerZ, "Euler Z"));

            // Euler angles chart
            JFreeChart eulerChart = ChartFactory.createXYLineChart(
                    "Euler Angles - " + plotTitle,
                    "Sample Time",
                    "Value",
                    eulerDataset
            );

            ChartPanel eulerPanel = new ChartPanel(eulerChart);

            JFrame eulerFrame = new JFrame("Euler Angles Plot");
            eulerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            eulerFrame.getContentPane().add(eulerPanel);
            eulerFrame.pack();
            eulerFrame.setVisible(true);
    }
    private static double parseDoubleWithComma(String value) {
        return Double.parseDouble(value.replace(",", "."));
    }

    public static XYSeries createSeries(List<Double> xData, List<Double> yData, String seriesName) {
        XYSeries series = new XYSeries(seriesName);
        for (int i = 0; i < xData.size(); i++) {
            series.add(xData.get(i), yData.get(i));
        }
        return series;
    }

    public static void mfm() throws Exception{
        checkConnection();

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

    public static void checkConnection() {
        if (xdpcHandler.connectedDots().isEmpty())
        {
            System.out.println("There're no DOTs connected. Aborting");
            System.exit(-1);
        }
    }

    public static void sync()throws Exception {
        checkConnection();

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
    }

    public static void startRecording(int seconds) throws Exception {
        checkConnection();

        for (XsDotDevice device : xdpcHandler.connectedDots()) {
            // Set the filter profile
            if (device.setOnboardFilterProfile(new XsString("General"))) {
                System.out.println("Successfully set filter profile to General");
            } else {
                System.out.println("Failed to set filter profile!");
            }
            // Set output rate
            if (device.setOutputRate(60)) {
                System.out.println("Successfully set output rate to 60");
            } else {
                System.out.println("Failed to set output rate!");
            }

            System.out.println("Putting device into measurement mode: ");
            if (!device.startMeasurement(XsPayloadMode.ExtendedEuler)) {
                System.out.println(String.format("Could not put device into measurement mode. Reason: %s", device.lastResultText().toString()));
                continue;
            }
        }

        // Reset heading for each device to calibrate sensors
        long startTime = XsTimeStamp.nowMs();
        System.out.print("Calibarting for 5 seconds: ");
        while (XsTimeStamp.nowMs() - startTime <= 5000) { // Reset for 5 seconds
            for (XsDotDevice device : xdpcHandler.connectedDots()) {
                System.out.print(String.format("\nResetting heading for device %s: ", device.bluetoothAddress().toString()));
                if (device.resetOrientation(XsResetMethod.XRM_Heading)) {
                    System.out.print("OK");
                } else {
                    System.out.print(String.format("NOK: %s", device.lastResultText().toString()));
                }
            }
            System.out.println("\n");
            Thread.sleep(1000); // Sleep for 1 second
        }

        for (XsDotDevice device : xdpcHandler.connectedDots()) {
            // Enable logging of Euler angles to CSV file
            device.setLogOptions(XsLogOptions.Euler);
            final XsString logFileName = new XsString(String.format("logfile_" + "%s" + ".csv", device.bluetoothAddress().toString().replace(':', '-')));
            System.out.println(String.format("Enable logging to: %s", logFileName));
            if (!device.enableLogging(logFileName)) {
                System.out.println(String.format("Failed to enable logging. Reason: %s", device.lastResultText().toString()));
            }
        }

        Thread.sleep(2000); //Sleep for 2 seconds

        // Start measurement loop
        System.out.println("\nStarting measurement...");
        System.out.println("Main loop. Measuring data for " + seconds + " seconds.");

        Thread.sleep(3000); //Sleep for 3 seconds

        System.out.println("-----------------------------------------");

        startTime = XsTimeStamp.nowMs();

        // Main measurement loop
        List<XsEuler> eulerVals1 = new ArrayList<>();
        List<XsEuler> eulerVals2 = new ArrayList<>();
        int count = 0;
        XsEuler initial = new XsEuler();
        eulerVals1.add(initial);
        eulerVals2.add(initial);

        while (XsTimeStamp.nowMs() - startTime <= 1000*seconds) {
            if (xdpcHandler.packetsAvailable()) {
                System.out.print("\r");
                for (XsDotDevice device : xdpcHandler.connectedDots()) {
                    XsDataPacket packet = xdpcHandler.getNextPacket(device.bluetoothAddress().toString());
                    if (packet.containsOrientation()) {
                        XsEuler euler = packet.orientationEuler();
                        //Stores values into Lists to get the subtraction ONLY IF TWO SENSORS ARE CONNECTED
                        if (xdpcHandler.connectedDots().size() == 2) {
                            if (eulerVals1.get(count).empty()) {
                                eulerVals1.add(euler);
                                eulerVals1.add(initial);
                                count++;
                            } else {
                                eulerVals2.add(euler);
                                eulerVals2.add(initial);
                                count++;
                            }
                        }

                        System.out.print(String.format("Roll:%7.2f, Pitch:%7.2f, Yaw:%7.2f| ", euler.roll(), euler.pitch(), euler.yaw()));
                    }
                    packet.delete();
                }
                System.out.println("\n");
            }
        }
        //Delete the zero angles put to see .empty() function ONLY if TWO sensors
        if (xdpcHandler.connectedDots().size() == 2) {
            for (int i = 0; i < eulerVals1.size(); i++) {
                if (eulerVals1.get(i).empty()) {
                    eulerVals1.remove(i);
                }
                if (eulerVals2.get(i).empty()) {
                    eulerVals2.remove(i);
                }
            }
        }
        //Loads the final list ONLY if TWO sensors
        if (xdpcHandler.connectedDots().size() == 2) {
            //Creates a new list with the final angles
            List<XsEuler> finalMov = new ArrayList<>();
            for (int i = 0; i < eulerVals1.size(); i++) {
                Double roll = eulerVals1.get(i).roll() - eulerVals2.get(i).roll();
                Double pitch = eulerVals1.get(i).pitch() - eulerVals2.get(i).pitch();
                Double yaw = eulerVals1.get(i).yaw() - eulerVals2.get(i).yaw();
                XsEuler finalEuler = new XsEuler(roll, pitch, yaw);
                finalMov.add(finalEuler);
            }
            for (int i = 0; i < finalMov.size(); i++) {
                System.out.print(String.format("Roll:%7.2f, Pitch:%7.2f, Yaw:%7.2f| ", finalMov.get(i).roll(), finalMov.get(i).pitch(), finalMov.get(i).yaw()));
                System.out.println("\n");
            }
            generateCsv(finalMov);
        }

        // Reset heading for each device to default alignment
        System.out.println("-----------------------------------------");
        for (XsDotDevice device : xdpcHandler.connectedDots()) {
            System.out.print(String.format("\nResetting heading for device %s: ", device.bluetoothAddress().toString()));
            if (device.resetOrientation(XsResetMethod.XRM_DefaultAlignment)) {
                System.out.print("OK");
            } else {
                System.out.print(String.format("NOK: %s", device.lastResultText().toString()));
            }
        }
        System.out.println("\n");

        // Stop measurement and disable logging for each device
        System.out.println("Stopping measurement...");
        for (XsDotDevice device : xdpcHandler.connectedDots()) {
            if (!device.stopMeasurement()) {
                System.out.print("Failed to stop measurement.");
            }
            if (!device.disableLogging()) {
                System.out.print("Failed to disable logging.");
            }
        }
    }

    public static void startRecordingParallel(int seconds) throws Exception {
        checkConnection();

        List<XsDotDevice> devices = xdpcHandler.connectedDots();

        XsDotDevice device1 = devices.get(0);
        XsDotDevice device2 = devices.get(1);

        // Create thread-safe collections for storing the measurements
        List<XsEuler> eulerVals1 = new CopyOnWriteArrayList<>();
        List<XsEuler> eulerVals2 = new CopyOnWriteArrayList<>();

        CountDownLatch latch = new CountDownLatch(1);

        Thread thread1 = new Thread(() -> {
            try {
                startMeasurement(device1, eulerVals1, seconds,latch);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                startMeasurement(device2, eulerVals2, seconds,latch);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        // Ensure both threads are ready to start measuring
        latch.countDown();
        thread1.join();
        thread2.join();

        int totalSize;
        // Subtract the values after both threads have finished
        if (eulerVals1.size() != eulerVals2.size()){
            totalSize = Math.min(eulerVals1.size(), eulerVals2.size());
        }
        else {
            totalSize = eulerVals1.size();
        }
        List<XsEuler> finalMov = new ArrayList<>();
        for (int i = 0; i < totalSize; i++) {
            Double roll = eulerVals1.get(i).roll() - eulerVals2.get(i).roll();
            Double pitch = eulerVals1.get(i).pitch() - eulerVals2.get(i).pitch();
            Double yaw = eulerVals1.get(i).yaw() - eulerVals2.get(i).yaw();
            XsEuler finalEuler = new XsEuler(roll, pitch, yaw);
            finalMov.add(finalEuler);
        }
        generateCsv(finalMov);

            // Print the new list
        for (int i = 0; i < finalMov.size(); i++) {
            System.out.println("Roll: " + finalMov.get(i).roll() + " Pitch: " + finalMov.get(i).pitch() + " Yaw: " + finalMov.get(i).yaw());
        }
    }

    private static void startMeasurement(XsDotDevice device, List<XsEuler> eulerVals, int seconds, CountDownLatch latch) throws Exception {
        // Set the filter profile
        if (device.setOnboardFilterProfile(new XsString("General"))) {
            System.out.println("Successfully set filter profile to General");
        } else {
            System.out.println("Failed to set filter profile!");
        }

        // Set output rate
        if (device.setOutputRate(60)) {
            System.out.print("Successfully set output rate to 60");
        } else {
            System.out.println("Failed to set output rate!");
        }

        System.out.print("Putting device into measurement mode: ");
        if (!device.startMeasurement(XsPayloadMode.ExtendedEuler)) {
            System.out.println(String.format("Could not put device into measurement mode. Reason: %s", device.lastResultText().toString()));
            return;
        }

        // Reset heading for the device to calibrate sensors
        long startTime = XsTimeStamp.nowMs();
        System.out.print("Calibrating for 5 seconds: ");
        while (XsTimeStamp.nowMs() - startTime <= 5000) { // Reset for 5 seconds
            System.out.print(String.format("\nResetting heading for device %s: ", device.bluetoothAddress().toString()));
            if (device.resetOrientation(XsResetMethod.XRM_Heading)) {
                System.out.print("OK");
            } else {
                System.out.print(String.format("NOK: %s", device.lastResultText().toString()));
            }
            System.out.println("\n");
            Thread.sleep(1000); // Sleep for 1 second
        }

        // Enable logging of Euler angles to CSV file
        device.setLogOptions(XsLogOptions.Euler);
        final XsString logFileName = new XsString(String.format("logfile_" + "%s" + ".csv", device.bluetoothAddress().toString().replace(':', '-')));
        System.out.print(String.format("Enable logging to: %s", logFileName));
        if (!device.enableLogging(logFileName)) {
            System.out.println(String.format("Failed to enable logging. Reason: %s", device.lastResultText().toString()));
        }

        Thread.sleep(2000); // Sleep for 2 seconds

        latch.await();

        // Start measurement loop
        System.out.println("\nStarting measurement...");
        System.out.println("Main loop. Measuring data for " + seconds + " seconds.");
        System.out.println("-----------------------------------------");

        startTime = XsTimeStamp.nowMs();

        // Main measurement loop
        while (XsTimeStamp.nowMs() - startTime <= 1000 * seconds) {
            if (xdpcHandler.packetsAvailable()) {
                System.out.print("\r");
                XsDataPacket packet = xdpcHandler.getNextPacket(device.bluetoothAddress().toString());
                if (packet.containsOrientation()) {
                    XsEuler euler = packet.orientationEuler();
                    eulerVals.add(euler);
                    //System.out.print(String.format("Roll:%7.2f, Pitch:%7.2f, Yaw:%7.2f| ", euler.roll(), euler.pitch(), euler.yaw()));
                }
                packet.delete();
                System.out.println("\n");
            }
        }

        // End measurement
        System.out.println("End measurement");
        if (!device.stopMeasurement()) {
            System.out.println(String.format("Could not stop measurement mode. Reason: %s", device.lastResultText().toString()));
        }

        System.out.println("\n-----------------------------------------");

        if (!device.disableLogging()) {
            System.out.println(String.format("Failed to save log file. Reason: %s", device.lastResultText().toString()));
        }
    }


    public static void generateCsv(List<XsEuler> eulers) {
        try (FileWriter writer = new FileWriter("movementEuler.csv")) {
            writer.append("SampleTimeFine;Euler_X;Euler_Y;Euler_Z\n");
            for (int i = 0; i < eulers.size(); i++) {
                XsEuler euler = eulers.get(i);
                writer.append(String.format("%d;%.4f;%.4f;%.4f\n", i, euler.roll(), euler.pitch(), euler.yaw()));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void infoDot(){
        if (xdpcHandler.connectedDots().isEmpty())
        {
            System.out.println("There're no DOTs connected. Aborting");
            System.exit(-1);
        }
        for (XsDotDevice device : xdpcHandler.connectedDots()){
            boolean inputVal = true;
            System.out.println("Device info: ");
            device.identify();
            System.out.println("--Device tag name: " + device.deviceTagName());
            System.out.println("--Device ID: " + device.deviceId());
            System.out.println("--Bluetooth address: " + device.bluetoothAddress());
            System.out.println("--Battery level: " + device.batteryLevel());
            System.out.println("--Firmware version: " + device.firmwareVersion());
            System.out.println("--Hardware version: " + device.hardwareVersion());
            System.out.println("--Device state: " + device.deviceState());
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
        checkConnection();
        for (XsDotDevice device : xdpcHandler.connectedDots()) {
            if (!device.powerOff())
                System.out.print("Failed to turn off");
            System.out.println("Successful Turn off");

        }
    }
}
