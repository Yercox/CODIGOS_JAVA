/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1e1encapsulamientoyugsij;

public class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado, String nombre, String color) {
    super(nombre, color, "Cuadrado"); 
    this.lado = lado;
}

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
       if (lado > 0 && lado < 100) {
            this.lado = lado;
        } else {
            System.out.println("Error El lado debe estar entre 0 y 100");
        }
    }
    

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }
}

 