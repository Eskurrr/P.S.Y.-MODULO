package com.telemedicina.rcps.main.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class PasswordController {
    @FXML
    private MFXTextField txt_email;
    @FXML
    private MFXButton bt_send;
    @FXML
    private Label lbl_ok;

    @FXML
    public void EmailLogin(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)){
            bt_send.fire();
        }
    }

    @FXML
    public void ClickSend(ActionEvent actionEvent) throws IOException {
        lbl_ok.setText("Email Sent to: " + txt_email.getText());
    }
}
