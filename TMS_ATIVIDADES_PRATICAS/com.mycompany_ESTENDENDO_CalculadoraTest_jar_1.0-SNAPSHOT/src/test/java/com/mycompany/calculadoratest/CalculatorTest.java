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
public class CalculatorTest {
    
   Calculator calculadora = new Calculator();

    @Test
    public void testeSomar() {
        assertEquals(60, calculadora.somar(10, 50), 0.001);
    }

    @Test
    public void testeSubtrair() {
        assertEquals(5, calculadora.subtrair(10, 5), 0.001);
        assertEquals(-5, calculadora.subtrair(5, 10), 0.001);
    }

    @Test
    public void testeMultiplicar() {
        assertEquals(25, calculadora.multiplicar(5, 5), 0.001);
        assertEquals(0, calculadora.multiplicar(5, 0), 0.001);
    }

    @Test
    public void testeDividir() {
        assertEquals(2, calculadora.dividir(10, 5), 0.001);
    }

    @Test
    public void testeDividirPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.dividir(10, 0));
    }

    @Test
    public void testeRaizQuadrada() {
        assertEquals(4, calculadora.raizQuadrada(16), 0.001);
        assertEquals(0, calculadora.raizQuadrada(0), 0.001);
    }

    @Test
    public void testeRaizQuadradaDeNegativo() {
        assertThrows(ArithmeticException.class, () -> calculadora.raizQuadrada(-16));
    }

    @Test
    public void testePotencia() {
        assertEquals(25, calculadora.potencia(5, 2), 0.001);
        assertEquals(1, calculadora.potencia(5, 0), 0.001);
        assertEquals(0.2, calculadora.potencia(5, -1), 0.001);
    }
}