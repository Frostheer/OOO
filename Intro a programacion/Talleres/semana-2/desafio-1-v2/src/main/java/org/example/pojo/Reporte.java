package org.example.pojo;

import org.example.enums.SandwichTamano;
import org.example.enums.SandwichTipo;

import java.util.List;

public class Reporte {
    private int contadorTananoXL;
    private int contadorTananoNormal;
    private int contadorTananoParaNino;

    private int contadorTipoDelicioso;
    private int contadorTipoExquisito;
    private int contadorTipoSabroso;

    private float ganancias;


    //----|Constructor|----//
    public Reporte() {
        this.contadorTananoXL = 0;
        this.contadorTananoNormal = 0;
        this.contadorTananoParaNino = 0;
        this.contadorTipoDelicioso = 0;
        this.contadorTipoExquisito = 0;
        this.contadorTipoSabroso = 0;
        this.ganancias = 0;
    }


    //----|Metodo / Comportamiento|----//
    public void actualizarReporte(List<Sandwich> sandwichLista) {
        for (Sandwich sandwich : sandwichLista) {
            actualizarPrecio(sandwich.getPrecio());
            actualizarContadorTamano(sandwich.getTamano());
            actualizarContadorTipo(sandwich.getTipo());
        }

    }

    private void actualizarContadorTamano(String tamano) {
        if (tamano.equalsIgnoreCase(SandwichTamano.XL.tomarDescripcion())) {
            this.contadorTananoXL += 1;
        } else if (tamano.equalsIgnoreCase(SandwichTamano.NORMAL.tomarDescripcion())) {
            this.contadorTananoNormal += 1;
        } else {
            this.contadorTananoParaNino += 1;
        }
    }

    private void actualizarContadorTipo(String tipo) {
        if (tipo.equalsIgnoreCase(SandwichTipo.DELICIOSO.tomarDescripcion())) {
            this.contadorTipoDelicioso += 1;
        } else if (tipo.equalsIgnoreCase(SandwichTipo.EXQUISITO.tomarDescripcion())) {
            this.contadorTipoExquisito += 1;
        } else {
            this.contadorTipoSabroso += 1;
        }
    }

    private void actualizarPrecio(float precio) {
        this.ganancias += precio;
    }


    @Override
    public String toString() {
        return "Reporte:\n" +
                "\tContador de tamaño (XL): " + contadorTananoXL +
                "\n\tContador de tamaño (Normal): " + contadorTananoNormal +
                "\n\tContador de tamaño (Para Niño): " + contadorTananoParaNino +
                "\n\tContador de tipo (Delicioso): " + contadorTipoDelicioso +
                "\n\tContador de tipo (Exquisito): " + contadorTipoExquisito +
                "\n\tContador de tipo (Sabroso): " + contadorTipoSabroso +
                "\n\tGanancias totales: $" + ganancias;
    }
}
