package com.telemedicina.rcps.main.data;

public class Paciente extends Usuario{
    private String nombre;
    private int edad;
    private String telefono;
    private String address;
    private String diagnostico;
    private String correo;
    public Paciente(String nombre, int edad, String telefono, String address, String diagnostico , String id) {
        this.setCorreo("");
        super.setPassword("");
        String idP = "3333" + id;
        super.setId(idP.toCharArray());
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.address = address;
        this.diagnostico = diagnostico;
    }
    public Paciente(String nombre, int edad, String telefono, String address, String diagnostico ,String correo , char[] id , String password) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.address = address;
        this.diagnostico = diagnostico;
        this.correo = correo;
        super.setId(id);
        super.setPassword(password);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
