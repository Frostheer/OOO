package org.example.pojo;

import org.example.Main;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private final List<Sandwich> pedido;
    private int cantidadPedido;


    //--|Constructor|-------------------------------------------------------------------------------------------------//
    public Cliente() {
        this.pedido = new ArrayList<>();
    }


    //--|Metodo / Comportamientos|------------------------------------------------------------------------------------//
    public void ingresarCliente() {
        this.nombre = preguntarNombreAlCliente();
        this.cantidadPedido = preguntarCantidadDePedidos();
    }

    private int preguntarCantidadDePedidos() {
        try {
            System.out.print("Ingrese cuantos pedidos realizara: ");
            return Main.entradaTeclado.nextInt();
        } catch (Exception exception) {
            System.out.println("Error: " + exception);
            return 0;
        }
    }

    private String preguntarNombreAlCliente() {
        try {
            System.out.print("Ingrese el nombre del cliente: ");
            return Main.entradaTeclado.next();
        } catch (Exception exception) {
            System.out.println("Error: " + exception);
            return "Null";
        }
    }

    public void actualizarListaDePedido(Sandwich sandwich) {
        this.pedido.add(sandwich);
    }

    public boolean consultarIngresoDeCliente() {
        System.out.print("""
                \nDesea ingresar otro cliente
                \tSeleccione 1: Agregar clientes
                \tSeleccione 2: Dejar de agregar clientes
                Ingresar respuesta:\s""");

        return validarCasteoNumerico(Main.entradaTeclado.next()) == 1;
    }

    private int validarCasteoNumerico(String numeroNoConvertido) {
        return switch (numeroNoConvertido) {
            case "1", "2" -> Integer.parseInt(numeroNoConvertido);
            default -> throw new IllegalStateException("Valor inesperado: " + numeroNoConvertido);
        };
    }


    //--|Getter y Setter|---------------------------------------------------------------------------------------------//
    public List<Sandwich> getPedido() {
        return pedido;
    }

    public int getCantidadPedido() {
        return cantidadPedido;
    }

    //--|toString|----------------------------------------------------------------------------------------------------//
    @Override
    public String toString() {
        return "\nCliente {\n" +
                "\tNombre: " + nombre + '\n' +
                "\tTotal de pedidos: " + cantidadPedido + "\n" +
                "\tpedido:\n" + pedido + "\n";
    }
}
