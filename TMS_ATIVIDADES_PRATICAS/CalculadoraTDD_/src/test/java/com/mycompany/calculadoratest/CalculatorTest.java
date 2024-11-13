/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.calculadoratest;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CalculatorTest {

    
    Calculator calculadora = new Calculator();

    // Teste 1: Soma de dois números positivos
    @Test
    public void testeSomarDoisPositivos() {
        assertEquals(15, calculadora.somar(10, 5), 0.001);
    }

    // Teste 2: Soma de dois números negativos
    @Test
    public void testeSomarDoisNegativos() {
        assertEquals(-15, calculadora.somar(-10, -5), 0.001);
    }

    // Teste 3: Soma de um número positivo e um negativo
    @Test
    public void testeSomarPositivoENegativo() {
        assertEquals(5, calculadora.somar(10, -5), 0.001);
    }

    // Teste 4: Soma de valores muito grandes
    @Test
    public void testeSomarValoresGrandes() {
        assertEquals(1e12 + 1e12, calculadora.somar(1e12, 1e12), 0.001);
    }

    // Teste 5: Soma de valores muito pequenos
    @Test
    public void testeSomarValoresPequenos() {
        assertEquals(0.0001 + 0.0001, calculadora.somar(0.0001, 0.0001), 0.00001);
    }

    // Teste 6: Soma com NaN (deve lançar exceção)
    @Test
    public void testeSomarComNaoNumero() {
        // Espera-se que o método lance IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> calculadora.somar(Double.NaN, 5));
    }

    // Teste 7: Soma de valores decimais
    @Test
    public void testeSomarValoresDecimais() {
        assertEquals(10.5 + 4.5, calculadora.somar(10.5, 4.5), 0.001);
    }

    // Teste Parametrizado 1: Soma de vários pares de números
    @ParameterizedTest
    @CsvSource({
        "10, 5, 15",  // 10 + 5 = 15
        "2, 3, 5",    // 2 + 3 = 5
        "-1, -1, -2", // -1 + (-1) = -2
        "1, -1, 0"    // 1 + (-1) = 0
    })
    public void testeSomarComParametros(double a, double b, double resultadoEsperado) {
        assertEquals(resultadoEsperado, calculadora.somar(a, b), 0.001);
    }

    // Teste com Hamcrest: Usando Hamcrest para melhorar a asserção
    @Test
    public void testeSomarComHamcrest() {
        assertThat(calculadora.somar(10, 5), is (15.0));
    }
}
