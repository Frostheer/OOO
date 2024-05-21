package org.example;

import java.util.*;

public class Sala {
   private int numeroSala;
   private List<Pelicula> peliculas;
   private List<String> horarios;
   private int numeroAsientos;
   private List<Entrada> entradasVendidas;

   public Sala(int numeroSala, List<Pelicula> peliculas, List<String> horarios, int numeroAsientos) {
      this.numeroSala = numeroSala;
      this.peliculas = peliculas;
      this.horarios = horarios;
      this.numeroAsientos = numeroAsientos;
      this.entradasVendidas = new ArrayList<>();
   }

   public int getNumeroSala() {
      return numeroSala;
   }

   public List<Pelicula> getPeliculas() {
      return peliculas;
   }

   public List<String> getHorarios() {
      return horarios;
   }

   public int getNumeroAsientos() {
      return numeroAsientos;
   }

   public void venderEntradas(Entrada entrada) {
      numeroAsientos-=entrada.getCantidad();
      entradasVendidas.add(entrada);
   }

   public List<Entrada> getEntradasVendidas() {
      return entradasVendidas;
   }
}
