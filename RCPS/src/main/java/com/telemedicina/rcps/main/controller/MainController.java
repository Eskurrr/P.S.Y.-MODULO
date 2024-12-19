package com.telemedicina.rcps.main.controller;

import com.telemedicina.rcps.main.Connection.ConnectionClient;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainController {
    @FXML
    public StackPane mainContent;
    @FXML
    public MFXButton myBPM;
    @FXML
    public MFXButton myMeasures;
    @FXML
    public AnchorPane screen;
    @FXML
    public GridPane mainMenu;
    protected ConnectionClient client;
    public ConnectionClient getClient() {
        return client;
    }
    public void setClient(ConnectionClient client) {
        this.client = client;
    }
    public void Start(){
        client = new ConnectionClient("192.168.1.100" , 12345);
        client.start();
    }
    @FXML
    private void loadViewBPM() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/telemedicina/rcps/fxml/BPMScreen.fxml"));
            Pane view = loader.load();
            BPMController control = loader.getController();
            control.setClient(getClient());
            mainContent.getChildren().clear();
            mainContent.getChildren().add(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void loadViewMeasures() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/telemedicina/rcps/fxml/MeasuresScreen.fxml"));
            Pane view = loader.load();
            MeasuresController control = loader.getController();
            control.setClient(getClient());
            mainContent.getChildren().clear();
            mainContent.getChildren().add(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        mainContent.prefHeightProperty().bind(screen.heightProperty().subtract(mainMenu.heightProperty()));
        Start();
        loadViewBPM();
    }
    @FXML
    public void myMeasuresClicked(ActionEvent actionEvent) {
        loadViewMeasures();
    }

    @FXML
    public void myBPMClicked(ActionEvent actionEvent) {
        loadViewBPM();
    }
}
