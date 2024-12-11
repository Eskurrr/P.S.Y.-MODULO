package com.telemedicina.rcps.main.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.enums.ButtonType;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import org.controlsfx.glyphfont.Glyph;
import java.util.Objects;
public class ContactController {
    @FXML
    GridPane DevicePane;
    @FXML
    public MFXButton addDevice( String id , String Dname , String UName , String NName) {
        // Step 2.1: Initialize the button
        MFXButton button = new MFXButton();
        button.setAlignment(Pos.CENTER);
        button.setButtonType(ButtonType.RAISED);
        button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        button.setPrefSize(379, 260);
        button.setStyle("-fx-background-radius: 40; -fx-border-radius: 40; -fx-background-color: #BBA0FF88;");
        button.getStyleClass().add("mfx-button");
        button.setId(id);
// Step 3.1: Initialize the GridPane
        GridPane gridPane = new GridPane();

// Step 3.2: Configure column constraints
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.SOMETIMES);
        col1.setPrefWidth(111.33);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.SOMETIMES);
        col2.setPrefWidth(135.33);

        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHgrow(Priority.SOMETIMES);
        col3.setPrefWidth(117.99);

        gridPane.getColumnConstraints().addAll(col1, col2, col3);

// Step 3.3: Configure row constraints
        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(81);

        RowConstraints row2 = new RowConstraints();
        row2.setPrefHeight(111);

        RowConstraints row3 = new RowConstraints();
        row3.setPrefHeight(58.66);

        gridPane.getRowConstraints().addAll(row1, row2, row3);
// Step 4.1: Add labels
        Label DLabel = new Label("DEVICE:");
        GridPane.setHalignment(DLabel, HPos.RIGHT);
        GridPane.setMargin(DLabel, new Insets(0, 20, 0, 0));

        Label DName = new Label(Dname);
        DName.setFont(new Font(24));
        GridPane.setColumnIndex(DName, 1);
        GridPane.setHalignment(DName, HPos.CENTER);
        GridPane.setValignment(DName, VPos.CENTER);

        Label UserName = new Label(UName);
        UserName.setFont(new Font(24));
        GridPane.setColumnIndex(UserName, 2);
        GridPane.setRowIndex(UserName, 1);
        GridPane.setHalignment(UserName, HPos.LEFT);

        Label NurseLabel = new Label("Attendant:");
        GridPane.setRowIndex(NurseLabel, 2);
        GridPane.setHalignment(NurseLabel, HPos.CENTER);

        Label NurseName = new Label(NName);
        GridPane.setColumnIndex(NurseName, 2);
        GridPane.setRowIndex(NurseName, 2);

// Step 4.2: Add ImageView
        ImageView userPhoto = new ImageView(new Image(Objects.requireNonNull(getClass().getResource("/com/telemedicina/rcps/images/ROUND-LOGO.png")).toExternalForm()));
        userPhoto.setFitWidth(97);
        userPhoto.setFitHeight(79);
        userPhoto.setPickOnBounds(true);
        userPhoto.setPreserveRatio(true);
        GridPane.setColumnIndex(userPhoto, 1);
        GridPane.setRowIndex(userPhoto, 1);
        GridPane.setHalignment(userPhoto, HPos.CENTER);
// Step 4.3: Add FontAwesome Glyphs
// Create the first Glyph for DeviceIcon
        Glyph deviceIcon = new Glyph("FontAwesome", "HEARTBEAT"); // Use the FontAwesome icon name
        deviceIcon.setFontSize(30); // Font size
        deviceIcon.setAlignment(Pos.CENTER); // Center alignment
        deviceIcon.setPrefSize(68, 53); // Set preferred size (width and height)
        GridPane.setColumnIndex(deviceIcon, 2); // Place in column 2
        GridPane.setHalignment(deviceIcon, HPos.CENTER);
        GridPane.setMargin(deviceIcon, new Insets(0, 20, 0, 0)); // Right margin

// Create the second Glyph for NurseIcon
        Glyph nurseIcon = new Glyph("FontAwesome", "STETHOSCOPE"); // Use the FontAwesome icon name
        nurseIcon.setFontSize(30); // Font size
        nurseIcon.setAlignment(Pos.CENTER); // Center alignment
        nurseIcon.setPrefSize(52, 52); // Set preferred size (width and height)
        nurseIcon.setGraphicTextGap(0.0); // Graphic text gap
        GridPane.setColumnIndex(nurseIcon, 1); // Place in column 1
        GridPane.setRowIndex(nurseIcon, 2); // Place in row 2
        GridPane.setHalignment(nurseIcon, HPos.CENTER); // Align horizontally to the right

// Step 4.4: Add all children to the gridPane
        gridPane.getChildren().addAll(DLabel, DName, UserName, NurseLabel, NurseName, userPhoto,deviceIcon, nurseIcon);
        button.setGraphic(gridPane);
        return button;
    }

}
