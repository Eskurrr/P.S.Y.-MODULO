package com.telemedicina.rcps.main;

import com.telemedicina.rcps.main.controller.HandlerController;
import com.telemedicina.rcps.main.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage Pstage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/telemedicina/rcps/fxml/LoginScreen.fxml"));
        Parent root = loader.load();
        HandlerController handlerController = new HandlerController(Pstage);
        LoginController loginController = loader.getController();
        loginController.setMainController(handlerController);

        Pstage.setScene(new Scene(root));
        Pstage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}