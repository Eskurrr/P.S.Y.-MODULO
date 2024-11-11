package data;

import java.util.ArrayList;
import java.util.List;

public class Enfermero {
    private String nombre;
    private String apellido;
    private String Especialidad;
    private List<Paciente> pacientes;
    public Enfermero(String nombre, String apellido, String Especialidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.Especialidad = Especialidad;
        this.pacientes = new ArrayList<Paciente>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
