/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.atividade_conversor_unidades;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConversorDeUnidadesTest {

    private final ConversorDeUnidades conversor = new ConversorDeUnidades();

    // Testes para Comprimento
    @Test
    public void testConversaoComprimento() {
        // Testando as conversões de comprimento
        Assertions.assertEquals(1000, conversor.converterComprimento(1, "km", "m"));
        Assertions.assertEquals(0.001, conversor.converterComprimento(1, "m", "km"));
        Assertions.assertEquals(100, conversor.converterComprimento(1, "m", "cm"));
        Assertions.assertEquals(39370.1, conversor.converterComprimento(1, "cm", "in"), 0.1);
        Assertions.assertEquals(1.60934, conversor.converterComprimento(1, "mi", "km"), 0.0001);
    }

    // Testes para Peso
    @Test
    public void testConversaoPeso() {
        // Testando as conversões de peso
        Assertions.assertEquals(1000, conversor.converterPeso(1, "kg", "g"));
        Assertions.assertEquals(0.001, conversor.converterPeso(1, "g", "kg"));
        Assertions.assertEquals(2.20462, conversor.converterPeso(1, "kg", "lb"), 0.0001);
        Assertions.assertEquals(35.274, conversor.converterPeso(1, "oz", "g"), 0.1);
    }

    // Testes para Temperatura
    @Test
    public void testConversaoTemperatura() {
        // Testando as conversões de temperatura
        Assertions.assertEquals(32, conversor.converterTemperatura(0, "C", "F"));
        Assertions.assertEquals(273.15, conversor.converterTemperatura(0, "C", "K"), 0.01);
        Assertions.assertEquals(0, conversor.converterTemperatura(32, "F", "C"));
        Assertions.assertEquals(273.15, conversor.converterTemperatura(32, "F", "K"), 0.01);
        Assertions.assertEquals(373.15, conversor.converterTemperatura(100, "C", "K"), 0.01);
    }

    // Testando entradas inválidas
    @Test
    public void testEntradaInvalida() {
        // Teste para entradas inválidas
        Assertions.assertThrows(IllegalArgumentException.class, () -> conversor.converterComprimento(1, "km", "xyz"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> conversor.converterPeso(1, "kg", "xyz"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> conversor.converterTemperatura(0, "X", "F"));
    }
}
