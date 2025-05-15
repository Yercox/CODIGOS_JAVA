/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1e1encapsulamientoyugsij;

public class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura, String nombre, String color) {
    super(nombre, color, "Rectángulo"); 
    this.base = base;
    this.altura = altura;
    }
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        if (base > 0 && base < 100) {
            this.base = base;
        } else {
            System.out.println("Error: La base debe estar entre 0 y 100.");
        }
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura > 0 && altura < 100) {
            this.altura = altura;
        } else {
            System.out.println("Error: La altura debe estar entre 0 y 100.");
        }
    }

    public static void CompararBaseAltura(double base, double altura) {
        if (base > altura) {
            System.out.println("La base es mayor que la altura");
        } else if (altura > base) {
            System.out.println("La altura es mayor que la base");
        } else {
            System.out.println("Error: La base y la altura son iguales");
        }
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}