/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_deteccao_de_code_smells;

/**
 *
 * @author Samuel
 */
public class CalculadoraPreco {
    private static final String SEGUNDA = "segunda";
    private static final String QUARTA = "quarta";
    private static final String SEXTA = "sexta";
    
    // Método para calcular o preço com base no dia
    public static double calcularPreco(String diaEscolhido) {
        double precoBase = 100.0;

        // Se o dia for mais caro (segunda, quarta ou sexta)
        if (diaEscolhido.equals(SEGUNDA) || diaEscolhido.equals(QUARTA) || diaEscolhido.equals(SEXTA)) {
            precoBase += 50.0; // Aumenta o preço em dias mais caros
        }

        return precoBase;
    }
}
