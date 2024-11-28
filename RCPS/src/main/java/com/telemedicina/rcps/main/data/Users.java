package com.telemedicina.rcps.main.data;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private static List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
    private static List<Relation> relaciones = new ArrayList<Relation>();
    private static List<Paciente> pacientes = new ArrayList<Paciente>();
    private static List<Enfermero> enfermeros = new ArrayList<Enfermero>();
    private static List<Medico> medicos = new ArrayList<Medico>();
    private static List<Usuario> LogIn = new ArrayList<Usuario>();

    public static List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public static void setDispositivos(List<Dispositivo> dispositivos) {
        Users.dispositivos = dispositivos;
    }

    public static List<Relation> getRelaciones() {
        return relaciones;
    }

    public static void setRelaciones(List<Relation> relaciones) {
        Users.relaciones = relaciones;
    }

    public static List<Paciente> getPacientes() {
        return pacientes;
    }

    public static void setPacientes(List<Paciente> pacientes) {
        Users.pacientes = pacientes;
    }

    public static List<Enfermero> getEnfermeros() {
        return enfermeros;
    }

    public static void setEnfermeros(List<Enfermero> enfermeros) {
        Users.enfermeros = enfermeros;
    }

    public static List<Medico> getMedicos() {
        return medicos;
    }

    public static void setMedicos(List<Medico> medicos) {
        Users.medicos = medicos;
    }

    public static List<Usuario> getLogIn() {
        return LogIn;
    }

    public static void setLogIn(List<Usuario> logIn) {
        LogIn = logIn;
    }
}
