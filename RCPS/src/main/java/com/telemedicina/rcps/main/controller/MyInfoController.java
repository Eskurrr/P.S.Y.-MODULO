package com.telemedicina.rcps.main.controller;

import com.telemedicina.rcps.main.data.*;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.controlsfx.control.textfield.CustomTextField;

public class MyInfoController extends Users {
    @FXML
    public MFXButton ChangesBt;
    @FXML
    private CustomTextField AdressField;
    @FXML
    private CustomTextField NameField;
    @FXML
    private CustomTextField AgeField;
    @FXML
    private CustomTextField EmailField;
    @FXML
    private CustomTextField PhoneField;

    @FXML
    public void initialize() {
        Usuario userM = getMainUser();
        if (userM != null) {
            if(userM instanceof Paciente){
                Paciente user = (Paciente) userM;
                NameField.setText(user.getNombre());
                AgeField.setText(Integer.toString(user.getEdad()));
                EmailField.setText(user.getCorreo());
                PhoneField.setText(user.getTelefono());
                AdressField.setText(user.getAddress());
            }else if(userM instanceof Enfermero){
                Enfermero user = (Enfermero) userM;
                NameField.setText(user.getNombre());
                AgeField.setText(Integer.toString(user.getEdad()));
                EmailField.setText(user.getCorreo());
                PhoneField.setText(user.getTelefono());
                AdressField.setVisible(false);
            }else if(userM instanceof Medico){
                Medico user = (Medico) userM;
                NameField.setText(user.getNombre());
                AgeField.setText(Integer.toString(user.getEdad()));
                EmailField.setText(user.getCorreo());
                PhoneField.setText(user.getTelefono());
                AdressField.setVisible(false);
            }
        }else{
            NameField.setText("");
            AgeField.setText("");
            EmailField.setText("");
            PhoneField.setText("");
            AdressField.setText("");
        }
    }
    @FXML
    public void ChangesClicked(ActionEvent actionEvent) {
        Usuario userM = getMainUser();
        String name = NameField.getText();
        String age = AgeField.getText();
        String address = AdressField.getText();
        String email = EmailField.getText();
        String phone = PhoneField.getText();
        
    }
}
