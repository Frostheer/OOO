package org.example.pojo;

import java.util.HashMap;
import java.util.List;

public class Stock {
    HashMap<String, Integer> stock = new HashMap<>();

    //--|Constructor|-------------------------------------------------------------------------------------------------//
    public Stock() {
        DefinirStockInicial();
    }


    //--|Metodo / Comportamientos|------------------------------------------------------------------------------------//
    private void DefinirStockInicial() {
        this.stock.put("Lechuga", 100);
        this.stock.put("Tomate", 100);
        this.stock.put("Queso", 100);
        this.stock.put("Palta", 100);
        this.stock.put("Pepinillos", 100);
        this.stock.put("Tocino", 100);
    }

    public void mostrarStockActual() {
        stock.forEach((llave, contenido) -> System.out.println("\nStock actual: \n" + llave + ":" + contenido));

    }

    public void ActualizarStock(List<Ingrediente> ingredientesLista) {
        for (Ingrediente ingrediente : ingredientesLista) {
            for (String clave : stock.keySet()) {
                if (ingrediente.getNombre().equalsIgnoreCase(clave)) {
                    Integer stockActual = stock.get(clave) - 1;
                    stock.put(clave, stockActual);
                }
            }
        }

    }
}
