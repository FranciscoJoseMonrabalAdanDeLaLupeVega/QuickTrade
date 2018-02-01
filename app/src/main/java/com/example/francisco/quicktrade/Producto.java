package com.example.francisco.quicktrade;

/**
 * Created by Francisco on 01/02/2018.
 */

public class Producto {

    private String name;
    private String description;
    private String categoria;
    private int precio;

    public Producto(String name, String description, String categoria, int precio) {
        this.name = name;
        this.description = description;
        this.categoria = categoria;
        this.precio = precio;
    }

    public Producto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
