package com.telemedicina.rcps.main.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;


public class RegisterController {
    @FXML
    private MFXButton TypeIdContinue;
    @FXML
    private MFXButton SignUp;
    @FXML
    private SplitPane SplitPane;
    @FXML
    private Label TextID;
    @FXML
    private MFXTextField Name;
    @FXML
    private MFXTextField Phone;
    @FXML
    private MFXTextField EmailAddress;
    @FXML
    private MFXTextField Password;
    @FXML
    private MFXTextField ConfirmPassword;
}

