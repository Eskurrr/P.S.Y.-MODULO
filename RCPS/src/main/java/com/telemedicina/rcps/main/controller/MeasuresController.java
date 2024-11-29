package com.telemedicina.rcps.main.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;

public class MeasuresController {
    @FXML
    public MFXButton OverviewBT;
    @FXML
    public LineChart OverviewChart;
    @FXML
    public MFXButton HeartRateBT;
    @FXML
    public LineChart HeartRateChart;
    @FXML
    public MFXButton OxygenBT;
    @FXML
    public LineChart OxygenChart;
    @FXML
    public void OverviewClicked(ActionEvent actionEvent) {
    }
    @FXML
    public void HeartRateClicked(ActionEvent actionEvent) {
    }
    @FXML
    public void OxygenClicked(ActionEvent actionEvent) {
    }
}
