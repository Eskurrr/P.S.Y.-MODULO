package com.telemedicina.rcps.main.controller;

import com.telemedicina.rcps.main.data.*;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.mfxcore.controls.Text;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.controlsfx.control.textfield.CustomTextField;

public class MyInfoController extends Users {
    @FXML
    public MFXButton ChangesBt;
    @FXML
    public Text AdressLBL;
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
    protected Usuario userM;
    @FXML
    public void initialize() {
        userM = getMainUser();
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
                AdressLBL.setVisible(false);
            }else if(userM instanceof Medico){
                Medico user = (Medico) userM;
                NameField.setText(user.getNombre());
                AgeField.setText(Integer.toString(user.getEdad()));
                EmailField.setText(user.getCorreo());
                PhoneField.setText(user.getTelefono());
                AdressField.setVisible(false);
                AdressLBL.setVisible(false);
            }
        }else{
            NameField.setText("null");
            AgeField.setText("null");
            EmailField.setText("null");
            PhoneField.setText("null");
            AdressField.setText("null");
        }
    }
    @FXML
    public void ChangesClicked(ActionEvent actionEvent) {
        userM = getMainUser();
        String name = NameField.getText();
        if(AgeField.getText().isEmpty()){
            AgeField.setText("0");
        }
        int age = Integer.parseInt(AgeField.getText());
        String address = AdressField.getText();
        String email = EmailField.getText();
        String phone = PhoneField.getText();
        if (userM != null) {
            if(userM instanceof Paciente){
                Paciente userP = (Paciente) userM;
                getPacientes().set(SearchID(getPacientes(),userM.getId()), new Paciente (name,age,phone,address,userP.getDiagnostico(),email,userM.getId(),userM.getPassword()));
                setMainUser(userP);
            }else if(userM instanceof Enfermero){
                Enfermero userE = (Enfermero) userM;
                getEnfermeros().set(SearchID(getEnfermeros(),userM.getId()), new Enfermero (name,age,phone,email,userM.getId(),userM.getPassword()));
                setMainUser(userE);
            }else if(userM instanceof Medico){
                Medico userMe = (Medico) userM;
                getMedicos().set(SearchID(getMedicos(),userM.getId()), new Medico (name,age,phone,email,userM.getId(),userM.getPassword()));
                setMainUser(userMe);
            }
        }
    }
}
