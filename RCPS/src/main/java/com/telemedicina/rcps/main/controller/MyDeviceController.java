package com.telemedicina.rcps.main.controller;

import com.telemedicina.rcps.main.data.Dispositivo;
import com.telemedicina.rcps.main.data.Relation;
import com.telemedicina.rcps.main.data.Users;
import io.github.palexdev.mfxresources.fonts.MFXFontIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;

import java.util.Arrays;
import java.util.List;

public class MyDeviceController extends Users {
    @FXML
    public MFXFontIcon BatteryIcon;
    @FXML
    private Label DeviceID;
    @FXML
    private Label Battery;
    @FXML
    private Label LastUse;

    @FXML
    public void initialize() {
        Relation assigned = SearchDeviceAssigned(getIDMainUser());
        if (assigned != null) {
            String id = Arrays.toString(assigned.getSlave());
            DeviceID.setText(id);
            List<Dispositivo> measuresF = FilterDispositivo(SearchDispositivo(assigned.getSlave()),assigned.getMaster());
            String LastUsed = measuresF.getLast().getDate();
            LastUse.setText(LastUsed);
            int battery =  measuresF.getLast().getBattery();
            Battery.setText(battery + "");
        }
        BatteryIcon = new MFXFontIcon("fas-battery-full" , 30.00);
    }

    @FXML
    public void setBatteryIcon(int battery){
        if (battery >= 20 && battery <= 100) {
        }else {
        }
    }
}
