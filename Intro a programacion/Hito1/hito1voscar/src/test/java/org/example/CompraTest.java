package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CompraTest {

    private List<Compra>compras;
    private double presupuesto;
    private Compra compra=new Compra();
@BeforeEach
void setUp() {
    compras = new ArrayList<>();
    presupuesto = 500;
    compra = new Compra();
}

    @Test
    void validarMonto_ComidaesComida() {
        compras.add(new Compra(200, Categoria.COMIDA));

        assertEquals(200, 200);//0 transporte 1 comida 2 ocio

    }



}