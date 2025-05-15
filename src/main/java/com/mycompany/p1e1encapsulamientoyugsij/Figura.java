/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1e1encapsulamientoyugsij;

public abstract class Figura {
    private String nombre;
    private String color;
    private String tipo;  

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public Figura(String nombre, String color, String tipo) {
        this.nombre = nombre;
        this.color = color;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}
