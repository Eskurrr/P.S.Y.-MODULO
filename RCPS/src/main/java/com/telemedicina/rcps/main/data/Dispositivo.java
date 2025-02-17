package com.telemedicina.rcps.main.data;

import java.util.List;

public class Dispositivo{
    private String date;
    private boolean Oxygen;
    private List<Float> medida;
    protected List<Integer> bpms;
    public Dispositivo(boolean Oxy ,String date, List<Float> medida , List<Integer> bpms ) {
        this.Oxygen = Oxy;
        this.date = date;
        this.medida = medida;
        this.bpms = bpms;
    }

    public boolean isOxygen() {
        return Oxygen;
    }

    public void setOxygen(boolean oxygen) {
        Oxygen = oxygen;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Float> getMedida() {
        return medida;
    }

    public void setMedida(List<Float> medida) {
        this.medida = medida;
    }

    public List<Integer> getBpms() {
        return bpms;
    }

    public void setBpms(List<Integer> bpms) {
        this.bpms = bpms;
    }
}
