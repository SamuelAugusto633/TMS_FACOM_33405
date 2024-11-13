/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_conversor_arabicos;

/**
 *
 * @author Samuel
 */


import java.util.HashMap;
import java.util.Map;

public class ConversorRomanos {
    private static final Map<Character, Integer> mapaRomanos;

    static {
        mapaRomanos = new HashMap<>();
        mapaRomanos.put('I', 1);
        mapaRomanos.put('V', 5);
        mapaRomanos.put('X', 10);
        mapaRomanos.put('L', 50);
        mapaRomanos.put('C', 100);
        mapaRomanos.put('D', 500);
        mapaRomanos.put('M', 1000);
    }

    public String converterParaRomano(int numeroArabe) {
        if (numeroArabe <= 0 || numeroArabe > 3999) {
            throw new IllegalArgumentException("Número fora do intervalo suportado (1-3999).");
        }

        StringBuilder resultado = new StringBuilder();
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < valores.length; i++) {
            while (numeroArabe >= valores[i]) {
                numeroArabe -= valores[i];
                resultado.append(simbolos[i]);
            }
        }

        return resultado.toString();
    }

    public int converterParaArabe(String numeroRomano) {
        if (numeroRomano == null || numeroRomano.isEmpty()) {
            throw new IllegalArgumentException("Entrada inválida.");
        }

        int total = 0;
        int valorAnterior = 0;

        // Verificação de validade de símbolos romanos
        for (int i = numeroRomano.length() - 1; i >= 0; i--) {
            char atual = numeroRomano.charAt(i);
            int valorAtual = mapaRomanos.getOrDefault(atual, -1);

            if (valorAtual == -1) {
                throw new IllegalArgumentException("Símbolo romano inválido: " + atual);
            }

            // Se a combinação estiver incorreta, a subtração deve ser feita somente em determinados casos
            if (valorAtual < valorAnterior) {
                if (!isSubtractionValid(atual, numeroRomano.charAt(i + 1))) {
                    throw new IllegalArgumentException("Combinação inválida de símbolos romanos.");
                }
                total -= valorAtual;
            } else {
                total += valorAtual;
            }

            valorAnterior = valorAtual;
        }

        return total;
    }

    // Método para verificar se a subtração é válida
    private boolean isSubtractionValid(char current, char next) {
        switch (current) {
            case 'I': return next == 'V' || next == 'X';
            case 'X': return next == 'L' || next == 'C';
            case 'C': return next == 'D' || next == 'M';
            case 'V': case 'L': case 'D': return false; // Não pode ser subtraído
            default: return false;
        }
    }
}
