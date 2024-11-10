package com.telemedicina.pabloescudero.main.controller;


import io.github.palexdev.materialfx.controls.MFXRadioButton;
import io.github.palexdev.materialfx.controls.MFXRectangleToggleNode;
import io.github.palexdev.materialfx.controls.MFXScrollPane;
import io.github.palexdev.materialfx.utils.ScrollUtils;
import io.github.palexdev.materialfx.utils.ToggleButtonsUtil;
import io.github.palexdev.mfxcore.utils.loader.MFXLoader;
import io.github.palexdev.mfxcore.utils.loader.MFXLoaderBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;

import java.util.List;

import static io.github.palexdev.mfxresources.MFXResources.loadURL;


public class MainController {
    @FXML
    public MFXScrollPane scrollPane;
    @FXML
    public VBox navBar;
    @FXML
    private final ToggleGroup toggleGroup;
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

    private double xOffset;
    private double yOffset;

    public MainController() {
        this.toggleGroup = new ToggleGroup();
        ToggleButtonsUtil.addAlwaysOneSelectedSupport(toggleGroup);
    }
    @FXML
    public void initialize() {
        menuIcon.setIcon(FontAwesome.Glyph.BARS);
        mainMenu.prefHeight(60);
        mainContent.prefWidthProperty().bind(screen.widthProperty().subtract(sidePanel.widthProperty()));
        mainMenu.prefWidthProperty().bind(screen.widthProperty().subtract(sidePanel.widthProperty()));
        mainContent.prefHeightProperty().bind(screen.heightProperty().subtract(mainMenu.heightProperty()));

        initializeLoader();

        ScrollUtils.addSmoothScrolling(scrollPane);
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
        MFXLoader loader = new MFXLoader();
        loader.addView(MFXLoaderBean.of("Devices", getClass().getResource("/com/telemedicina/pabloescudero/fxml/DevicesScreen.fxml"))
                .setBeanToNodeMapper(() -> createToggle(FontAwesome.Glyph.MOBILE_PHONE, "Devices"))
                .setDefaultRoot(true).get());
        loader.setOnLoadedAction(beans -> {
            List<ToggleButton> nodes = beans.stream()
                    .map(bean -> {
                        ToggleButton toggle = (ToggleButton) bean.getBeanToNodeMapper().get();
                        toggle.setOnAction(event -> mainContent.getChildren().setAll(bean.getRoot()));
                        if (bean.isDefaultView()) {
                            mainContent.getChildren().setAll(bean.getRoot());
                            toggle.setSelected(true);
                        }
                        return toggle;
                    })
                    .toList();
            navBar.getChildren().setAll(nodes);
        });
        loader.start();
    }

    @FXML// Create toggle method with ControlsFX Glyph for the icon
    private ToggleButton createToggle(FontAwesome.Glyph icon, String text) {
        return createToggle(icon, text, 0);
    }
    @FXML
    private ToggleButton createToggle(FontAwesome.Glyph icon, String text, double rotate) {
        // Create a ControlsFX Glyph icon
        Glyph glyphIcon = new Glyph("FontAwesome", icon).size(24);
        if (rotate != 0) glyphIcon.setRotate(rotate);

        // Create a ToggleButton with the icon and label
        MFXRectangleToggleNode toggleNode = new MFXRectangleToggleNode(text, glyphIcon);
        toggleNode.setAlignment(Pos.CENTER_LEFT);
        toggleNode.setMaxWidth(Double.MAX_VALUE);
        toggleNode.setToggleGroup(toggleGroup);

        return toggleNode;
    }
}
