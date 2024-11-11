package data;

import java.util.ArrayList;
import java.util.List;

public class Medico {
    private String nombre;
    private String apellido;
    private String Especialidad;
    private List<Enfermero> enfermeros;
    public Medico(String nombre, String apellido, String Especialidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.Especialidad = Especialidad;
        this.enfermeros = new ArrayList<Enfermero>();
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

    public List<Enfermero> getEnfermeros() {
        return enfermeros;
    }

    public void setEnfermeros(List<Enfermero> enfermeros) {
        this.enfermeros = enfermeros;
    }
}
