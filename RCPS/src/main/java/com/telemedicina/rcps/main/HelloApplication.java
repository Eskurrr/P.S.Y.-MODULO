package com.telemedicina.rcps.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage Pstage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/telemedicina/rcps/fxml/MainScreen.fxml"));
        Parent root = loader.load();
        Pstage.setScene(new Scene(root));
        Pstage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}