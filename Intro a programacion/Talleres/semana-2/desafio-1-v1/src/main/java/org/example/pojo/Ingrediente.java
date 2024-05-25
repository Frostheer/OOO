package org.example.pojo;

import java.util.HashMap;

public class Ingrediente {
    private final String nombre;
    private int gramaje;


    //----|Constructor|----//
    public Ingrediente(String nombre) {
        this.nombre = nombre;
    }


    //----|Metodos / Comportamientos|----//
    public int calcularGramaje(String tamano, String tipo) {
        this.gramaje = ObtenerGramajePorIngrediente(tipo);
        if (tamano.equals("XL")) {
            return gramaje * 2;
        } else if (tamano.equals("para niños")) {
            return gramaje / 2;
        } else {
            System.out.println("Se mantiene el gramaje 'Normal'");
            return gramaje;
        }
    }

    private int ObtenerGramajePorIngrediente(String tipo) {
        HashMap<String, Integer> listaIngredientes = definirGramajeInicial(tipo);
        for (String nombre : listaIngredientes.keySet()) {
            if (this.nombre.equalsIgnoreCase(nombre)) return listaIngredientes.get(nombre);
        }
        return 0;
    }

    private HashMap<String, Integer> definirGramajeInicial(String tipo) {
        HashMap<String, Integer> gramajePorIngrediente = new HashMap<>();

        switch (tipo) {
            case "delicioso" -> {
                gramajePorIngrediente.put("Lechuga", 123);
                gramajePorIngrediente.put("Tomate", 300);
            }
            case "exquisito" -> {
                gramajePorIngrediente.put("Queso", 150);
                gramajePorIngrediente.put("Tomate", 250);
                gramajePorIngrediente.put("Palta", 200);
            }
            case "sabroso" -> {
                gramajePorIngrediente.put("Lechuga", 300);
                gramajePorIngrediente.put("Tocino", 80);
                gramajePorIngrediente.put("Pepinillos", 50);
            }
        }

        return gramajePorIngrediente;
    }


    //----|Getter y Setter|----//
    public String getNombre() {
        return nombre;
    }

    public void setGramaje(int gramaje) {
        this.gramaje = gramaje;
    }


    @Override
    public String toString() {
        return nombre + "/" + gramaje + "gr";
    }
}
