package com.telemedicina.rcps.main.controller;

import com.telemedicina.rcps.main.data.Users;
import com.telemedicina.rcps.main.data.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class PatientListController extends Users {

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

    public void DisplayUser(Usuario User){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/telemedicina/rcps/fxml/UserDisplayScreen.fxml"));
            Pane view = loader.load();
            UserDisplayController display = loader.getController();
            display.setUserDisplayed(User);
            //mainContent.getChildren().clear();
            //mainContent.getChildren().add(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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


