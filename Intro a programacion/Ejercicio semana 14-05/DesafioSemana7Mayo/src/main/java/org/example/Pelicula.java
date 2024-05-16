package org.example;

import java.util.Date;

public class Pelicula {
    private String titulo;
    private String fecha;


    public Pelicula(String titulo, String fecha) {
        this.titulo = titulo;
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
