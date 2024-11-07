package com.telemedicina.pabloescudero.main.controller;


import io.github.palexdev.materialfx.controls.MFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;


public class MainController {
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
    public void initialize() {
        menuIcon.setIcon(FontAwesome.Glyph.BARS);
        mainMenu.prefHeight(60);
        mainContent.prefWidthProperty().bind(screen.widthProperty().subtract(sidePanel.widthProperty()));
        mainMenu.prefWidthProperty().bind(screen.widthProperty().subtract(sidePanel.widthProperty()));
        mainContent.prefHeightProperty().bind(screen.heightProperty().subtract(mainMenu.heightProperty()));
    }
    @FXML
    public void toggleMenu(ActionEvent actionEvent) {
        if (!bt_menu.isSelected()) {
            sidePanel.setPrefWidth(0); // Collapse the side panel
            sidePanel.setVisible(false);
        }else {
        sidePanel.setPrefWidth(200); // Expand the side panel
        sidePanel.setVisible(true);
    }
    }
    @FXML
    public void iconClicked(MouseEvent mouseEvent) {
        bt_menu.fire();
    }
}
