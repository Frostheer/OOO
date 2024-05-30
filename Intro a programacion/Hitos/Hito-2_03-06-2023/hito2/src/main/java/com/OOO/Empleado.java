package com.OOO;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    private List<Double> ventas;
    private double comision;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.ventas = new ArrayList<Double>();
    }

    public String getNombre() {
        return nombre;
    }

    public double getVentasTotales() {
        double totalVentas = 0;
        for (double venta : ventas) {
            totalVentas += venta;
        }
        return totalVentas;
    }

    public List<Double> getVentas() {
        return ventas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVentas(List<Double> ventas) {
        this.ventas = ventas;
    }

    public double getComision() {
        return comision;
    }

    public void acumularComision(double comision) {
        this.comision += comision;
    }

    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", ventas=" + ventas + ", "
                + "comision=" + comision + "]" + "\n";
    }

}
