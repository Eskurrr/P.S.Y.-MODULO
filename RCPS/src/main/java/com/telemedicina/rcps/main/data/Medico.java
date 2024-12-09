package com.telemedicina.rcps.main.data;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Usuario{
    private String nombre;
    private int edad;
    private String telefono;
    private String correo;
    public Medico(String nombre, int edad, String telefono , String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.setCorreo("");
        super.setPassword("");
        String idP = "1111" + id;;
        super.setId(idP.toCharArray());
    }
    public Medico(String ID) {
        this.nombre = "";
        this.edad = 0;
        this.telefono = "";
        this.setCorreo("");
        super.setPassword("");
        String idP = "1111" + ID;
        super.setId(idP.toCharArray());
    }

    public Medico(String name, int age, String phone, String email, char[] id, String password) {
        this.nombre = name;
        this.edad = age;
        this.telefono = phone;
        this.correo = email;
        super.setPassword(password);
        super.setId(id);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
