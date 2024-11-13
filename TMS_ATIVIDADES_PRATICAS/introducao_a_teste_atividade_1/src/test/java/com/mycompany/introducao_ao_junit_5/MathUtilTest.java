/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.introducao_ao_junit_5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel
 * 
 * 
 * /**
 * Classe para inclusão dos testes unitários para
 * os métodos mdc() da classe {@link MathUtil},
 * que calcula o Máximo Divisor Comum de dois ou mais números.
 *
 * <p>Cada teste unitário deve verificar uma determinada propriedade
 * do MDC. Os métodos de teste indicam o número da 
 * <a href="https://pt.wikipedia.org/wiki/Máximo_divisor_comum#Propriedades">propriedade<</a> 
 * testada (como p1) no nome.</p>
 * 
 * 
 */


 /**
     * Teste parametrizado para a propriedade 1 da função {@link MathUtil#mdc(int, int)}.
     * Assim, o teste é executado múltiplas vezes com valores diferentes.
     *
    
     * @param a valor para o 1o parâmetro da função mdc.
     * @param b valor para o 2o parâmetro da função mdc
     * @param esperado valor esperado como resultado da chamada da função mdc.
     * 
     */


public class MathUtilTest {
    
    public MathUtilTest() {
    }

    @Test
    public void testMdcAParP1() {
        final int a = 6;
        final int b = 3;
        final int esperado = b;
        final int obtido = MathUtil.mdc(a, b);
        
        assertEquals(esperado, obtido);
        
        
    }

    @Test
    public void testIsPrimoAImparP1() {
            final int a = 9;
            final int b = 3;
            final int esperado = b;
            final int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
        
    }
    
    
    
}
