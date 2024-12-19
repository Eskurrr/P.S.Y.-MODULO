package com.telemedicina.rcps.main.controller;


import com.telemedicina.rcps.main.Connection.ConnectionClient;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.List;


public class BPMController {
    @FXML
    public LineChart<Number, Number> ECG;
    @FXML
    public Label bpm;
    @FXML
    public ImageView heart;
    @FXML
    public CategoryAxis Xaxis;
    @FXML
    public NumberAxis Yaxis;

    protected ConnectionClient client;
    private static final double NORMAL_HEART_RATE_LOW = 60.0; // beats per minute
    private static final double NORMAL_HEART_RATE_HIGH = 100.0; // beats per minute
    private static final double SAMPLING_RATE = 250.0; // Hz (same as the Python program)
    public ConnectionClient getClient() {
        return client;
    }

    public void setClient(ConnectionClient client) {
        this.client = client;
    }

    @FXML
    public void initialize() {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(2), heart);
        scaleTransition.setFromX(1.0); // Original size
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(1.5); // Grown size
        scaleTransition.setToY(1.5);
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
        updateBpm();
    }
    public void updateBpm(){
        while(!getClient().isStop()){
            String BPM = String.valueOf(getClient().getBpms().getLast());
            bpm.setText(BPM);
        }
    }
    public static String diagnoseECG(List<Float> filteredValues) {
        // Step 1: Detect R-peaks
        List<Integer> rPeakIndices = detectRPeaks(filteredValues);

        // Step 2: Calculate Heart Rate
        double heartRate = calculateHeartRate(rPeakIndices);

        // Step 3: Check for arrhythmias and pathologies
        StringBuilder diagnosis = new StringBuilder();

        // Heart rate analysis
        if (heartRate < NORMAL_HEART_RATE_LOW) {
            diagnosis.append("Bradycardia: Heart rate too low.\n");
        } else if (heartRate > NORMAL_HEART_RATE_HIGH) {
            diagnosis.append("Tachycardia: Heart rate too high.\n");
        } else {
            diagnosis.append("Normal heart rate.\n");
        }

        // Check for irregular rhythms (Atrial Fibrillation)
        if (isIrregularRhythm(rPeakIndices)) {
            diagnosis.append("Possible Atrial Fibrillation: Irregular rhythm detected.\n");
        }

        // Placeholder for ST-segment elevation (Myocardial Infarction)
        if (isSTElevation(filteredValues)) {
            diagnosis.append("Possible Myocardial Infarction (STEMI): ST-segment elevation detected.\n");
        }

        // Bundle branch block and hypertrophy detection can be added here...

        // If no pathology is detected
        if (diagnosis.length() == 0) {
            diagnosis.append("No significant pathology detected.");
        }

        return diagnosis.toString();
    }
    private static List<Integer> detectRPeaks(List<Float> filteredValues) {
        List<Integer> rPeakIndices = new java.util.ArrayList<>();
        float threshold = 0.8f; // Adjust based on your signal amplitude range

        for (int i = 1; i < filteredValues.size() - 1; i++) {
            float prev = filteredValues.get(i - 1);
            float current = filteredValues.get(i);
            float next = filteredValues.get(i + 1);

            // R-peak condition: local maximum above the threshold
            if (current > prev && current > next && current > threshold) {
                rPeakIndices.add(i);
            }
        }
        return rPeakIndices;
    }

    private static double calculateHeartRate(List<Integer> rPeakIndices) {
        if (rPeakIndices.size() < 2) {
            return 0.0; // Not enough data to calculate heart rate
        }

        // Calculate average R-R interval in seconds
        double totalInterval = 0.0;
        for (int i = 1; i < rPeakIndices.size(); i++) {
            totalInterval += (rPeakIndices.get(i) - rPeakIndices.get(i - 1)) / SAMPLING_RATE;
        }
        double averageRRInterval = totalInterval / (rPeakIndices.size() - 1);

        // Convert to BPM
        return 60.0 / averageRRInterval;
    }

    private static boolean isIrregularRhythm(List<Integer> rPeakIndices) {
        if (rPeakIndices.size() < 5) {
            return false; // Not enough data to determine irregularity
        }

        // Calculate R-R intervals
        double[] rrIntervals = new double[rPeakIndices.size() - 1];
        for (int i = 1; i < rPeakIndices.size(); i++) {
            rrIntervals[i - 1] = (rPeakIndices.get(i) - rPeakIndices.get(i - 1)) / SAMPLING_RATE;
        }

        // Measure variability in R-R intervals (standard deviation)
        double meanRR = java.util.Arrays.stream(rrIntervals).average().orElse(0.0);
        double stdDev = Math.sqrt(java.util.Arrays.stream(rrIntervals)
                .map(rr -> Math.pow(rr - meanRR, 2))
                .average()
                .orElse(0.0));

        return stdDev > 0.1; // Adjust threshold based on testing
    }

    private static boolean isSTElevation(List<Float> filteredValues) {
        // Implement ST-segment elevation detection logic here.
        // For example: Check if signal exceeds a baseline by a significant margin.
        return false;
    }


}
