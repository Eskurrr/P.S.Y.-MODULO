package com.telemedicina.rcps.main.controller;


import data.Users;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import java.io.IOException;
import static org.controlsfx.glyphfont.FontAwesome.Glyph.*;


public class MainController extends Users {
    @FXML
    public VBox sidePanel;
    @FXML
    public StackPane mainContent;
    @FXML
    public AnchorPane screen;
    @FXML
    public HBox mainMenu;
    @FXML
    public MFXRadioButton bt_menu;
    @FXML
    public Glyph menuIcon;
    @FXML
    public Glyph DevicesIcon;
    @FXML
    public MFXRadioButton DevicesButton;
    @FXML
    public Glyph PatientsIcon;
    @FXML
    public MFXRadioButton PatientsButton;
    @FXML
    public ToggleGroup maintoggle;
    @FXML
    public Glyph NurseIcon;
    @FXML
    public MFXRadioButton NursesButton;

    @FXML
    public void initialize() {
        SidePanelSetup();
        icons();
        DevicesButton.setSelected(true);
        loadView("DevicesScreen.fxml");
    }
    @FXML
    public void toggleMenu(ActionEvent actionEvent) {
        if (!bt_menu.isSelected()) {
            sidePanel.setPrefWidth(0); // Collapse the side panel
            sidePanel.setVisible(false);
        }else {
        sidePanel.setPrefWidth(160); // Expand the side panel
        sidePanel.setVisible(true);
        System.out.println("WIDTH:" + mainContent.getWidth());
        System.out.println("HEIGHT:" + mainContent.getHeight());
    }
    }
    @FXML
    public void SidePanelSetup (){
        mainMenu.setPrefHeight(60);
        sidePanel.setPrefWidth(160);
        sidePanel.setMinWidth(0);
        mainContent.prefWidthProperty().bind(screen.widthProperty().subtract(sidePanel.widthProperty()));
        mainMenu.prefWidthProperty().bind(screen.widthProperty().subtract(sidePanel.widthProperty()));
        mainContent.prefHeightProperty().bind(screen.heightProperty().subtract(mainMenu.heightProperty()));
    }
    private void loadView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/telemedicina/rcps/fxml/" + fxmlFile));
            Pane view = loader.load();
            mainContent.getChildren().clear();
            mainContent.getChildren().add(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void icons(){
        IconSetup(menuIcon , BARS);
        IconSetup(PatientsIcon , USER);
        IconSetup(DevicesIcon , MOBILE_PHONE);
        IconSetup(NurseIcon , HOSPITAL_ALT);
    }
    @FXML
    public void IconSetup (Glyph icon , FontAwesome.Glyph glph){
        icon.setIcon(glph);
        MFXRadioButton Rbt = (MFXRadioButton) icon.getGraphic();
        icon.setOnMouseClicked(MouseEvent -> Rbt.fire());
    }
    @FXML
    public void PatientsClicked(ActionEvent actionEvent) {
        loadView("AddPatientScreen.fxml");
    }
    @FXML
    public void NursesClicked(ActionEvent actionEvent) {

    }
    @FXML
    public void DevicesClicked(ActionEvent actionEvent) {
        loadView("DevicesScreen.fxml");
    }
}
