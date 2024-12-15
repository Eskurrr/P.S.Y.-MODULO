package com.telemedicina.rcps.main.controller;


import com.telemedicina.rcps.main.data.*;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class LoginController extends Users {
    @FXML
    public MFXButton bt_CreateAcc;
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
    @FXML
    void clickLogin(ActionEvent event) throws IOException {
        AdminUsersCreate();
        txt_username.setStyle("");
        txt_password.setStyle("");
        bt_click.requestFocus();
        txt_warning.setText("");
        String username = txt_username.getText();
        String password = txt_password.getText();
        boolean empty = false;
        if (username.length() != 8) {
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
        }
        else {
            char[] id = username.toCharArray();
            String type = SearchType(id);
            Usuario user = SearchUsuario(id);
            if(user == null) {
                txt_warning.setTextFill(Color.RED);
                txt_username.getStyleClass().add("warning");
                txt_warning.setText("This user does not exist");
                bt_forgot.setDisable(false);
                bt_forgot.setVisible(true);
            } else {
                if(!user.getPassword().equals(password)) {
                    txt_warning.setTextFill(Color.RED);
                    txt_password.getStyleClass().add("warning");
                    txt_warning.setText("Your credentials are incorrect");
                    bt_forgot.setDisable(false);
                    bt_forgot.setVisible(true);
                } else {
                    txt_warning.setTextFill(Color.GREEN);
                    txt_warning.setText("Successful login: " + username);
                    setIDMainUser(id);
                    if(type.equals("Medico")){
                        Medico m = SearchMedico(id);
                        setMainUser(m);
                    }else if(type.equals("Enfermero")){
                        Enfermero e = SearchEnfermero(id);
                        setMainUser(e);
                    }else if (type.equals("Paciente")){
                        Paciente p = SearchPaciente(id);
                        setMainUser(p);
                    }
                    PauseTransition pause = new PauseTransition(Duration.seconds(0.4));
                    pause.setOnFinished(e -> {
                        changeWindow("/com/telemedicina/rcps/fxml/MainScreen.fxml");
                    });
                    pause.play();
                }
            }


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
    public void AdminUsersCreate(){
        String ID = "2345";
        String IDm = "1111" + ID;
        Medico medico = new Medico("Pablo Escudero",20 , "676772328" , "juegosescu@gmail.com" , IDm.toCharArray() ,  "a" );
        addToAll(medico);
        String IDe = "2222" + ID;
        Enfermero enfermero = new Enfermero("Sawai Davila", 19 , "647040857" , "sawaidavila@gmail.com" , IDe.toCharArray() ,  "a" );
        addToAll(enfermero);
        String IDp = "3333" + ID;
        Paciente paciente = new Paciente("Carolina Beatrice" , 22 , "650114244" , "Calle Caribe 2 , 11A" , "arritmia" , "carolina@gmail.com" , IDp.toCharArray() ,  "a" );
        addToAll(paciente);
        int[] measure = {515, 520, 510, 525, 518, 512, 530, 510, 525, 518, 512, 510, 520, 525, 530, 535, 532, 518, 512, 510,
                515, 520, 525, 518, 512, 510, 530, 525, 520, 518, 510, 510, 520, 525, 530, 535, 532, 518, 512, 510,
                510, 520, 525, 518, 512, 510, 530, 525, 520, 518, 510, 510, 520, 525, 530, 535, 532, 518, 512, 510,
                515, 520, 525, 518, 512, 510, 530, 525, 520, 518, 510, 510, 520, 525, 530, 535, 532, 518, 512, 510};
        String IDd = "4444" + ID;
        Dispositivo device = new Dispositivo(IDd, "33332345" , false, "22/12/2024" , measure , 40);
        addToAll(device);
        AssignDevice(IDd.toCharArray(), IDp.toCharArray());
        getRelaciones().add(new Relation(IDm.toCharArray(),IDe.toCharArray()));
        getRelaciones().add(new Relation(IDm.toCharArray(),IDp.toCharArray()));
        getRelaciones().add(new Relation(IDe.toCharArray(),IDp.toCharArray()));
    }
    public void changeWindow(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.initModality(Modality.WINDOW_MODAL);
            Stage stage = (Stage) bt_click.getScene().getWindow();
            stage.close();
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void forgotLogin(ActionEvent actionEvent) {
        changeWindow("/com/telemedicina/rcps/fxml/ForgotPasswordScreen.fxml");
    }

    public void CreateAccount(ActionEvent actionEvent) {
        changeWindow("/com/telemedicina/rcps/fxml/RegisterIDScreen.fxml");
    }
}