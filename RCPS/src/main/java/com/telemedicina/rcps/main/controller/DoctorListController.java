package com.telemedicina.rcps.main.controller;

import com.telemedicina.rcps.main.data.Users;
import com.telemedicina.rcps.main.data.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DoctorListController extends Users {

    public void DisplayUser(Usuario User){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/telemedicina/rcps/fxml/UserDisplayScreen.fxml"));
            Pane view = loader.load();
            UserDisplayController display = loader.getController();
            display.setUserDisplayed(User);
            //mainContent.getChildren().clear();
            //mainContent.getChildren().add(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
