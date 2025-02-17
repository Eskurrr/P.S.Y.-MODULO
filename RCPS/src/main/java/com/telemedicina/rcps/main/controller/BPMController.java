package com.telemedicina.rcps.main.controller;


import com.telemedicina.rcps.main.Connection.ConnectionClient;
import com.telemedicina.rcps.main.data.Devices;
import com.telemedicina.rcps.main.data.Dispositivo;
import com.telemedicina.rcps.main.data.Json;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.time.LocalDate;
import java.util.List;


public class BPMController extends Devices {
    @FXML
    public LineChart<String, Number> ECG;
    @FXML
    public Label bpm;
    @FXML
    public ImageView heart;
    @FXML
    public CategoryAxis Xaxis;
    @FXML
    public NumberAxis Yaxis;
    protected int lastIndex;
    protected XYChart.Series<String, Number> ecgSeries = new XYChart.Series<>();
    protected ConnectionClient client;

    public ConnectionClient getClient() {
        return client;
    }

    public void setClient(ConnectionClient client) {
        this.client = client;
    }

    @FXML
    public void initializeManually() {
        ECG.getData().clear();
        ECG.getData().add(ecgSeries);
        ECG.setCreateSymbols(false);
        BPManimation();
        lastIndex = 0;
        startChartUpdateLoop();
    }

    public void BPManimation(){
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), heart);
        scaleTransition.setFromX(1.0); // Original size
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(1.2); // Grown size
        scaleTransition.setToY(1.2);
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }

    public void startChartUpdateLoop() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), event -> {
            update();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
            updateBPM();
        }));
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();
    }
    @FXML
    public void updateBPM() {
        if(lastIndex < getClient().getBpms().size()){
            String BPM = String.valueOf(getClient().getBpms().get(lastIndex));
            bpm.setText(BPM);
        }
    }
    @FXML
    public void update() {
        if (lastIndex < getClient().getData().size() && !getClient().isStop()) {
            float value = getClient().getData().get(lastIndex);
            ecgSeries.getData().add(new XYChart.Data<>(String.valueOf(lastIndex), value));
            if (ecgSeries.getData().size() > 40) {
                ecgSeries.getData().remove(0);
            }
            lastIndex++;
        }
    }


}
