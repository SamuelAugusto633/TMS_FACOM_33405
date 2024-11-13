/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.atividade_validador_senhas;

import java.util.Scanner;

/**
 *
 * @author Samuel
 */
public class Atividade_validador_senhas {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ValidadorSenha validadorSenha = new ValidadorSenha();

        System.out.println("Bem-vindo ao Validador de Senhas!");
        System.out.print("Digite a senha para validação: ");
        
        String senha = scanner.nextLine();
        
        boolean senhaValida = validadorSenha.validarSenha(senha);
        
        if (senhaValida) {
            System.out.println("Senha válida.");
        } else {
            System.out.println("Senha inválida. Certifique-se de que a senha atende aos seguintes critérios:");
            System.out.println("- Pelo menos 8 caracteres;");
            System.out.println("- Pelo menos uma letra maiúscula;");
            System.out.println("- Pelo menos uma letra minúscula;");
            System.out.println("- Pelo menos um número;");
            System.out.println("- Pelo menos um caractere especial (@, #, $, etc.);");
            System.out.println("- Sem espaços em branco.");
        }

        scanner.close();
    }
}