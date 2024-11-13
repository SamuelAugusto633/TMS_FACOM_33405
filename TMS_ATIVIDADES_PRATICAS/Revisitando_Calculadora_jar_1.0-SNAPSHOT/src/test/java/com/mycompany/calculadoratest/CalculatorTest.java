/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.calculadoratest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel
 */


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;

public class CalculatorTest {
    
    Calculator calculadora = new Calculator();

    // Teste de Soma
    @Test
    public void testeSomar() {
        assertEquals(60, calculadora.somar(10, 50), 0.001);
    }

    // Teste de Subtração
    @Test
    public void testeSubtrair() {
        assertEquals(5, calculadora.subtrair(10, 5), 0.001);
        assertEquals(-5, calculadora.subtrair(5, 10), 0.001);
    }

    // Teste de Multiplicação
    @Test
    public void testeMultiplicar() {
        assertEquals(25, calculadora.multiplicar(5, 5), 0.001);
        assertEquals(0, calculadora.multiplicar(5, 0), 0.001);
    }

    // Teste de Divisão
@Test
public void testeDividir() {
    // Casos com números positivos
    assertEquals(2, calculadora.dividir(10, 5), 0.001);   // 10 / 5 = 2
    assertEquals(2.5, calculadora.dividir(5, 2), 0.001);  // 5 / 2 = 2.5

    // Caso de divisão por zero
    assertThrows(ArithmeticException.class, () -> calculadora.dividir(10, 0));

    // Casos com números negativos
    assertEquals(-2, calculadora.dividir(-10, 5), 0.001); // -10 / 5 = -2
    assertEquals(-2.5, calculadora.dividir(-5, 2), 0.001); // -5 / 2 = -2.5
    assertEquals(-2.5, calculadora.dividir(5, -2), 0.001); // 5 / -2 = -2.5

    // Caso com zero
    assertEquals(0, calculadora.dividir(0, 5), 0.001);    // 0 / 5 = 0
}


    // Teste de Raiz Quadrada
    @Test
    public void testeRaizQuadrada() {
        assertEquals(4, calculadora.raizQuadrada(16), 0.001);
        assertEquals(0, calculadora.raizQuadrada(0), 0.001);
        assertEquals(2.236, calculadora.raizQuadrada(5), 0.001);
        assertThrows(ArithmeticException.class, () -> calculadora.raizQuadrada(-16));
    }

    // Teste de Potência
    @Test
    public void testePotencia() {
        assertEquals(25, calculadora.potencia(5, 2), 0.001);
        assertEquals(1, calculadora.potencia(5, 0), 0.001);
        assertEquals(0.2, calculadora.potencia(5, -1), 0.001);
    }

    // Teste Parametrizado para Divisão
    @ParameterizedTest
    @CsvSource({
        "10, 5, 2",
        "5, 2, 2.5",
        "-10, 5, -2",
        "5, -2, -2.5",
        "0, 5, 0"
    })
    public void testeDividirComParametros(double a, double b, double resultadoEsperado) {
        assertEquals(resultadoEsperado, calculadora.dividir(a, b), 0.001);
    }

    // Teste Parametrizado para Raiz Quadrada
    @ParameterizedTest
    @CsvSource({
        "16, 4",
        "0, 0",
        "25, 5",
        "9, 3"
    })
    public void testeRaizQuadradaComParametros(double a, double resultadoEsperado) {
        assertEquals(resultadoEsperado, calculadora.raizQuadrada(a), 0.001);
    }
}
