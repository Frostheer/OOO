package com.example.OOO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Refugio {
    private List<Animal> animales;
    private List<Informe> informes;

    public Refugio() {
        animales = new ArrayList<>();
        informes = new ArrayList<>();
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public List<Informe> getInformes() {
        return informes;
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);

    }

    public void generarInforme(LocalDate mes) {
        List<Adopcion> adopciones = new ArrayList<>();
        for (Animal animal : animales) {
            if (animal.isAdoptado()) {
                adopciones.add(new Adopcion(LocalDate.now(), animal, animal.getDueño()));
            }
        }

        Informe informe = new Informe(mes, adopciones);
        informes.add(informe);
        System.out.println(informe.toString());

    }

    public boolean validarIngresos(Persona adoptante) {
        return adoptante.getIngresosMensuales() > 100000;
    }

    public void registrarAdopcion(Animal animal, Persona adoptante) {
        if (animal.getCondicionSalud() == 10) {
            if (validarIngresos(adoptante)) {
                animal.setAdoptado(true);
                animal.setDueño(adoptante);
                System.out.println("Adopción realizada con éxito.");
            } else {
                System.out.println("El adoptante no cumple con los requisitos para adoptar.");
            }

        } else {
            System.out.println("El animal no se encuentra en óptimas condiciones de salud para ser adoptado.");
        }
    }

    public void registrarNuevoAnimal(Animal animal) {
        if (this.animales.contains(animal)) {
            System.out.println("El animal ya se encuentra registrado.");
            return;
        }

        animales.add(animal);
        System.out.println("Animal registrado con éxito.");
    }

    public void mostrarAnimalesPorEspecie(Especie especie) {
        System.out.println("----------------Animales de la especie " + especie + "----------------");
        for (Animal animal : animales) {
            if (animal.getEspecie().equals(especie)) {
                System.out.println(animal.toString());
            }
        }
        System.out.println("---------------------------------------------------------------");
    }

}
