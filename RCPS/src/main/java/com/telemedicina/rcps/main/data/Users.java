package com.telemedicina.rcps.main.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Users {
    private static List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
    private static List<Relation> relaciones = new ArrayList<Relation>();
    private static List<Paciente> pacientes = new ArrayList<Paciente>();
    private static List<Enfermero> enfermeros = new ArrayList<Enfermero>();
    private static List<Medico> medicos = new ArrayList<Medico>();
    private static List<Usuario> LogIn = new ArrayList<Usuario>();
    private static Usuario MainUser;

    public static Usuario getMainUser() {
        return MainUser;
    }

    public static void setMainUser(Usuario mainUser) {
        Users.MainUser = mainUser;
    }

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

    public Usuario SearchUsuario(char[] id) {
        int i = SearchID(getLogIn(), id);
        if (i == -1) {
            System.out.println("Usuario no encontrado");
            return null;
        } else {
            return getLogIn().get(i);
        }
    }

    public Paciente SearchPaciente(char[] id) {
        int i = SearchID(getPacientes(), id);
        if (i == -1) {
            System.out.println("Usuario no encontrado");
            return null;
        } else {
            return getPacientes().get(i);
        }
    }

    public Medico SearchMedico(char[] id) {
        int i = SearchID(getMedicos(), id);
        if (i == -1) {
            System.out.println("Usuario no encontrado");
            return null;
        } else {
            return getMedicos().get(i);
        }
    }

    public Enfermero SearchEnfermero(char[] id) {
        int i = SearchID(getEnfermeros(), id);
        if (i == -1) {
            System.out.println("Usuario no encontrado");
            return null;
        } else {
            return getEnfermeros().get(i);
        }
    }

    public Dispositivo SearchDispositivo(char[] id) {
        int i = SearchID(getDispositivos(), id);
        if (i == -1) {
            System.out.println("Usuario no encontrado");
            return null;
        } else {
            return getDispositivos().get(i);
        }
    }

    public int SearchID(List<? extends Usuario> list, char[] id) {
        String idSearch = Arrays.toString(id);

        for (int i = 0; i < list.size(); i++) {
            String idCompare = Arrays.toString(list.get(i).getId());
            if (idCompare.equals(idSearch)) {
                return i;
            }
        }
        return -1;
    }
}
