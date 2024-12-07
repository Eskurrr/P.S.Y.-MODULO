package com.telemedicina.rcps.main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class PatientController {

    private final StringProperty selectedPatient = new SimpleStringProperty();

    public StringProperty selectedPatientProperty() {
        return selectedPatient;
    }

    public String getSelectedPatient() {
        return selectedPatient.get();
    }

    public void setSelectedPatient(String patient) {
        this.selectedPatient.set(patient);
    }
    @FXML
    private ListView<String> patientListView;
/*

@FXML
    public void initialize() {
        // Populate the ListView
        ObservableList<String> patients = FXCollections.observableArrayList(
                "Patient A", "Patient B", "Patient C"
        );
        patientListView.setItems(patients);

        // Bind selectedPatient to the ListView selection
        patientListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setSelectedPatient(newValue); // Update the property
            }
        }
    }*/
}


