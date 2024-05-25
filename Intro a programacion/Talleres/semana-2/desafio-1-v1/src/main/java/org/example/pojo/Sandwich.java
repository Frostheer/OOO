package org.example.pojo;

import java.util.List;

public class Sandwich {
    private final String tipo;
    private List<Ingrediente> ingredientes;
    private float precio;
    private final String tamano;


    //----|Constructor|----//
    public Sandwich(String tipo, String tamano) {
        this.tipo = tipo;
        this.tamano = tamano;
    }


    //----|Metodo / Comportamientos|----//
    public void obtenerPrecio() {
        switch (this.tamano) {
            case "XL" -> this.precio = 8000;
            case "normal" -> this.precio = 4000;
            case "para niños" -> this.precio = 2000;
        }
    }


    //----|Metodo / Comportamientos|----//
    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getTipo() {
        return tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public String getTamano() {
        return tamano;
    }


    @Override
    public String toString() {
        return "\tSandwich: \n" +
                "\t\tPrecio:\t" + precio + "\n" +
                "\t\tTipo:\t" + tipo + "\n" +
                "\t\tTamaño:\t" + tamano + "\n" +
                "\t\tIngredientes:\t\n" +
                "\t\t\t" + ingredientes + "\n";
    }
}
