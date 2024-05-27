package com.example.OOO;

import java.util.Scanner;

public class Utils {

    public static String manejarIngresoRUT(Scanner scanner) {
        System.out.println("Ingrese el RUT:");
        String rut = scanner.nextLine();
        while (!rut.matches("^[0-9]{8}-[0-9kK]$")) {
            System.out.println("RUT inválido. Ingrese un RUT válido:");
            rut = scanner.nextLine();
        }
        return rut;
    }

    public static String manejarIngresoTelefono(Scanner scanner) {
        System.out.println("Ingrese el teléfono:");
        String telefono = scanner.nextLine();
        while (!telefono.matches("^[0-9]{9}$")) {
            System.out.println("Teléfono inválido. Ingrese un teléfono válido:");
            telefono = scanner.nextLine();
        }
        return telefono;
    }

    public static double manejarIngresoIngresos(Scanner scanner) {
        while (true) {
            System.out.println("Ingrese los ingresos mensuales del adoptante:");
            if (scanner.hasNextDouble()) {
                double ingresos = scanner.nextDouble();
                if (ingresos >= 0) {
                    return ingresos;
                } else {
                    System.out.println("Ingresos inválidos. Ingrese un monto válido:");
                }
            } else {
                System.out.println("Por favor ingrese un número válido.");
                scanner.next();
            }

        }
    }

    public static int manejarIngresoCondicionSalud(Scanner scanner) {
        while (true) {
            System.out.println("Ingrese la condición de salud del animal (0 - 10):");
            if (scanner.hasNextInt()) {
                int condicionSalud = scanner.nextInt();
                if (condicionSalud >= 0 && condicionSalud <= 10) {
                    scanner.nextLine();
                    return condicionSalud;
                } else {
                    System.out.println("Condición de salud inválida. Ingrese un número entre 0 y 10.");
                }
            } else {
                System.out.println("Por favor ingrese un número válido.");
                scanner.next();
            }
        }
    }

    public static Especie manejarSeleccionEspecie(Scanner scanner) {
        while (true) {
            System.out.println("Seleccione una especie:");
            for (Especie especie : Especie.values()) {
                System.out.println(especie.ordinal() + 1 + ". " + especie);
            }

            // hashmap will be better here
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        return Especie.PERRO;
                    case 2:
                        return Especie.GATO;
                    case 3:
                        return Especie.CONEJO;
                    case 4:
                        return Especie.HAMSTER;
                    case 5:
                        return Especie.PAJARO;
                    case 6:
                        return Especie.REPTIL;
                    case 7:
                        return Especie.OTRO;
                    default:
                        break;
                }
            } else {
                System.out.println("Por favor ingrese una opción válida.");
                scanner.next();

            }
        }
    }

}
