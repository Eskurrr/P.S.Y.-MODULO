package com.telemedicina.rcps.main.controller;

import com.telemedicina.rcps.main.Connection.ConnectionClient;
import com.telemedicina.rcps.main.data.Devices;
import com.telemedicina.rcps.main.data.Dispositivo;
import com.telemedicina.rcps.main.data.Json;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import java.time.LocalDate;
import java.util.List;

public class MeasuresController extends Devices {
    @FXML
    public NumberAxis Yax;
    @FXML
    public CategoryAxis Xax;
    @FXML
    public LineChart<String, Number> Chart;
    @FXML
    public MFXButton backButton;
    @FXML
    public Label dateLabel;
    @FXML
    public MFXButton forwardButton;
    @FXML
    public Label DiagnosticLBL;
    protected ConnectionClient client;
    protected int position;
    private List<Dispositivo> measures;
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
        measures = SearchECGMeasures();
        if(measures != null  && !measures.isEmpty()) {
            dateLabel.setText(measures.get(measures.size() - 1).getDate());
            position = measures.size() - 1;
            drawECG();
            if(position == measures.size() - 1){
                forwardButton.setVisible(false);
            }
            if(position == 0){
                backButton.setVisible(false);
            }
        }
    }
    @FXML
    public void drawECG() {
        if (position >= 0 && position < measures.size()) {
            List<Float> ecgData = measures.get(position).getMedida();
            DiagnosticLBL.setText(diagnoseECG(ecgData));
            XYChart.Series<String, Number> ecgSeries = new XYChart.Series<>();

            for (int i = 0; i < ecgData.size(); i++) {
                ecgSeries.getData().add(new XYChart.Data<>(String.valueOf(i), ecgData.get(i)));
            }


            Chart.getData().clear();
            Chart.getData().add(ecgSeries);
            Chart.setCreateSymbols(false);
        }
        if(getClient().isStop()){
            getDispositivos().add(new Dispositivo(false, String.valueOf(LocalDate.now()) , getClient().getData(), getClient().getBpms() ));
            Json json = new Json();
            json.Serializar(getDispositivos());
        }
    }

    public String diagnoseECG(List<Float> filteredValues) {
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
        if (diagnosis.isEmpty()) {
            diagnosis.append("No significant pathology detected.");
        }

        return diagnosis.toString();
    }
    public List<Integer> detectRPeaks(List<Float> filteredValues) {
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

    public double calculateHeartRate(List<Integer> rPeakIndices) {
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

    public boolean isIrregularRhythm(List<Integer> rPeakIndices) {
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

    public boolean isSTElevation(List<Float> filteredValues) {
        // Implement ST-segment elevation detection logic here.
        // For example: Check if signal exceeds a baseline by a significant margin.
        return false;
    }


    @FXML
    public void clickBack(ActionEvent actionEvent) {
        if (position > 0) {
            backButton.setVisible(true);
            position--;
            dateLabel.setText(measures.get(position).getDate());
            drawECG();
            if(position == 0){
                backButton.setVisible(false);
            }
        }else {
            backButton.setVisible(false);
        }
        if (position < measures.size() - 1) {
            forwardButton.setVisible(true);
        }
    }

    @FXML
    public void clickForward(ActionEvent actionEvent) {
        if (position < measures.size() - 1) {
            forwardButton.setVisible(true);
            position++;
            dateLabel.setText(measures.get(position).getDate());
            drawECG();
            if(position == measures.size() - 1){
                forwardButton.setVisible(false);
            }
        } else {
            forwardButton.setVisible(false);
        }
        if (position > 0) {
            backButton.setVisible(true);
        }
    }
}
