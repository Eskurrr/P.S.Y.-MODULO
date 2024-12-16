package com.telemedicina.rcps.main.controller;

import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

public class MeasurementsController {
    @FXML
    public NumberAxis lineY;
    @FXML
    public CategoryAxis lineX;
    @FXML
    public LineChart loneChart;
    @FXML
    public MFXComboBox buttonClick;
    @FXML
    public void changeChart(ActionEvent actionEvent) {

    }
}
