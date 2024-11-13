/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_conversor_unidades;

/**
 *
 * @author Samuel
 */

import java.util.HashMap;
import java.util.Map;

public class ConversorDeUnidades {

    // Conversões de Comprimento
    public double converterComprimento(double valor, String de, String para) {
        Map<String, Double> metros = new HashMap<>();
        metros.put("m", 1.0);
        metros.put("km", 1000.0); // 1 km = 1000 m
        metros.put("cm", 0.01);   // 1 m = 100 cm
        metros.put("mi", 1609.34); // 1 mi = 1609.34 m
        metros.put("in", 0.0254);  // 1 in = 0.0254 m

        if (!metros.containsKey(de) || !metros.containsKey(para)) {
            throw new IllegalArgumentException("Unidade de comprimento inválida.");
        }

        // Conversão de metros para a unidade desejada
        return valor * (metros.get(para) / metros.get(de));
    }

    // Conversões de Peso
    public double converterPeso(double valor, String de, String para) {
        Map<String, Double> peso = new HashMap<>();
        peso.put("g", 1.0);      // 1 g = 1 g
        peso.put("kg", 1000.0);  // 1 kg = 1000 g
        peso.put("lb", 2.20462); // 1 kg = 2.20462 lb
        peso.put("oz", 35.274);  // 1 kg = 35.274 oz

        if (!peso.containsKey(de) || !peso.containsKey(para)) {
            throw new IllegalArgumentException("Unidade de peso inválida.");
        }

        // Conversão de peso
        return valor * (peso.get(para) / peso.get(de));
    }

    // Conversões de Temperatura
    public double converterTemperatura(double valor, String de, String para) {
        if (de.equals("C") && para.equals("F")) {
            return valor * 9 / 5 + 32;
        } else if (de.equals("C") && para.equals("K")) {
            return valor + 273.15;
        } else if (de.equals("F") && para.equals("C")) {
            return (valor - 32) * 5 / 9;
        } else if (de.equals("F") && para.equals("K")) {
            return (valor - 32) * 5 / 9 + 273.15;
        } else if (de.equals("K") && para.equals("C")) {
            return valor - 273.15;
        } else if (de.equals("K") && para.equals("F")) {
            return (valor - 273.15) * 9 / 5 + 32;
        } else {
            throw new IllegalArgumentException("Conversão de temperatura inválida.");
        }
    }
}
