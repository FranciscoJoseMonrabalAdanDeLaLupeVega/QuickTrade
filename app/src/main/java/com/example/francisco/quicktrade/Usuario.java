package com.example.francisco.quicktrade;

/**
 * Created by Francisco on 13/01/2018.
 */

public class Usuario {

    private  String nombre;
    private  String correo;
    private String direccion;
    private String apellido;

    public Usuario() {

    }

    public  Usuario(String nombre, String correo, String direccion, String apellido) {

        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
