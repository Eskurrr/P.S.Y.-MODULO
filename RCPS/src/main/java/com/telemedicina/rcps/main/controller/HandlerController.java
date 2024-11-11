package com.telemedicina.rcps.main.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HandlerController {
    private Stage stage;

    public HandlerController(Stage stage) {
        this.stage = stage;
    }

    public void changeWindow(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(stage);
            stage.close();
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
