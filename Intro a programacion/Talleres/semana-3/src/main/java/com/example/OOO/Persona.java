package com.example.OOO;

public class Persona {
    private String nombreCompleto;
    private String RUT;
    private String telefono;
    private double ingresosMensuales;

    public Persona(String nombreCompleto, String RUT, String telefono, double ingresosMensuales) {
        this.nombreCompleto = nombreCompleto;
        this.RUT = RUT;
        this.telefono = telefono;
        this.ingresosMensuales = ingresosMensuales;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getRUT() {
        return RUT;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getIngresosMensuales() {
        return ingresosMensuales;
    }

    @Override
    public String toString() {
        return "Nombre: '" + nombreCompleto + '\'' +
                ", RUT: '" + RUT + '\'' +
                ", Teléfono: '" + telefono + '\'' +
                ", Ingresos Mensuales: " + ingresosMensuales;
    }

}
