/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.atividade_manipulacao_string;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel
 */
public class ManipuladorDeStringsTest {

    ManipuladorDeStrings manipulador = new ManipuladorDeStrings();

    @Test
    public void testeInverter() {
        assertEquals("dcba", manipulador.inverter("abcd"));
        assertEquals("", manipulador.inverter(""));
        assertNull(manipulador.inverter(null));
    }

   @Test
public void testeContarOcorrencias() {
    assertEquals(3, manipulador.contarOcorrencias("banana", 'a')); // Corrigido para 3
    assertEquals(0, manipulador.contarOcorrencias("", 'a'));
    assertEquals(0, manipulador.contarOcorrencias(null, 'a'));
}


    @Test
    public void testeIsPalindromo() {
        assertTrue(manipulador.isPalindromo("radar"));
        assertFalse(manipulador.isPalindromo("java"));
        assertFalse(manipulador.isPalindromo(null));
    }

    @Test
    public void testeParaMaiusculas() {
        assertEquals("TESTE", manipulador.paraMaiusculas("teste"));
        assertEquals("", manipulador.paraMaiusculas(""));
        assertNull(manipulador.paraMaiusculas(null));
    }

    @Test
    public void testeParaMinusculas() {
        assertEquals("teste", manipulador.paraMinusculas("TESTE"));
        assertEquals("", manipulador.paraMinusculas(""));
        assertNull(manipulador.paraMinusculas(null));
    }
}