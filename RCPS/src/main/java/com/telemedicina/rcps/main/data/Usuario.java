package com.telemedicina.rcps.main.data;

public class Usuario {
    private char[] id = new char[8] ;
    private String password;

    public char[] getId() {
        return id;
    }

    public void setId(char[] id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}