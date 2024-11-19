package data;

import java.util.ArrayList;
import java.util.List;

public class Enfermero extends Usuario {
    private String nombre;
    private int edad;
    private String telefono;
    public Enfermero(String nombre, int edad, String telefono, String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        super.setCorreo("");
        super.setPassword("");
        String idP = "2222" + id;;
        super.setId(idP.toCharArray());
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
