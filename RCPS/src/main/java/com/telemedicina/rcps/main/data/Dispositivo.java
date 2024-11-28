package data;

import java.util.ArrayList;
import java.util.List;

public class Dispositivo {
    private char[] id = new char[8] ;
    private char[] idPatient = new char[8] ;
    private String date;
    private String medida;
    public Dispositivo(String id, String idPatient, String date, String medida) {
        String idP = "4444" + id;
        this.id = idP.toCharArray();
        this.idPatient = idPatient.toCharArray();
        this.date = date;
        this.medida = medida;
    }

    public char[] getId() {
        return id;
    }

    public void setId(char[] id) {
        this.id = id;
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

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
}
