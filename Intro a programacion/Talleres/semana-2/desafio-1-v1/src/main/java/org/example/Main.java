package org.example;

import org.example.pojo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner entradaTeclado = new Scanner(System.in);

    private static final Stock stockDeProductos = new Stock(); // Como los principios son los mismos, los valores se inicializan dentro del constructor
    private static final Reporte reporteFinal = new Reporte(); // Como los principios son los mismos, los valores se inicializan dentro del constructor

    public static void main(String[] args) {
        List<Cliente> registroDeCliente = new ArrayList<>();

        do {
            Cliente cliente = ingresarCliente();
            registroDeCliente.add(cliente);
        } while (consultarIngresoDeCliente());

        actualizarReporte(registroDeCliente);

        System.out.println("\nStock de productos:");
        stockDeProductos.getStock().forEach((llave, key) -> System.out.println(llave + ":" + key));

        System.out.println("\nReporte final:");
        System.out.println(reporteFinal);

    }

    //----|Consultar para agregar cliente|----//
    private static boolean consultarIngresoDeCliente() {
        System.out.print("\nDesea ingresar otro cliente\n\tSeleccione 1: Agregar clientes\n\tSeleccione 2: Dejar de agregar clientes\nIngresar respuesta: ");
        String eleccion = entradaTeclado.next();
        int eleccionConvertido = validarCasteoNumerico(eleccion);

        return eleccionConvertido == 1;
    }

    private static int validarCasteoNumerico(String numeroNoConvertido) {
        try {
            if (numeroNoConvertido.equals("1") || numeroNoConvertido.equals("2")) {
                return Integer.parseInt(numeroNoConvertido);
            } else {
                System.out.println("No se ha logrado castear el numero, pero por defecto se asigno el 2");
                return 2;
            }
        } catch (NumberFormatException error) {
            System.out.println("No se ha logrado castear el numero, pero por defecto se asigno el 2");
            return 2;
        }
    }

    //----|Ingresar cliente|----//
    private static Cliente ingresarCliente() {
        System.out.print("\nIngrese el nombre del cliente: ");
        String nombre = entradaTeclado.next();
        int cantidadPedidos = preguntarCantidadDepedidos();
        int iteracion = 0;

        Cliente cliente = new Cliente(nombre);
        List<Sandwich> sandwichLista = new ArrayList<>();

        while (cantidadPedidos > iteracion) {
            Sandwich sandwich = tomarPedido();
            sandwichLista.add(sandwich);
            iteracion++;
        }
        cliente.setPedido(sandwichLista);
        cliente.calcularCantidadPedidos();

        System.out.println(cliente);
        return cliente;
    }

    private static void actualizarReporte(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            for (Sandwich sandwich : cliente.getPedido()) {

                float precio = sandwich.getPrecio();
                String tipo = sandwich.getTipo();
                String tamano = sandwich.getTamano();

                reporteFinal.actualizarReporte(precio, tipo, tamano);
            }
        }
    }

    private static int preguntarCantidadDepedidos() {
        boolean estado = true;
        while (estado) {
            try {
                System.out.print("Ingrese la cantidad de pedidos: ");
                estado = false;
                return entradaTeclado.nextInt();
            } catch (Exception error) {
                System.out.println(error + "\nEl numero ingresado no es valido");
            }
        }
        return 0;
    }

    private static Sandwich tomarPedido() {

        System.out.print("Tipos de sandwitch: \nPresione 1. Sándwich delicioso \nPresione 2. Sándwich exquisito \nPresione 3. Sándwich sabroso\nRespuesta: ");
        String tipoSandwitch = obtenerTipoPorEleccion(entradaTeclado.nextInt());

        System.out.print("Tipos de sandwitch: \nPresione 1. Tamaño: 'XL' \nPresione 2. Tamaño: 'normal' \nPresione 3. Tamaño: 'para niño'\nRespuesta: ");
        String tamanoSandwitch = obtenerTamanoPorEleccion(entradaTeclado.nextInt());

        Sandwich sandwich = new Sandwich(tipoSandwitch, tamanoSandwitch);
        sandwich.obtenerPrecio();
        sandwich.setIngredientes(listarIngredientes(tipoSandwitch, tamanoSandwitch));

        actualizarStock(sandwich.getIngredientes());

        return sandwich;
    }

    private static void actualizarStock(List<Ingrediente> ingredientesLista) {
        stockDeProductos.ActualizarStock(ingredientesLista);
    }

    private static List<Ingrediente> listarIngredientes(String tipo, String tamanno) {
        List<Ingrediente> ingredientesLista = new ArrayList<>();

        for (String ingrediente : obtenerIngredientesPorTipoSandwitch(tipo)) {
            Ingrediente ingredientePojo = new Ingrediente(ingrediente);
            ingredientePojo.setGramaje(ingredientePojo.calcularGramaje(tamanno, tipo));

            ingredientesLista.add(ingredientePojo);
        }

        return ingredientesLista;
    }

    private static List<String> obtenerIngredientesPorTipoSandwitch(String tipo) {
        return switch (tipo) {
            case "delicioso" -> Arrays.asList("Lechuga", "Tomate");
            case "exquisito" -> Arrays.asList("Queso", "Tomate", "Palta");
            case "sabroso" -> Arrays.asList("Lechuga", "Tocino", "Pepinillos");
            default -> throw new IllegalStateException("Unexpected value: " + tipo);
        };

    }

    private static String obtenerTipoPorEleccion(int eleccion) {
        return switch (eleccion) {
            case 1 -> "delicioso";
            case 2 -> "exquisito";
            case 3 -> "sabroso";
            default -> "none";
        };
    }

    private static String obtenerTamanoPorEleccion(int eleccion) {
        return switch (eleccion) {
            case 1 -> "XL";
            case 2 -> "normal";
            case 3 -> "para niños";
            default -> "none";
        };
    }
}
