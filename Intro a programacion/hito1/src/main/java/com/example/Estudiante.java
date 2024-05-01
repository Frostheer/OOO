package com.example;

import java.util.ArrayList;

public class Estudiante {
    private double presupuestoTotal;
    private ArrayList<Gasto> listaGastos;

    public Estudiante(double presupuestoTotal) {
        this.presupuestoTotal = presupuestoTotal;
        this.listaGastos = new ArrayList<>();
    }

    public boolean validarGasto(Gasto gasto) {
        if (gasto.getMonto() > this.presupuestoTotal) {
            return false;
        }

        double limiteCategoria = this.presupuestoTotal * gasto.getCategoria().getPonderacion();
        double gastoPorCategoria = calcularTotalGastosPorCategoria(gasto.getCategoria());
        return (gastoPorCategoria + gasto.getMonto()) <= limiteCategoria;
    }

    public void agregarGasto(double monto, Categoria categoria) {
        double nuevoPresupuesto = this.presupuestoTotal - monto;
        Gasto gasto = new Gasto(monto, categoria);
        if (validarGasto(gasto)) {
            this.presupuestoTotal = nuevoPresupuesto;
            this.listaGastos.add(gasto);
            System.out
                    .println("Gasto agregado correctamente (" + gasto.getCategoria() + "-> $" + gasto.getMonto() + ")");
        } else {
            System.out.println(
                    "No se puede agregar el gasto. Supera el presupuesto total o el límite máximo por categoría.");
        }
    }

    public double getPresupuestoTotal() {
        return presupuestoTotal;
    }

    public double getPresupuestoInicial() {
        return presupuestoTotal + calcularTotalGeneralGastos();
    }

    public void setPresupuestoTotal(double presupuestoTotal) {
        this.presupuestoTotal = presupuestoTotal;
    }

    public double calcularTotalGeneralGastos() {
        double total = 0;
        for (Gasto gasto : listaGastos) {
            total += gasto.getMonto();
        }
        return total;
    }

    public double calcularTotalGastosPorCategoria(Categoria categoria) {
        double total = 0;
        for (Gasto gasto : listaGastos) {
            if (gasto.getCategoria() == categoria) {
                total += gasto.getMonto();
            }
        }
        return total;
    }

    public Categoria determinarCategoriaMayorGasto() {
        Categoria categoriaMayorGasto = Categoria.TRANSPORTE;
        double mayorGasto = calcularTotalGastosPorCategoria(Categoria.TRANSPORTE);

        for (Categoria categoria : Categoria.values()) {
            double totalGasto = calcularTotalGastosPorCategoria(categoria);
            if (totalGasto > mayorGasto) {
                mayorGasto = totalGasto;
                categoriaMayorGasto = categoria;
            }
        }

        return categoriaMayorGasto;
    }

    public void mostrarGastosEstudiante() {
        System.out.println("------------------- Gastos del estudiante -------------------");
        System.out.println("Presupuesto Inicial: $" + getPresupuestoInicial());
        System.out.println("Total de Gastos: $" + calcularTotalGeneralGastos());
        System.out.println("Gastos por categoría:");
        for (Categoria categoria : Categoria.values()) {
            System.out.println(" - " + categoria + ": $" + calcularTotalGastosPorCategoria(categoria));
        }
        System.out.println("Categoría con mayor gasto: $" + determinarCategoriaMayorGasto());
        System.out.println("Presupuesto Restante: $" + getPresupuestoTotal());
        System.out.println("-------------------------------------------------------------");
    }

}
