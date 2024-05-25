package org.example.pojo;

import java.util.List;

public class Cliente {
    private final String nombre;
    private List<Sandwich> pedido;
    private int cantidadPedido;


    //----|Constructor|----//
    public Cliente(String nombre) {
        this.nombre = nombre;
    }


    //----|Metodo / Comportamientos|----//
    public void calcularCantidadPedidos() {
        this.cantidadPedido = this.pedido.size();
    }


    //----|Metodo / Comportamientos|----//
    public List<Sandwich> getPedido() {
        return pedido;
    }

    public void setPedido(List<Sandwich> pedido) {
        this.pedido = pedido;
    }


    @Override
    public String toString() {
        return "\nCliente {\n" +
                "\tNombre: " + nombre + '\n' +
                "\tTotal de pedidos: " + cantidadPedido + "\n" +
                "\tpedido:\n" + pedido + "\n";
    }
}
