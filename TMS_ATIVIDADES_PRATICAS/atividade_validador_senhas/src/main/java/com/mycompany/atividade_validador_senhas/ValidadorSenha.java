/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_validador_senhas;

/**
 *
 * @author Samuel
 */
public class ValidadorSenha {

    public boolean validarSenha(String senha) {
        if (senha == null || senha.length() < 8) {
            return false;
        }
        if (!senha.matches(".*[A-Z].*")) {
            return false; // Deve conter ao menos uma letra maiúscula
        }
        if (!senha.matches(".*[a-z].*")) {
            return false; // Deve conter ao menos uma letra minúscula
        }
        if (!senha.matches(".*\\d.*")) {
            return false; // Deve conter ao menos um número
        }
        if (!senha.matches(".*[@#$%^&+=].*")) {
            return false; // Deve conter ao menos um caractere especial
        }
        if (senha.contains(" ")) {
            return false; // Não deve conter espaços
        }
        return true; // Senha válida se todos os critérios forem atendidos
    }
}
