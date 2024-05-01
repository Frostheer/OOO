package com.example;

public class Gasto {
    private double monto;
    private Categoria categoria;

    public Gasto(double monto, Categoria categoria) {
        this.monto = monto;
        this.categoria = categoria;
    }

    public double getMonto() {
        return monto;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}