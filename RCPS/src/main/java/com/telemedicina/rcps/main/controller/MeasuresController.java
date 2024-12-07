package com.telemedicina.rcps.main.controller;

import com.telemedicina.rcps.main.data.Dispositivo;
import com.telemedicina.rcps.main.data.Users;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.List;

public class MeasuresController extends Users {
    @FXML
    public MFXButton OverviewBT;
    @FXML
    public LineChart<Number, Number> OverviewChart;
    @FXML
    public MFXButton HeartRateBT;
    @FXML
    public LineChart<Number, Number> HeartRateChart;
    @FXML
    public MFXButton OxygenBT;
    @FXML
    public LineChart<Number, Number> OxygenChart;
    public List<int[]> measures;
    @FXML
    public void initialize() {
        char[] id = getIDMainUser();
        List<Dispositivo> MedidasP = SearchPatientMeasures(id);

     //   OverviewChart.getData().clear();
        //   OverviewChart.getData().add(drawData(measures.get(1)));
    }

    public XYChart.Series<Number, Number> drawData(int[] data){
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        for (int i = 0; i < data.length; i++) {
            series.getData().add(new XYChart.Data<>(i, data[i]));
        }
        return series;
    }

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
