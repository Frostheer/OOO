package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Estudiante> estudiantes = new ArrayList<>();

        while (true) {
            System.out.println("1. Agregar estudiante");
            System.out.println("2. resumen de todo");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el total de presupuesto a manejar:");
                    double totalPresupuesto = sc.nextDouble();
                    sc.nextLine();
                    List<Compra> gastos = new ArrayList<>();
                    Estudiante estudiante1 = new Estudiante(totalPresupuesto, gastos);
                    estudiantes.add(estudiante1);
                    System.out.println("Estudiante agregado correctamente.\n");
                    while (true) {
                        System.out.println("1. Agregar nuevo gasto");
                        System.out.println("2. Terminar con este estudiante");
                        System.out.print("Ingrese su opción: ");
                        int opcion2 = sc.nextInt();
                        sc.nextLine();
                        switch (opcion2) {
                            case 1:
                                Scanner sc2 = new Scanner(System.in);
                                System.out.println("ingrese monto");
                                double monto=sc2.nextDouble();

                                //pedir categoria
                                Categoria categoria=pedirCategoria(sc2);
                                //nueva compra
                                Compra compra = new Compra(monto,categoria);
                                estudiante1.agregarCompra(compra);
                                break;
                            case 2:
                                System.out.println("Volviendo atrás...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, ingrese un número entre 1 y 2.\n");
                                break;
                        }
                        if (opcion2 == 2) {
                            break;
                        }
                    }
                    break;

                case 2://sacar calculos finales de todo
                    double montoTransporte = estudiantes.stream()
                            .flatMap(estudiante -> estudiante.getGastos().stream())
                            .filter(compra -> compra.getCategoria() == Categoria.TRANSPORTE)
                            .mapToDouble(Compra::getMonto)
                            .sum();
                    double montoComida = estudiantes.stream()
                            .flatMap(estudiante -> estudiante.getGastos().stream())
                            .filter(compra -> compra.getCategoria() == Categoria.COMIDA)
                            .mapToDouble(Compra::getMonto)
                            .sum();
                    double montoOcio = estudiantes.stream()
                            .flatMap(estudiante -> estudiante.getGastos().stream())
                            .filter(compra -> compra.getCategoria() == Categoria.OCIO)
                            .mapToDouble(Compra::getMonto)
                            .sum();
                    System.out.println("Gasto total en transporte: " + montoTransporte
                    +"gasto total en comida: " + montoComida
                    +"gasto total en ocio: " + montoOcio);
                    double categoriaMasGasto = Math.max(montoTransporte, Math.max(montoComida, montoOcio));
                    System.out.println("la categoria con mas gastos essss chan chan :" +categoriaMasGasto);
                    System.out.println("estudiantes revisados" +estudiantes);


                    break;
                case 3:
                    System.out.println("chao lo bimo.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número entre 1 y 2.\n");
                    break;
            }
        }
    }


    private static Categoria pedirCategoria(Scanner sc) {
        System.out.println("Ingrese la categoría:");
        System.out.println("1. Transporte");
        System.out.println("2. Comida");
        System.out.println("3. Ocio");

        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                return Categoria.TRANSPORTE;
            case 2:
                return Categoria.COMIDA;
            case 3:
                return Categoria.OCIO;
            default:
                System.out.println("Opción no válida. Por favor, ingrese un número entre 1 y 3.");
                return pedirCategoria(sc);
        }
    }
}
