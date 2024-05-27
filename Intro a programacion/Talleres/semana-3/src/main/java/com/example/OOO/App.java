package com.example.OOO;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Refugio refugio = new Refugio();

        // add some animals to the refugio
        refugio.agregarAnimal(new Animal("Firulais", Especie.PERRO, 8, false, null));
        refugio.agregarAnimal(new Animal("Mishi", Especie.GATO, 10, false, null));
        refugio.agregarAnimal(new Animal("Piolin", Especie.PAJARO, 3, false, null));
        refugio.agregarAnimal(new Animal("Rex", Especie.PERRO, 8, false, null));
        refugio.agregarAnimal(new Animal("Garfield", Especie.GATO, 6, false, null));
        refugio.agregarAnimal(new Animal("Tweety", Especie.PAJARO, 4, false, null));
        refugio.agregarAnimal(new Animal("Bugs", Especie.CONEJO, 2, false, null));

        // main manu handler
        manejarMenu(scanner, refugio);

        // close scanner to avoid resource leak
        scanner.close();
    }

    public static void manejarMenu(Scanner scanner, Refugio refugio) {
        while (true) {
            System.out.println("Bienvenido al refugio de animales");
            System.out.println("1. Mostrar animales por especie");
            System.out.println("2. Registrar animal");
            System.out.println("3. Generar informe de adopciones");
            System.out.println("4. Registrar adopción");
            System.out.println("5. Salir");

            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        Especie especie = Utils.manejarSeleccionEspecie(scanner);
                        refugio.mostrarAnimalesPorEspecie(especie);
                        break;
                    case 2:
                        Animal animal = manejarRegistroAnimal(scanner);
                        refugio.registrarNuevoAnimal(animal);
                        break;
                    case 3:
                        refugio.generarInforme(LocalDate.now());
                        break;
                    case 4:
                        manejarRegistrarAdopcion(scanner, refugio);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        break;
                }

            } else {
                System.out.println("Por favor ingrese una opción válida.");
                scanner.next();
            }

        }
    }

    public static void manejarRegistrarAdopcion(Scanner scanner, Refugio refugio) {
        System.out.println("Ingrese el nombre del animal:");
        String nombre = scanner.nextLine();
        Animal animal = null;
        for (Animal a : refugio.getAnimales()) {
            // equalsIgnoreCase to avoid case sensitivity
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                animal = a;
                break;
            }
        }

        if (animal == null) {
            System.out.println("No se encontró el animal.");
            return;
        }

        if (animal.isAdoptado()) {
            System.out.println("El animal ya fue adoptado.");
            return;
        }

        Persona adoptante = manejarIngresoPersona(scanner);
        refugio.registrarAdopcion(animal, adoptante);
    }

    public static Persona manejarIngresoPersona(Scanner scanner) {
        System.out.println("Ingrese el nombre completo del adoptante:");
        String nombre = scanner.nextLine();

        String rut = Utils.manejarIngresoRUT(scanner);
        String telefono = Utils.manejarIngresoTelefono(scanner);
        double ingresos = Utils.manejarIngresoIngresos(scanner);

        return new Persona(nombre, rut, telefono, ingresos);
    }

    public static Animal manejarRegistroAnimal(Scanner scanner) {
        System.out.println("Ingrese el nombre del animal:");
        String nombre = scanner.nextLine();
        Especie especie = Utils.manejarSeleccionEspecie(scanner);
        int condicionSalud = Utils.manejarIngresoCondicionSalud(scanner);
        System.out.println("¿El animal está adoptado? (s/n)");
        boolean adoptado = scanner.nextLine().equalsIgnoreCase("s");

        if (adoptado) {
            Persona adoptante = manejarIngresoPersona(scanner);
            return new Animal(nombre, especie, condicionSalud, adoptado, adoptante);
        }

        return new Animal(nombre, especie, condicionSalud, false, null);
    }

}
