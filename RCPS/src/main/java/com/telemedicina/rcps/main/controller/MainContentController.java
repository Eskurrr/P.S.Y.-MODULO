package com.telemedicina.rcps.main.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainContentController {
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

    @FXML
    private void loadView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/telemedicina/rcps/fxml/" + fxmlFile));
            Pane view = loader.load();
            mainContent.getChildren().clear();
            mainContent.getChildren().add(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        mainContent.prefHeightProperty().bind(screen.heightProperty().subtract(mainMenu.heightProperty()));
        loadView("mybpm.fxml");
    }
    @FXML
    public void myMeasuresClicked(ActionEvent actionEvent) {
        loadView("measurements.fxml");
    }

    @FXML
    public void myBPMClicked(ActionEvent actionEvent) {
        loadView("mybpm.fxml");
    }
}
