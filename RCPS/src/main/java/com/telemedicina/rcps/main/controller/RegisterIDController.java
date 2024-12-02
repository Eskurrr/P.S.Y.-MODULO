package com.telemedicina.rcps.main.controller;

import com.telemedicina.rcps.main.data.Users;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


public class RegisterIDController extends Users {
    @FXML
    private Label typeID_empty;
    @FXML
    private MFXTextField TypeIDText;
    @FXML
    public MFXButton continue_click;
    @FXML
    void clickContinue(ActionEvent actionEvent) throws IOException {
        TypeIDText.setStyle("");
        String typeID = TypeIDText.getText();
        continue_click.requestFocus();
        boolean empty = false;
        if (typeID.isEmpty()) {
            TypeIDText.getStyleClass().add("warning");
            empty = true;
        }
        if (empty) {
            typeID_empty.setTextFill(Color.RED);
            typeID_empty.setText("Enter your type id to continue");
            typeID_empty.setDisable(false);
            typeID_empty.setVisible(true);
        } else if (typeID.equals("1111")) {
            typeID_empty.setTextFill(Color.GREEN);
            typeID_empty.setText("Welcome to RCPS");
            PauseTransition pause = new PauseTransition(Duration.seconds(0.4));
            pause.setOnFinished(e -> {
                changeWindow("/com/telemedicina/rcps/fxml/RegisterPatientScreen.fxml");
            });
            pause.play();

        } else if (typeID.equals("2222")) {
            typeID_empty.setTextFill(Color.GREEN);
            typeID_empty.setText("Welcome to RCPS");
            PauseTransition pause = new PauseTransition(Duration.seconds(0.4));
            pause.setOnFinished(e -> {
                changeWindow("/com/telemedicina/rcps/fxml/RegisterAdminScreen.fxml");
            });
            pause.play();
        } else {
            typeID_empty.setTextFill(Color.RED);
            typeID_empty.setText("Your Type ID is incorrect");

        }
    }
    public void changeWindow(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.initModality(Modality.WINDOW_MODAL);
            Stage stage = (Stage) continue_click.getScene().getWindow();
            stage.close();
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ID_Clicked(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            continue_click.fire();
        }
    }
}