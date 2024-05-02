import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class EulerAndFreeAccPlot {

    public static void main(String[] args) {
        // Provide the file path to your data file
        String filePath = "logfile_D4-22-CD-00-4D-68.csv";

        // Extract file name without extension
        String fileName = new File(filePath).getName();
        String plotTitle = fileName.substring(0, fileName.lastIndexOf('.'));

        // Read data from the file
        List<Double> sampleTime = new ArrayList<>();
        List<Double> eulerX = new ArrayList<>();
        List<Double> eulerY = new ArrayList<>();
        List<Double> eulerZ = new ArrayList<>();
        List<Double> freeAccX = new ArrayList<>();
        List<Double> freeAccY = new ArrayList<>();
        List<Double> freeAccZ = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the first line (header)
            br.readLine();
            boolean headerSkipped = false;
            boolean header2Skipped = false;
            while ((line = br.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }
                if (!header2Skipped) {
                    header2Skipped = true;
                    continue;
                }
                String[] parts = line.split(",");
                // Check if the line has enough fields
                if (parts.length < 7) {
                    continue; // Skip this line
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

        // Create datasets for Euler angles and Free acceleration
        XYSeriesCollection eulerDataset = new XYSeriesCollection();
        eulerDataset.addSeries(createSeries(sampleTime, eulerX, "Euler X"));
        eulerDataset.addSeries(createSeries(sampleTime, eulerY, "Euler Y"));
        eulerDataset.addSeries(createSeries(sampleTime, eulerZ, "Euler Z"));

        XYSeriesCollection freeAccDataset = new XYSeriesCollection();
        freeAccDataset.addSeries(createSeries(sampleTime, freeAccX, "Free Acc X"));
        freeAccDataset.addSeries(createSeries(sampleTime, freeAccY, "Free Acc Y"));
        freeAccDataset.addSeries(createSeries(sampleTime, freeAccZ, "Free Acc Z"));

        // Create the Euler angles chart
        JFreeChart eulerChart = ChartFactory.createXYLineChart(
                "Euler Angles - " + plotTitle,
                "Sample Time",
                "Value",
                eulerDataset
        );

        // Create the Free acceleration chart
        JFreeChart freeAccChart = ChartFactory.createXYLineChart(
                "Free Acceleration - " + plotTitle,
                "Sample Time",
                "Value",
                freeAccDataset
        );

        // Display the charts in separate frames
        // Create a panel to hold the Euler chart
        ChartPanel eulerPanel = new ChartPanel(eulerChart);

        // Create a new frame for the Euler chart
        JFrame eulerFrame = new JFrame("Euler Angles Plot");
        eulerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eulerFrame.getContentPane().add(eulerPanel);
        eulerFrame.pack();
        eulerFrame.setVisible(true);

        // Create a panel to hold the Free acceleration chart
        ChartPanel freeAccPanel = new ChartPanel(freeAccChart);

        // Create a new frame for the Free acceleration chart
        JFrame freeAccFrame = new JFrame("Free Acceleration Plot");
        freeAccFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        freeAccFrame.getContentPane().add(freeAccPanel);
        freeAccFrame.pack();
        freeAccFrame.setVisible(true);
    }

    // Helper method to create XYSeries from data lists
    private static XYSeries createSeries(List<Double> xData, List<Double> yData, String seriesName) {
        XYSeries series = new XYSeries(seriesName);
        for (int i = 0; i < xData.size(); i++) {
            series.add(xData.get(i), yData.get(i));
        }
        return series;
    }
}
