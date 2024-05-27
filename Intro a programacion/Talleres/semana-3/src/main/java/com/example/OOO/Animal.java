package com.example.OOO;

public class Animal {
    private String nombre;
    private Especie especie;
    private int condicionSalud; // 0 - 10
    private boolean adoptado;
    private Persona dueño;

    public Animal(String nombre, Especie especie, int condicionSalud, boolean adoptado, Persona dueño) {
        this.nombre = nombre;
        this.especie = especie;
        this.condicionSalud = condicionSalud;
        this.adoptado = adoptado;
        this.dueño = dueño;
    }

    public String getNombre() {
        return nombre;
    }

    public Especie getEspecie() {
        return especie;
    }

    public int getCondicionSalud() {
        return condicionSalud;
    }

    public boolean isAdoptado() {
        return adoptado;
    }

    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }

    public void setDueño(Persona dueño) {
        this.dueño = dueño;
    }

    public Persona getDueño() {
        return dueño;
    }

    @Override
    public String toString() {
        return "Nombre: '" + nombre + '\'' +
                ", Especie: " + especie +
                ", Condición de Salud: " + condicionSalud +
                ", Adoptado: " + (adoptado ? "Sí" : "No") +
                ", Dueño: " + (dueño != null ? dueño.toString() : "No Aplica");
    }
}
