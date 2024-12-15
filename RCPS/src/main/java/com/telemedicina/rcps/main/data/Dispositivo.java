package com.telemedicina.rcps.main.data;

import java.util.ArrayList;
import java.util.List;

public class Dispositivo extends Usuario{
    private char[] idPatient = new char[8] ;
    private String date;
    private boolean Oxygen;
    private int[] medida;
    private int battery;
    public Dispositivo(String id, String idPatient, boolean Oxy ,String date, int[] medida , int battery) {
        String idP = "4444" + id;
        super.setId(idP.toCharArray());
        this.idPatient = idPatient.toCharArray();
        this.Oxygen = Oxy;
        this.date = date;
        this.medida = medida;
        super.setPassword("");
        this.battery = battery;
    }

    public boolean isOxygen() {
        return Oxygen;
    }

    public void setOxygen(boolean oxygen) {
        Oxygen = oxygen;
    }

    public char[] getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(char[] idPatient) {
        this.idPatient = idPatient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int[] getMedida() {
        return medida;
    }

    public void setMedida(int[] medida) {
        this.medida = medida;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }
}
