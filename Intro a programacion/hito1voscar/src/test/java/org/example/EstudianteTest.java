package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstudianteTest {
    private Estudiante estudiante;

    @BeforeEach
    void setUp() {
        List<Compra> gastos = new ArrayList<>();
        estudiante = new Estudiante(1200.0, gastos);
    }
    @Test
    void agregarCompra_exitoso() {
        Compra compra = new Compra(300.0, Categoria.COMIDA);
        Compra compra2 = new Compra(100.0, Categoria.TRANSPORTE);
        Compra compra3 = new Compra(100.0, Categoria.TRANSPORTE);

        estudiante.agregarCompra(compra);
        estudiante.agregarCompra(compra2);
        estudiante.agregarCompra(compra3);

        List<Compra> gastos = estudiante.getGastos();
        System.out.println("los gastos son" + gastos + "el presupuesto total es " + estudiante.getPresupuestoTotal());

        assertEquals(300.0, gastos.get(0).getMonto());
        assertEquals(Categoria.COMIDA, gastos.get(0).getCategoria());
        assertEquals(700.0, estudiante.getPresupuestoTotal());


    }

}
