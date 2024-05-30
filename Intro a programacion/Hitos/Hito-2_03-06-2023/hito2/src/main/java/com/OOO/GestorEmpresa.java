package com.OOO;

import java.util.ArrayList;
import java.util.List;

public class GestorEmpresa {

    private List<Empleado> empleados;

    public GestorEmpresa() {
        this.empleados = new ArrayList<Empleado>();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void calcularBeneficiosEmpleados() {
        for (Empleado empleado : empleados) {
            double ventasTotales = empleado.getVentasTotales();
            double comision = 0;

            if (ventasTotales < 100000) {
                comision = 0;
            } else if (ventasTotales <= 500000) {
                comision = 2000 * Math.floor(ventasTotales / 200000);
            } else if (ventasTotales <= 1000000) {
                comision = 2000 * Math.floor(500000 / 200000) + 2000 *
                        Math.floor((ventasTotales - 500000) / 150000);
            } else if (ventasTotales <= 2000000) {
                comision = 2000 * Math.floor(500000 / 200000) + 2000 *
                        Math.floor(500000 / 150000)
                        + 3000 * Math.floor((ventasTotales - 1000000) / 150000);
            } else {
                comision = 2000 * Math.floor(500000 / 200000) + 2000 * Math.floor(500000 / 150000)
                        + 3000 * Math.floor(1000000 / 150000) + 4000 * Math.floor((ventasTotales - 2000000) / 100000);
            }

            empleado.acumularComision(comision);
        }
    }

    public void listarEmpleados() {
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }
    }

}
