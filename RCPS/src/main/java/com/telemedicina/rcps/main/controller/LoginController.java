package com.telemedicina.rcps.main.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label txt_warning;
    @FXML
    private PasswordField txt_password;
    @FXML
    private Button bt_click;
    @FXML
    private TextField txt_username;
    @FXML
    private MFXButton bt_forgot;

    private HandlerController handlerController;
    public void setMainController(HandlerController handlerController) {
        this.handlerController = handlerController;
    }
    @FXML
    void clickLogin(ActionEvent event) throws IOException {
        txt_username.setStyle("");
        txt_password.setStyle("");
        bt_click.requestFocus();
        txt_warning.setText("");
        String username = txt_username.getText();
        String password = txt_password.getText();
        boolean empty = false;
        if (username.isEmpty()){
            txt_username.getStyleClass().add("warning");
            empty = true;
        }
        if (password.isEmpty()) {
            txt_password.getStyleClass().add("warning");
            empty = true;
        }
        if (empty){
            txt_warning.setTextFill(Color.RED);
            txt_warning.setText("Enter your credentials");
            bt_forgot.setDisable(false);
            bt_forgot.setVisible(true);
        } else {
            txt_warning.setTextFill(Color.GREEN);
            txt_warning.setText("Successful login: " + username);
            PauseTransition pause = new PauseTransition(Duration.seconds(0.4));
            pause.setOnFinished(e -> {
                handlerController.changeWindow("/com/telemedicina/rcps/fxml/MainScreen.fxml");
            });
            pause.play();

        }
    }
    @FXML
    public void initialize() {
        bt_forgot.setDisable(true);
        bt_forgot.setVisible(false);
    }

    @FXML
    void passwordLogin(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)){
            bt_click.fire();
        }
    }

    @FXML
    void usernameLogin(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)){
            txt_password.requestFocus();
        }
    }

    @FXML
    public void forgotLogin(ActionEvent actionEvent) {
        handlerController.changeWindow("/com/telemedicina/rcps/fxml/PasswordScreen.fxml");
    }
}