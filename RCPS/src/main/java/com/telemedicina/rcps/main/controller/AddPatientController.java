package com.telemedicina.rcps.main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
public class AddPatientController {
    @FXML
    private TextField nameField, ageField, emailField, diagnosticField, phoneField, addressField;
    @FXML
    private ChoiceBox<String> sexChoiceBox;
    @FXML
    private Button addPatientButton;

    @FXML
    private void handleAddPatient(){
        String name = nameField.getText();
        String sex = sexChoiceBox.getValue();
        String age = ageField.getText();
        String email = emailField.getText();
        String diagnostic = diagnosticField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();

        if (name.isEmpty() || age.isEmpty() || phone.isEmpty()){
            showAlert("Validation Error", "Please fill in all required fields.");
            return;
        }

        System.out.println("Patient added: " + name);
        showAlert("Success", "Patient added successfully!");

    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
