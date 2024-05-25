package org.example.pojo;

import java.util.HashMap;
import java.util.List;

public class Stock {
    HashMap<String, Integer> stock = new HashMap<>();

    public Stock() {
        DefinirStockInicial();
    }

    private void DefinirStockInicial() {
        this.stock.put("Lechuga", 100);
        this.stock.put("Tomate", 100);
        this.stock.put("Queso", 100);
        this.stock.put("Palta", 100);
        this.stock.put("Pepinillos", 100);
        this.stock.put("Tocino", 100);
    }

    public void ActualizarStock(List<Ingrediente> ingredientesLista) {
        for (Ingrediente ingrediente : ingredientesLista) {
            for (String clave : stock.keySet()) {
                if (ingrediente.getNombre().equalsIgnoreCase(clave)) {
                    Integer stockActual = stock.get(clave) -1;
                    stock.put(clave, stockActual);
                }else if (ingrediente.getNombre().equalsIgnoreCase(clave) && ingrediente.getNombre().equalsIgnoreCase("Pan")) {
                    Integer stockActual = stock.get(clave) -2;
                    stock.put(clave, stockActual);
                }
            }
        }
    }

    public HashMap<String, Integer> getStock() {
        return stock;
    }
}
