package org.example.pojo;

import org.example.enums.SandwichTamano;
import org.example.enums.SandwichTipo;

import java.util.HashMap;

public class Ingrediente {
    private final String nombre;
    private int gramaje;


    //--|Constructor|-------------------------------------------------------------------------------------------------//
    public Ingrediente(String nombre) {
        this.nombre = nombre;
    }


    //--|Metodo / Comportamientos|------------------------------------------------------------------------------------//
    public void calcularGramaje(String tamano, String tipo) {
        this.gramaje = ObtenerGramajePorIngrediente(tipo);
        if (tamano.equals(SandwichTamano.XL.tomarDescripcion())) {
            this.gramaje = gramaje * 2;
        } else if (tamano.equals(SandwichTamano.PARA_NINO.tomarDescripcion())) {
            this.gramaje = gramaje / 2;
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
        SandwichTipo tipoSandwich = SandwichTipo.valueOf(tipo.toUpperCase());

        switch (tipoSandwich) {
            case SandwichTipo.DELICIOSO -> {
                gramajePorIngrediente.put("Lechuga", 123);
                gramajePorIngrediente.put("Tomate", 300);
            }
            case SandwichTipo.EXQUISITO -> {
                gramajePorIngrediente.put("Queso", 150);
                gramajePorIngrediente.put("Tomate", 250);
                gramajePorIngrediente.put("Palta", 200);
            }
            case SandwichTipo.SABROSO -> {
                gramajePorIngrediente.put("Lechuga", 300);
                gramajePorIngrediente.put("Tocino", 80);
                gramajePorIngrediente.put("Pepinillos", 50);
            }
        }

        return gramajePorIngrediente;
    }


    //--|Getter y Setter|---------------------------------------------------------------------------------------------//
    public String getNombre() {
        return nombre;
    }


    //--|toString|----------------------------------------------------------------------------------------------------//
    @Override
    public String toString() {
        return nombre + "/" + gramaje + "gr";
    }
}
