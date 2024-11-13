/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_manipulacao_string;

/**
 *
 * @author Samuel
 */
public class ManipuladorDeStrings {

    public String inverter(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    public int contarOcorrencias(String str, char caractere) {
        if (str == null) return 0;
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == caractere) count++;
        }
        return count;
    }

    public boolean isPalindromo(String str) {
        if (str == null) return false;
        String invertida = inverter(str);
        return str.equalsIgnoreCase(invertida);
    }

    public String paraMaiusculas(String str) {
        return str == null ? null : str.toUpperCase();
    }

    public String paraMinusculas(String str) {
        return str == null ? null : str.toLowerCase();
    }
}
