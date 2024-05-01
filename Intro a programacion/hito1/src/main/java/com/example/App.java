package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        manejarMenuPrincipal(scanner, estudiantes);

        scanner.close(); // evitar fugas de memoria

    }

    public static void manejarMenuPrincipal(Scanner scanner, ArrayList<Estudiante> estudiantes) {
        while (true) {
            System.out.println("Sistema de control de gastos");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar estudiante");
            System.out.println("2. Finalizar");

            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        manejarMenuEstudiante(estudiantes, scanner);
                        break;
                    case 2:
                        calcularYMostrarDatosFinales(estudiantes);
                        return;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } else {
                System.out.println("Por favor ingrese un número válido.");
                scanner.next();
            }
        }

    }

    public static void manejarMenuEstudiante(ArrayList<Estudiante> estudiantes, Scanner scanner) {
        Estudiante estudiante = new Estudiante(0);

        while (true) {
            System.out.println("Estudiante " + (estudiantes.size() + 1));
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar presupuesto total");
            System.out.println("2. Ingresar gasto");
            System.out.println("3. Finalizar");

            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el presupuesto total:");
                        if (scanner.hasNextDouble()) {
                            double presupuesto = scanner.nextDouble();
                            estudiante.setPresupuestoTotal(presupuesto);
                        } else {
                            System.out.println("Por favor ingrese un número válido.");
                            scanner.next();
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese el monto del gasto:");
                        if (scanner.hasNextDouble()) {
                            double monto = scanner.nextDouble();
                            Categoria categoria = manejarSeleccionCategoria(scanner);
                            estudiante.agregarGasto(monto, categoria);
                        } else {
                            System.out.println("Por favor ingrese un número válido.");
                            scanner.next();
                        }
                        break;
                    case 3:
                        estudiante.mostrarGastosEstudiante();
                        estudiantes.add(estudiante);
                        return;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } else {
                System.out.println("Por favor ingrese un número válido.");
                scanner.next();
            }
        }

    }

    public static Categoria manejarSeleccionCategoria(Scanner scanner) {
        while (true) {
            System.out.println("Seleccione la categoría del gasto:");
            System.out.println("1. Transporte");
            System.out.println("2. Comida");
            System.out.println("3. Ocio");
            if (scanner.hasNextInt()) {
                int categoria = scanner.nextInt();
                switch (categoria) {
                    case 1:
                        return Categoria.TRANSPORTE;

                    case 2:
                        return Categoria.COMIDA;

                    case 3:
                        return Categoria.OCIO;

                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } else {
                System.out.println("Por favor ingrese un número válido.");
                scanner.next();

            }
        }

    }

    public static void calcularYMostrarDatosFinales(ArrayList<Estudiante> estudiantes) {
        double totalTransporte = 0;
        double totalComida = 0;
        double totalOcio = 0;
        int cantidadEstudiantes = estudiantes.size();

        for (Estudiante estudiante : estudiantes) {
            totalTransporte += estudiante.calcularTotalGastosPorCategoria(Categoria.TRANSPORTE);
            totalComida += estudiante.calcularTotalGastosPorCategoria(Categoria.COMIDA);
            totalOcio += estudiante.calcularTotalGastosPorCategoria(Categoria.OCIO);
        }

        double promedioTransporte = totalTransporte / cantidadEstudiantes;
        double promedioComida = totalComida / cantidadEstudiantes;
        double promedioOcio = totalOcio / cantidadEstudiantes;
        double totalGeneral = totalTransporte + totalComida + totalOcio;

        System.out.println("------------------ Resultados Finales ------------------");
        System.out.println("Promedio general por categoría:");
        System.out.println("- Transporte: $" + promedioTransporte);
        System.out.println("- Comida: $" + promedioComida);
        System.out.println("- Ocio: $" + promedioOcio);
        System.out.println("Total general: $" + totalGeneral);
        System.out.println("---------------------------------------------------------");
    }

}
