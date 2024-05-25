package org.example.pojo;

import org.example.Main;
import org.example.enums.SandwichPrecio;
import org.example.enums.SandwichTamano;
import org.example.enums.SandwichTipo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sandwich {
    private String tipo;
    private List<Ingrediente> ingredientes;
    private float precio;
    private String tamano;


    //--|Constructor|-------------------------------------------------------------------------------------------------//
    public Sandwich() {
    }


    //--|Metodo / Comportamientos|------------------------------------------------------------------------------------//
    public String obtenerTipoDeSandwich() {
        System.out.print("""
                \nSeleccione un tipo
                \tSeleccion 1: Delicioso
                \tSeleccion 2: Exquisito
                \tSeleccion 3: Sabroso
                Respuesta:\s""");
        return obtenerTipoPorEleccion(Main.entradaTeclado.nextInt());
    }

    private String obtenerTipoPorEleccion(int eleccion) {
        return switch (eleccion) {
            case 1 -> SandwichTipo.DELICIOSO.tomarDescripcion();
            case 2 -> SandwichTipo.EXQUISITO.tomarDescripcion();
            case 3 -> SandwichTipo.SABROSO.tomarDescripcion();
            default -> throw new IllegalStateException("Valor inesperado: " + eleccion);
        };
    }

    public String obtenerTamanoDeSandwich() {
        System.out.print("""
                \nSeleccione un tipo
                \tSeleccion 1: XL
                \tSeleccion 2: NORMAL
                \tSeleccion 3: Para niño
                Respuesta:\s""");
        return obtenerTamanoPorEleccion(Main.entradaTeclado.nextInt());
    }

    private String obtenerTamanoPorEleccion(int eleccion) {
        return switch (eleccion) {
            case 1 -> SandwichTamano.XL.tomarDescripcion();
            case 2 -> SandwichTamano.NORMAL.tomarDescripcion();
            case 3 -> SandwichTamano.PARA_NINO.tomarDescripcion();
            default -> throw new IllegalStateException("Valor inesperado: " + eleccion);
        };
    }

    public float obtenerPrecio() {
        if (this.tamano.equalsIgnoreCase("Para niño")) {
            tamano = tamano.replace(' ', '_').replace('ñ', 'n');
        }

        SandwichTamano sandwichTamano = SandwichTamano.valueOf(this.tamano.toUpperCase());

        return switch (sandwichTamano) {
            case SandwichTamano.XL -> SandwichPrecio.PRECIO_XL.tomarValor();
            case SandwichTamano.NORMAL -> SandwichPrecio.PRECIO_NORMAL.tomarValor();
            case SandwichTamano.PARA_NINO -> SandwichPrecio.PRECIO_NINO.tomarValor();
        };
    }

    public List<Ingrediente> obtenerIngredientesPorTipoSandwitch() {
        List<String> listaDeIngredientes = definirIngredientesPorTipoSandwitch();
        List<Ingrediente> ingredientes = new ArrayList<>();

        for (String indice : listaDeIngredientes) {
            Ingrediente ingrediente = obtenerIngrediente(indice);
            ingrediente.calcularGramaje(this.tamano, this.tipo);

            ingredientes.add(ingrediente);
        }

        return ingredientes;
    }

    public List<String> definirIngredientesPorTipoSandwitch() {
        SandwichTipo tipoSandwich = SandwichTipo.valueOf(this.tipo.toUpperCase());

        return switch (tipoSandwich) {
            case DELICIOSO -> Arrays.asList("Lechuga", "Tomate");
            case EXQUISITO -> Arrays.asList("Queso", "Tomate", "Palta");
            case SABROSO -> Arrays.asList("Lechuga", "Tocino", "Pepinillos");
        };

    }

    public Ingrediente obtenerIngrediente(String ingrediente) {
        return new Ingrediente(ingrediente);

    }


    //--|Getter y Setter|---------------------------------------------------------------------------------------------//
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public String getTipo() {
        return tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public String getTamano() {
        return tamano;
    }

    //--|toString|----------------------------------------------------------------------------------------------------//
    @Override
    public String toString() {
        return "\tSandwich: \n" +
                "\t\tPrecio:\t" + precio + "\n" +
                "\t\tTipo:\t" + tipo + "\n" +
                "\t\tTamaño:\t" + tamano + "\n" +
                "\t\tIngredientes:\t\n" +
                "\t\t\t" + ingredientes + "\n";
    }
}
