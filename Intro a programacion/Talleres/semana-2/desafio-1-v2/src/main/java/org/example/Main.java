package org.example;

import org.example.pojo.*;

import java.util.Scanner;

public class Main {

    public static final Scanner entradaTeclado = new Scanner(System.in);
    private static final Stock stockDeProductos = new Stock();
    private static final Reporte reporteFinal = new Reporte();

    public static void main(String[] args) {
        Sandwich sandwich = new Sandwich();
        Cliente cliente = new Cliente();

        do {
            cliente.ingresarCliente();

            for (int i = 0; i < cliente.getCantidadPedido(); i++) {
                sandwich.setTipo(sandwich.obtenerTipoDeSandwich());
                sandwich.setTamano(sandwich.obtenerTamanoDeSandwich());
                sandwich.setPrecio(sandwich.obtenerPrecio());
                sandwich.setIngredientes(sandwich.obtenerIngredientesPorTipoSandwitch());

                stockDeProductos.ActualizarStock(sandwich.getIngredientes());
                stockDeProductos.mostrarStockActual();
            }

            cliente.actualizarListaDePedido(sandwich);
            reporteFinal.actualizarReporte(cliente.getPedido());

        } while (cliente.consultarIngresoDeCliente());

        System.out.println(reporteFinal);

    }


}
