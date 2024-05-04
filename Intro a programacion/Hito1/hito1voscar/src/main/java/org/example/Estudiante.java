package org.example;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estudiante {
    private double presupuestoTotal;
    private List<Compra> gastos;
    private Map<Categoria, Double> presupuestoCategoria;

    public Estudiante(double presupuestoTotal, List<Compra> gastos) {
        this.presupuestoTotal = presupuestoTotal;
        this.gastos = gastos;
        this.presupuestoCategoria = new HashMap<>();
        this.presupuestoCategoria.put(Categoria.TRANSPORTE, presupuestoTotal * 0.4);
        this.presupuestoCategoria.put(Categoria.COMIDA, presupuestoTotal * 0.3);
        this.presupuestoCategoria.put(Categoria.OCIO, presupuestoTotal * 0.3);

    }

    public void agregarCompra(Compra nuevaCompra) {
        if (nuevaCompra.getMonto() <= presupuestoCategoria.get(nuevaCompra.getCategoria())) {
            actualizarPresupuestoPorCategoria(nuevaCompra.getCategoria(), nuevaCompra.getMonto());
            actualizarPresupuestoTotal(nuevaCompra.getMonto());
            gastos.add(nuevaCompra);
            System.out.println("gasto agregado exitosamente " + nuevaCompra + "\n presupuesto restante: " + presupuestoTotal +
                    "\n FINAL presupuesto de la categoria actual " + presupuestoCategoria.get(nuevaCompra.getCategoria()));
        } else {
            System.out.println("No se pudo agregar la compra. El presupuesto restante es insuficiente.");
        }
    }

    public double getPresupuestoTotal() {
        return presupuestoTotal;
    }

    public List<Compra> getGastos() {
        return gastos;
    }

    public void actualizarPresupuestoTotal(double monto) {
        presupuestoTotal -= monto;
    }

    public void actualizarPresupuestoPorCategoria(Categoria categoria, double monto) {
        double presupuestoCategoriaActual = presupuestoCategoria.get(categoria);
        presupuestoCategoria.put(categoria, presupuestoCategoriaActual - monto);
    }


    @Override
    public String toString() {
        return "Estudiante{" +
                "presupuestoTotal=" + presupuestoTotal +
                ", gastos=" + gastos +
                ", presupuestoCategoria=" + presupuestoCategoria +
                '}';
    }
}