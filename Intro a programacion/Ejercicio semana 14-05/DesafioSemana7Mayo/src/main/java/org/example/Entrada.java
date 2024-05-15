package org.example;



public class Entrada {
    private Cliente cliente;
    private Sala sala;

    public Entrada(Cliente cliente, Sala sala) {
        this.cliente = cliente;
        this.sala = sala;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "cliente=" + cliente +
                ", sala=" + sala +
                '}';
    }
}
