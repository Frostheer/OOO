package com.example;

public enum Categoria {
    TRANSPORTE(0.4),
    COMIDA(0.3),
    OCIO(0.3);

    private final double ponderacion;

    Categoria(double ponderacion) {
        this.ponderacion = ponderacion;
    }

    public double getPonderacion() {
        return ponderacion;
    }
}