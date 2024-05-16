package org.example;



public class Entrada {
    private Cliente cliente;
    private Sala sala;
    private Pelicula pelicula;
    private String horario;
    private int cantidad;

    public Entrada(Cliente cliente, Sala sala, Pelicula pelicula, String horario, int cantidad) {
        this.cliente = cliente;
        this.sala = sala;
        this.pelicula = pelicula;
        this.horario = horario;
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Sala getSala() {
        return sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public String getHorario() {
        return horario;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "cliente=" + cliente +
                ", sala=" + sala +
                ", pelicula=" + pelicula +
                ", horario='" + horario + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}

