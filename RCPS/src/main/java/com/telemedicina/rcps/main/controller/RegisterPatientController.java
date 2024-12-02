package com.telemedicina.rcps.main.controller;

import com.telemedicina.rcps.main.HelloApplication;
import com.telemedicina.rcps.main.data.Users;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class RegisterPatientController extends Users{
    @FXML
    public MFXButton signup_click;
    @FXML
    public Label warning_label;
    @FXML
    private MFXTextField cpassword_text;
    @FXML
    private MFXTextField password_text;
    @FXML
    private MFXTextField email_text;
    @FXML
    public void clickRegister(ActionEvent actionEvent) {
        email_text.setStyle("");
        password_text.setStyle("");
        cpassword_text.setStyle("");
        String email = email_text.getText();
        String password = password_text.getText();
        String cpassword = cpassword_text.getText();
        boolean empty = false;
        if (email.isEmpty()){
            email_text.getStyleClass().add("warning");
            empty = true;
        }
        if (password.isEmpty()) {
            password_text.getStyleClass().add("warning");
            empty = true;
        }
        if (cpassword.isEmpty()) {
            cpassword_text.getStyleClass().add("warning");
            empty = true;
        }
        if (empty){
            warning_label.setTextFill(Color.RED);
            warning_label.setText("Enter your information");

        } else if(!password.equals(cpassword)){

           warning_label.setTextFill(Color.RED);
           warning_label.setText("Your passwords do not match");
           }
        else {
            warning_label.setTextFill(Color.GREEN);
            warning_label.setText("Successful registration!");
            PauseTransition pause = new PauseTransition(Duration.seconds(0.4));
            pause.setOnFinished(e -> {
                HelloApplication app = new HelloApplication();
                try {
                    app.start((Stage) signup_click.getScene().getWindow());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            pause.play();


        }

    }
}
