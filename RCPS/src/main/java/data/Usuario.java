package data;

public class Usuario {
   private char[] id = new char[8] ;
   private String correo;
   private String password;

    public char[] getId() {
        return id;
    }

    public void setId(char[] id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
