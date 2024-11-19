package data;

public class Paciente extends Usuario{
    private String nombre;
    private int edad;
    private String telefono;
    private String direccion;
    private String diagnostico;
    public Paciente(String nombre, int edad, String telefono, String direccion, String diagnostico , String id) {
        super.setCorreo("");
        super.setPassword("");
        String idP = "3333" + id;
        super.setId(idP.toCharArray());
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.diagnostico = diagnostico;
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
