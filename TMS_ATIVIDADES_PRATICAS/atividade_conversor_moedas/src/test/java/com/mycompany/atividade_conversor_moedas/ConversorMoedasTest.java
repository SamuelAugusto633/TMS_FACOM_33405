/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.atividade_conversor_moedas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;



public class ConversorMoedasTest {
    private ConversorMoedas conversor;

    @BeforeEach
    public void setUp() {
        // Inicializa o conversor com um serviço de taxa fictício (dublê manual)
        conversor = new ConversorMoedas(new TaxaCambioService() {
            @Override
            public double obterTaxa(String moedaOrigem, String moedaDestino) throws Exception {
                // Define taxas fictícias
                if (moedaOrigem.equals("USD") && moedaDestino.equals("BRL")) {
                    return 5.0;
                } else if (moedaOrigem.equals("EUR") && moedaDestino.equals("BRL")) {
                    return 6.0;
                } else if (moedaOrigem.equals("AUD") && moedaDestino.equals("USD")) {
                    return 0.7;
                }
                throw new Exception("Taxa não disponível");
            }
        });
    }

    @Test
    public void testConverterUSDparaBRLporCodigo() throws Exception {
        double valorConvertido = conversor.converter("USD", "BRL", 10);
        Assertions.assertEquals(50.0, valorConvertido);
    }

    @Test
    public void testConverterUSDparaBRLporNome() throws Exception {
        double valorConvertido = conversor.converter("Dólar Americano", "Real Brasileiro", 10);
        Assertions.assertEquals(50.0, valorConvertido);
    }

    @Test
    public void testConverterEURparaBRLporCodigo() throws Exception {
        double valorConvertido = conversor.converter("EUR", "BRL", 10);
        Assertions.assertEquals(60.0, valorConvertido);
    }

    @Test
    public void testConverterAUDparaUSD() throws Exception {
        double valorConvertido = conversor.converter("Dólar Australiano", "Dólar Americano", 10);
        Assertions.assertEquals(7.0, valorConvertido);
    }

    @Test
    public void testMoedaInvalida() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> conversor.converter("XYZ", "BRL", 10));
    }
}
