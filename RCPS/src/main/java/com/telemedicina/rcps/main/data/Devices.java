package com.telemedicina.rcps.main.data;

import java.util.ArrayList;
import java.util.List;

public class Devices {
    protected static List<Dispositivo> dispositivos;

    public static List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public static void setDispositivos(List<Dispositivo> dispositivos) {
        Devices.dispositivos = dispositivos;
    }

    public List<Dispositivo> SearchOxygenMeasures() {
        List<Dispositivo> oxygenMeasures = new ArrayList<>();
        for (int i = 0; i < dispositivos.size(); i++) {
            if (dispositivos.get(i).isOxygen()) {
                oxygenMeasures.add(dispositivos.get(i));
            }
        }
        return oxygenMeasures;
    }

    public List<Dispositivo> SearchECGMeasures() {
        List<Dispositivo> ECGMeasures = new ArrayList<>();
        for (int i = 0; i < dispositivos.size(); i++) {
            if (!dispositivos.get(i).isOxygen()) {
                ECGMeasures.add(dispositivos.get(i));
            }
        }
        return ECGMeasures;
    }
}
