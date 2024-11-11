package com.telemedicina.pabloescudero.main.controller;


import io.github.palexdev.materialfx.controls.MFXRadioButton;
import io.github.palexdev.materialfx.utils.ToggleButtonsUtil;
import io.github.palexdev.mfxcore.utils.loader.MFXLoader;
import io.github.palexdev.mfxcore.utils.loader.MFXLoaderBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import java.util.List;


public class MainController {
    @FXML
    public VBox navBar;
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
    public void initialize() {
        ToggleButtonsUtil.addAlwaysOneSelectedSupport(maintoggle);
        menuIcon.setIcon(FontAwesome.Glyph.BARS);
        PatientsIcon.setIcon(FontAwesome.Glyph.USER);
        DevicesIcon.setIcon(FontAwesome.Glyph.MOBILE_PHONE);
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
    @FXML
    private void initializeLoader() {
        // Set up the loader for the MFX views
        MFXLoader loader = new MFXLoader();
        loader.addView(MFXLoaderBean.of("Devices", getClass().getResource("/com/telemedicina/pabloescudero/fxml/DevicesScreen.fxml"))
                .setBeanToNodeMapper(() -> DevicesButton) // Map to the devicesButton created in FXML
                .setDefaultRoot(true).get());
        loader.addView(MFXLoaderBean.of("Settings", getClass().getResource("/com/telemedicina/pabloescudero/fxml/SettingsScreen.fxml"))
                .setBeanToNodeMapper(() -> PatientsButton) // Map to the settingsButton created in FXML
                .setDefaultRoot(false).get());

        loader.setOnLoadedAction(beans -> {
            List<Glyph> nodes = beans.stream()
                    .map(bean -> {
                        Glyph glyph = (Glyph) bean.getBeanToNodeMapper().get();
                        MFXRadioButton toggleNode = (MFXRadioButton) glyph.getGraphic();

                        // Set the action for the button
                        toggleNode.setOnAction(event -> {
                            // Set the main content based on the selected view
                            mainContent.getChildren().setAll(bean.getRoot());
                        });

                        // Set up the mouse click event to trigger the radio button action
                        glyph.setOnMouseClicked(mouseEvent -> toggleNode.fire());

                        // Default view selection
                        if (bean.isDefaultView()) {
                            mainContent.getChildren().setAll(bean.getRoot());
                            toggleNode.setSelected(true);
                        }

                        return glyph;
                    })
                    .toList();

            // Set the children of the navBar with the dynamically created Glyphs
            navBar.getChildren().setAll(nodes);
        });

        // Start the loader
        loader.start();
    }
}
