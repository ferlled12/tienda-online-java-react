package com.example.demo;

public class Producto {
    private String id;
    private String nombre;
    private double precio;

    // constructor vacío necesario para que Spring Boot lea el JSON de React
    public Producto() {
    }

    // constructor que ya teníamos
    public Producto(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
}