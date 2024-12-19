package com.telemedicina.rcps.main.controller;

import com.telemedicina.rcps.main.Connection.ConnectionClient;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import java.util.List;

public class MeasuresController {
    @FXML
    public NumberAxis Yax;
    @FXML
    public CategoryAxis Xax;
    @FXML
    public LineChart<Number, Number> Chart;
    @FXML
    public MenuButton menu;
    @FXML
    public MenuItem option1;
    @FXML
    public MenuItem option2;
    private final XYChart.Series<Number, Number> series = new XYChart.Series<>();
    protected ConnectionClient client;
    public ConnectionClient getClient() {
        return client;
    }
    public void setClient(ConnectionClient client) {
        this.client = client;
    }
    @FXML
    public void initialize() {
        Chart();
    }
    @FXML
    public void Chart(){
        List<Float> data = client.getData();
        for (int i = 0; i < data.size(); i++) {
            series.getData().add(new XYChart.Data<>(i, data.get(i)));
        }
    }
}
