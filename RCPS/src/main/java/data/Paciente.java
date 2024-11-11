package data;

public class Paciente {
    private String nombre;
    private int edad;
    private String genero;
    private String telefono;
    private String email;
    private String direccion;
    private String diagnostico;
    public Paciente(String name, int age, String gender, String phone, String email, String address, String diagnostic) {
        this.nombre = name;
        this.edad = age;
        this.genero = gender;
        this.telefono = phone;
        this.email = email;
        this.direccion = address;
        this.diagnostico = diagnostic;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
