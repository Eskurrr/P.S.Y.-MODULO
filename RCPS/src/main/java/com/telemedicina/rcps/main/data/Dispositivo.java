package com.telemedicina.rcps.main.data;

import java.util.ArrayList;
import java.util.List;

public class Dispositivo extends Usuario{
    private char[] idPatient = new char[8] ;
    private String date;
    private boolean Oxygen;
    private int[] medida;
    public Dispositivo(String id, String idPatient, boolean Oxy ,String date, int[] medida) {
        String idP = "4444" + id;
        super.setId(idP.toCharArray());
        this.idPatient = idPatient.toCharArray();
        this.Oxygen = Oxy;
        this.date = date;
        this.medida = medida;
        super.setPassword("");
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
}
