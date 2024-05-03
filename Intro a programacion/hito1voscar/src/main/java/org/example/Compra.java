package org.example;

public class Compra {
    private double monto;
    private Categoria categoria;

    public Compra(double monto, Categoria categoria) {
        this.monto = monto;
        this.categoria = categoria;
    }

    public Compra() {
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "monto=" + monto +
                ", categoria=" + categoria +
                '}';
    }
}

