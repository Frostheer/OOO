package com.example.OOO;

import java.time.LocalDate;

public class Adopcion {
    private LocalDate fecha;
    private Animal animal;
    private Persona adoptante;

    public Adopcion(LocalDate fecha, Animal animal, Persona adoptante) {
        this.fecha = fecha;
        this.animal = animal;
        this.adoptante = adoptante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Persona getAdoptante() {
        return adoptante;
    }

    @Override
    public String toString() {
        return "Adopción realizada el " + fecha +
                " del animal " + animal.getNombre() + " - " + animal.getEspecie() +
                " por " + adoptante.getNombreCompleto() + " - " + adoptante.getRUT();
    }

}
