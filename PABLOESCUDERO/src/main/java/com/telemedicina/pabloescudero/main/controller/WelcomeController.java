package com.telemedicina.pabloescudero.main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WelcomeController {

    @FXML
    private TextField search_fld;

    @FXML
    private Label user_lb;

    @FXML
    private ContextMenu user_menu;

    @FXML
    public void initialize() {
        // Initially disable focus on the TextField
        search_fld.setFocusTraversable(false);
    }
}
