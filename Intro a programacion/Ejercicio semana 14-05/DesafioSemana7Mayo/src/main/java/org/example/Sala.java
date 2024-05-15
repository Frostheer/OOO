package org.example;

import java.util.*;

public class Sala {
   private int numeroSala;
   private List<Pelicula> peliculas;
   private List<String> horarios;
   private int numeroAsientos;

   public Sala(int numeroSala, List<Pelicula> peliculas, List<String> horarios, int numeroAsientos) {
      this.numeroSala = numeroSala;
      this.peliculas = peliculas;
      this.horarios = horarios;
      this.numeroAsientos = numeroAsientos;
   }

   public void venderEntradas(int cantidadEntradas) {
      this.numeroAsientos -= cantidadEntradas;
   }

   public int getNumeroSala() {
      return numeroSala;
   }

   public void setNumeroSala(int numeroSala) {
      this.numeroSala = numeroSala;
   }

   public List<Pelicula> getPeliculas() {
      return peliculas;
   }

   public void setPeliculas(List<Pelicula> peliculas) {
      this.peliculas = peliculas;
   }

   public List<String> getHorarios() {
      return horarios;
   }

   public void setHorarios(List<String> horarios) {
      this.horarios = horarios;
   }

   public int getNumeroAsientos() {
      return numeroAsientos;
   }

   public void setNumeroAsientos(int numeroAsientos) {
      this.numeroAsientos = numeroAsientos;
   }

   @Override
   public String toString() {
      return "Sala{" +
              "numeroSala=" + numeroSala +
              ", peliculas=" + peliculas +
              ", horarios=" + horarios +
              ", numeroAsientos=" + numeroAsientos +
              '}';
   }
}
