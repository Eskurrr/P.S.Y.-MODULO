package com.telemedicina.pabloescudero.main;

import com.telemedicina.pabloescudero.main.controller.MainController;
import com.telemedicina.pabloescudero.main.controller.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage Pstage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/telemedicina/pabloescudero/fxml/MenuScreen.fxml"));
        Parent root = loader.load();
        MainController mainController = new MainController(Pstage);
        MenuController menuController = loader.getController();
        menuController.setMainController(mainController);

        Pstage.setScene(new Scene(root));
        Pstage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}