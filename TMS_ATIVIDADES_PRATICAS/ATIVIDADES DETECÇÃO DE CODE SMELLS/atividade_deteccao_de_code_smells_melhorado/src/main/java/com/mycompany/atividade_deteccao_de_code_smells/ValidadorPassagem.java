/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_deteccao_de_code_smells;

/**
 *
 * @author Samuel
 */
public class ValidadorPassagem {
    private static final String DOMINGO = "domingo";
    
    // Verifica se a passagem pode ser comprada (não pode no domingo após 14:00)
    public static boolean isPassagemValida(String diaEscolhido, int horarioEscolhido) {
        if (diaEscolhido.equals(DOMINGO) && horarioEscolhido >= 14) {
            return false;
        }
        return true;
    }
}
