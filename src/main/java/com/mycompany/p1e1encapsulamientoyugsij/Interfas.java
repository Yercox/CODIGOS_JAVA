/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1e1encapsulamientoyugsij;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Interfas {
    private final Scanner sc = new Scanner(System.in);
    private final ArrayList<Figura> figuras = new ArrayList<>();

    public void iniciarPrograma() {
        int opcion = 0;
        do {
            try {
                mostrarMenu();
                opcion = validarOpcion();

                switch (opcion) {
                    case 1:
                        guardarRectangulo();
                        break;
                    case 2:
                        guardarCuadrado();
                        break;
                    case 3:
                        System.out.println("Gracias por usar el programa. Hasta luego!");
                        break;
                    default:
                        System.out.println("Opcion invalida. Intenta nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero valido.");
                sc.next(); // limpiar entrada inválida
            } catch (ArithmeticException e) {
                System.out.println("Error aritmético: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
            }
        } while (opcion != 3);
    }

    private void mostrarMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Guardar Rectangulo");
        System.out.println("2. Guardar Cuadrado");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private int validarOpcion() {
        while (!sc.hasNextInt()) {
            System.out.print("Opcion invalida. Ingrese un numero: ");
            sc.next();
        }
        int opcion = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        return opcion;
    }

    private void guardarRectangulo() {
        try {
            System.out.println("\n-- Registro de Rectangulo --");
            String nombre = validarTexto("Introduce el nombre del rectangulo (solo letras): ");
            double base, altura;

            do {
                base = validarDouble("Introduce la base (0 < base < 100): ");
                altura = validarDouble("Introduce la altura (0 < altura < 100): ");
                Rectangulo.CompararBaseAltura(base, altura); // Puede lanzar excepcion
                if (base == altura) {
                    System.out.println("Base y altura no pueden ser iguales.");
                }
            } while (base == altura);

            String color = validarTexto("Introduce el color (solo letras): ");

            Rectangulo rect = new Rectangulo(base, altura, nombre, color);
            figuras.add(rect);

            System.out.println("\nRectangulo guardado con exito.");
            mostrarDatosGuardados();
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado al guardar el rectángulo: " + e.getMessage());
        }
    }

    private void guardarCuadrado() {
        try {
            System.out.println("\n-- Registro de Cuadrado --");
            String nombre = validarTexto("Introduce el nombre del cuadrado (solo letras): ");
            double lado = validarDouble("Introduce el lado (0 < lado < 100): ");
            String color = validarTexto("Introduce el color (solo letras): ");

            Cuadrado cuad = new Cuadrado(lado, nombre, color);
            figuras.add(cuad);

            System.out.println("\nCuadrado guardado con exito.");
            mostrarDatosGuardados();
        } catch (Exception e) {
            System.out.println("Error inesperado al guardar el cuadrado: " + e.getMessage());
        }
    }

    private void mostrarDatosGuardados() {
        System.out.println("\n=== FIGURAS GUARDADAS ===");
        for (Figura f : figuras) {
            System.out.println("Tipo: " + f.getTipo());
            System.out.println("Nombre: " + f.getNombre());
            System.out.println("Area: " + f.calcularArea());
            System.out.println("Perimetro: " + f.calcularPerimetro());
            System.out.println("Color: " + f.getColor());
            System.out.println("------------------------------");
        }
    }

    private String validarTexto(String mensaje) {
        String input;
        do {
            System.out.print(mensaje);
            input = sc.nextLine();
            if (!input.matches("[a-zA-Z]+")) {
                System.out.println("Error: Solo se permiten letras.");
            }
        } while (!input.matches("[a-zA-Z]+"));
        return input;
    }

    private double validarDouble(String mensaje) {
        double valor = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = sc.nextDouble();
                sc.nextLine(); // limpiar buffer

                if (valor <= 0 || valor >= 100) {
                    System.out.println("Error: El valor debe estar entre 0 y 100 (exclusivo).");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número válido.");
                sc.next(); // limpiar entrada inválida
            }
        }

        return valor;
    }
}
