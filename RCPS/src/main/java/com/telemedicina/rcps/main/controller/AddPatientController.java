package com.telemedicina.rcps.main.controller;


import com.telemedicina.rcps.main.data.Paciente;
import com.telemedicina.rcps.main.data.Users;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class AddPatientController extends Users {
    @FXML
    private TextField nameField, ageField, emailField, diagnosticField, phoneField, addressField;
    @FXML
    private Button addPatientButton;
    @FXML
    public void initialize() {
    }

    @FXML
    private void handleAddPatient(){
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String telefono = phoneField.getText();
        String address = addressField.getText();
        String diagnostic = diagnosticField.getText();
        String id = "0000";

        if (name.isEmpty()  || address.isEmpty() || diagnostic.isEmpty() || age == 0 || telefono.isEmpty()){
            showAlert("Validation Error", "Please fill in all required fields.");
            return;
        }

        try {
            if (age < 0 ) {
                showAlert ("Validation Error", "Age cannot be negative.");
                return;
            }
            } catch (NumberFormatException e){
            showAlert("Validation error", "Please, enter a valid age");
            return;
        }

        Paciente pt = new Paciente (name,  age,  telefono,  address,  diagnostic ,  id);

        System.out.println("Patient added: " + name);
        showAlert("Success", "Patient added successfully!");
        clearFields();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields (){
        nameField.clear();
        ageField.clear();
        phoneField.clear();
        addressField.clear();
        diagnosticField.clear();

    }

}

