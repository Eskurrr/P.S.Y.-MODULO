package com.telemedicina.rcps.main.controller;

import com.telemedicina.rcps.main.HelloApplication;
import com.telemedicina.rcps.main.data.Enfermero;
import com.telemedicina.rcps.main.data.Medico;
import com.telemedicina.rcps.main.data.Paciente;
import com.telemedicina.rcps.main.data.Users;
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
import java.util.Arrays;


public class RegisterAdminController extends Users {

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
        char[] typeID = getIDMainUser();
        String fullID = Arrays.toString(typeID);
        String code = fullID.substring(4, 8);

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
            if (typeID[0] == 2){
                Enfermero nurse = (Enfermero) getMainUser();
                nurse.setNombre(name);
                nurse.setTelefono(number);
                nurse.setPassword(password);
                nurse.setCorreo(email);
            }
            if (typeID[0] == 1){
                Medico medic = (Medico) getMainUser();
                medic.setNombre(name);
                medic.setTelefono(number);
                medic.setPassword(password);
                medic.setCorreo(email);
            }

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

