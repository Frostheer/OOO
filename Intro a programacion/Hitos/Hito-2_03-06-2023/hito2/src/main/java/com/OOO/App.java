package com.OOO;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpresa gestorEmpresa = new GestorEmpresa();

        // crear empleados
        Empleado empleado1 = new Empleado("Juan");
        Empleado empleado2 = new Empleado("Pedro");
        Empleado empleado3 = new Empleado("Maria");
        Empleado empleado4 = new Empleado("Jose");
        Empleado empleado5 = new Empleado("Ana");

        // agregar ventas a los empleados
        empleado1.getVentas().add(100000.0);
        empleado1.getVentas().add(200000.0);
        empleado1.getVentas().add(300000.0);

        empleado2.getVentas().add(400000.0);
        empleado2.getVentas().add(500000.0);
        empleado2.getVentas().add(600000.0);

        empleado3.getVentas().add(700000.0);
        empleado3.getVentas().add(800000.0);
        empleado3.getVentas().add(900000.0);

        empleado4.getVentas().add(100000.0);
        empleado4.getVentas().add(110000.0);
        empleado4.getVentas().add(120000.0);

        empleado5.getVentas().add(200000.0);
        empleado5.getVentas().add(400000.0);
        empleado5.getVentas().add(150000.0);

        // agregar empleados al gestor
        gestorEmpresa.addEmpleado(empleado1);
        gestorEmpresa.addEmpleado(empleado2);
        gestorEmpresa.addEmpleado(empleado3);

        manejarMenu(scanner, gestorEmpresa);
    }

    public static void manejarMenu(Scanner scanner, GestorEmpresa gestorEmpresa) {
        while (true) {
            System.out.println("1. Listar empleados");
            System.out.println("2. Listar comisiones por empleado");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    gestorEmpresa.listarEmpleados();
                    break;
                case 2:
                    gestorEmpresa.calcularBeneficiosEmpleados();
                    gestorEmpresa.listarEmpleados();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }

}
