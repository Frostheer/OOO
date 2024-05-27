package com.example.OOO;

import java.time.LocalDate;
import java.util.List;

public class Informe {
    private LocalDate mes;
    private List<Adopcion> adopciones;

    public Informe(LocalDate mes, List<Adopcion> adopciones) {
        this.mes = mes;
        this.adopciones = adopciones;
    }

    public LocalDate getFecha() {
        return mes;
    }

    public List<Adopcion> getAdopciones() {
        return adopciones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("------------------------------------------------\n");
        sb.append("Informe del mes ");
        sb.append(mes.getMonth()).append(" del año ").append(mes.getYear()).append("\n");

        if (adopciones.isEmpty()) {
            sb.append("No se han realizado adopciones en este mes.");
        } else {
            for (Adopcion adopcion : adopciones) {
                sb.append(adopcion.toString()).append("\n");
            }
        }

        sb.append("\n------------------------------------------------\n");

        return sb.toString();

    }

}
