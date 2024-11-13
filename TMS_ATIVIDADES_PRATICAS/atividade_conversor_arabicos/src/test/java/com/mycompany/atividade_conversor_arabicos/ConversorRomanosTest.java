/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.atividade_conversor_arabicos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

public class ConversorRomanosTest {
    private ConversorRomanos conversor;

    @BeforeEach
    public void setUp() {
        conversor = new ConversorRomanos();
    }

    @Test
    public void testConversaoArabeParaRomano() {
        Assertions.assertEquals("I", conversor.converterParaRomano(1));
        Assertions.assertEquals("IV", conversor.converterParaRomano(4));
        Assertions.assertEquals("IX", conversor.converterParaRomano(9));
        Assertions.assertEquals("XL", conversor.converterParaRomano(40));
        Assertions.assertEquals("XC", conversor.converterParaRomano(90));
        Assertions.assertEquals("CD", conversor.converterParaRomano(400));
        Assertions.assertEquals("CM", conversor.converterParaRomano(900));
        Assertions.assertEquals("MMXXIV", conversor.converterParaRomano(2024));
    }

    @Test
    public void testConversaoRomanoParaArabe() {
        Assertions.assertEquals(1, conversor.converterParaArabe("I"));
        Assertions.assertEquals(4, conversor.converterParaArabe("IV"));
        Assertions.assertEquals(9, conversor.converterParaArabe("IX"));
        Assertions.assertEquals(40, conversor.converterParaArabe("XL"));
        Assertions.assertEquals(90, conversor.converterParaArabe("XC"));
        Assertions.assertEquals(400, conversor.converterParaArabe("CD"));
        Assertions.assertEquals(900, conversor.converterParaArabe("CM"));
        Assertions.assertEquals(2024, conversor.converterParaArabe("MMXXIV"));
    }

    @Test
    public void testEntradaInvalidaArabeParaRomano() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> conversor.converterParaRomano(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> conversor.converterParaRomano(4000));
    }

@Test
public void testEntradaInvalidaRomanoParaArabe() {
    //Assertions.assertThrows(IllegalArgumentException.class, () -> conversor.converterParaArabe("IIII"));
    Assertions.assertThrows(IllegalArgumentException.class, () -> conversor.converterParaArabe("XLAC"));
    Assertions.assertThrows(IllegalArgumentException.class, () -> conversor.converterParaArabe(null));
    Assertions.assertThrows(IllegalArgumentException.class, () -> conversor.converterParaArabe(""));
}


}
