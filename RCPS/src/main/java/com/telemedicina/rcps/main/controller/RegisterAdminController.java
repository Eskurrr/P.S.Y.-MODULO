package com.telemedicina.rcps.main.controller;

import com.telemedicina.rcps.main.HelloApplication;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


public class RegisterAdminController {

    @FXML
    public MFXButton adminRegister;
    @FXML
    private Label adminWarning;
    @FXML
    private MFXTextField adminConfirmP;
    @FXML
    private MFXTextField adminPassword;
    @FXML
    private MFXTextField adminMail;
    @FXML
    private MFXTextField adminNumber;
    @FXML
    private MFXTextField adminName;
    @FXML
    public void adminRegister_click(ActionEvent actionEvent) {
        adminNumber.setStyle("");
        adminName.setStyle("");
        adminMail.setStyle("");
        adminPassword.setStyle("");
        adminConfirmP.setStyle("");
        adminRegister.requestFocus();
        String name = adminName.getText();
        String number = adminNumber.getText();
        String email = adminMail.getText();
        String password = adminPassword.getText();
        String cpassword = adminConfirmP.getText();
        boolean empty = false;
        if (number.isEmpty()){
            adminNumber.getStyleClass().add("warning");
            empty = true;
        }
        if (name.isEmpty()){
            adminName.getStyleClass().add("warning");
            empty = true;
        }
        if (email.isEmpty()){
            adminMail.getStyleClass().add("warning");
            empty = true;
        }
        if (password.isEmpty()) {
            adminPassword.getStyleClass().add("warning");
            empty = true;
        }
        if (cpassword.isEmpty()) {
            adminConfirmP.getStyleClass().add("warning");
            empty = true;
        }

        if (empty){
            adminWarning.setTextFill(Color.RED);
            adminWarning.setText("Enter your information");

        } else if(!password.equals(cpassword)){
            adminWarning.setTextFill(Color.RED);
            adminWarning.setText("Your passwords do not match");

        }
        else {
            adminWarning.setTextFill(Color.GREEN);
            adminWarning.setText("Successful registration!");
            PauseTransition pause = new PauseTransition(Duration.seconds(0.4));
            pause.setOnFinished(e -> {
                HelloApplication app = new HelloApplication();
                try {
                    app.start((Stage) adminRegister.getScene().getWindow());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            pause.play();


        }
    }
}

