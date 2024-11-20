package com.telemedicina.rcps.main.controller;

import data.Paciente;
import data.Users;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class AddPatientController extends Users {
    @FXML
    private TextField nameField, ageField, emailField, diagnosticField, phoneField, addressField;
    @FXML
    private ChoiceBox<String> sexChoiceBox;
    @FXML
    private Button addPatientButton;

    @FXML
    private void handleAddPatient(){
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String telefono = phoneField.getText();
        String address = addressField.getText();
        String diagnostic = diagnosticField.getText();
        String id = "0000";

        Paciente pt = new Paciente(name,  age,  telefono,  address,  diagnostic ,  id);



        if (name.isEmpty() || age == 0 || telefono.isEmpty()){
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
