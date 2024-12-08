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
    private static char[] IDMainUser = new char[8];


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

    public static char[] getIDMainUser() {
        return IDMainUser;
    }

    public static void setIDMainUser(char[] IDMainUser) {
        Users.IDMainUser = IDMainUser;
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
            System.out.println("Paciente no encontrado");
            return null;
        } else {
            return getPacientes().get(i);
        }
    }

    public Medico SearchMedico(char[] id) {
        int i = SearchID(getMedicos(), id);
        if (i == -1) {
            System.out.println("Medico no encontrado");
            return null;
        } else {
            return getMedicos().get(i);
        }
    }

    public Enfermero SearchEnfermero(char[] id) {
        int i = SearchID(getEnfermeros(), id);
        if (i == -1) {
            System.out.println("Enfermero no encontrado");
            return null;
        } else {
            return getEnfermeros().get(i);
        }
    }

    public Dispositivo SearchDispositivo(char[] id) {
        int i = SearchID(getDispositivos(), id);
        if (i == -1) {
            System.out.println("Dispositivo no encontrado");
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

    public List<Dispositivo> SearchPatientMeasures(char[] id) {
        String idSearch = Arrays.toString(id);
        List<Dispositivo> measures = new ArrayList<>();
        for (int i = 0; i < dispositivos.size(); i++) {
            String idCompare = Arrays.toString(dispositivos.get(i).getIdPatient());
            if (idCompare.equals(idSearch)) {
                measures.add(dispositivos.get(i));
            }
        }
        return measures;
    }

    public List<Dispositivo> SearchOxygenMeasures(List<Dispositivo> measures) {
        List<Dispositivo> oxygenMeasures = new ArrayList<>();
        for (int i = 0; i < measures.size(); i++) {
            if (measures.get(i).isOxygen()) {
                oxygenMeasures.add(measures.get(i));
            }
        }
        return oxygenMeasures;
    }

    public List<Dispositivo> SearchECGMeasures(List<Dispositivo> measures) {
        List<Dispositivo> ECGMeasures = new ArrayList<>();
        for (int i = 0; i < measures.size(); i++) {
            if (!measures.get(i).isOxygen()) {
                ECGMeasures.add(measures.get(i));
            }
        }
        return ECGMeasures;
    }
    public List<Relation> SearchRelations(char[] id) {
        String idSearch = Arrays.toString(id);
        String type = idSearch.substring(0, 4);
        List<Relation> UserRelations = new ArrayList<>();
        for (int i = 0; i < relaciones.size(); i++) {
            if(type.equals("1111")){
                String idCompare = Arrays.toString(relaciones.get(i).getMaster());
                if (idCompare.equals(idSearch)) {
                    UserRelations.add(relaciones.get(i));
                }
            }else if(type.equals("2222")){
                String idCompareS = Arrays.toString(relaciones.get(i).getSlave());
                String idCompareM = Arrays.toString(relaciones.get(i).getMaster());
                if (idCompareS.equals(idSearch) || idCompareM.equals(idSearch)) {
                    UserRelations.add(relaciones.get(i));
                }
            }else if(type.equals("3333")){
                String idCompare = Arrays.toString(relaciones.get(i).getSlave());
                if (idCompare.equals(idSearch)) {
                    UserRelations.add(relaciones.get(i));
                }
            }else {
                System.out.println("ID no correcto");
                return null;
            }
        }
        return UserRelations;
    }

}

