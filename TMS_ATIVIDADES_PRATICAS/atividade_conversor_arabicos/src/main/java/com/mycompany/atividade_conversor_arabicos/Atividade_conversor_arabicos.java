/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.atividade_conversor_arabicos;

import java.util.Scanner;

/**
 *
 * @author Samuel
 */
public class Atividade_conversor_arabicos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorRomanos conversor = new ConversorRomanos();

        System.out.println("Bem-vindo ao Conversor de Números Arábicos e Romanos!");
        
        // Opção para converter de arábico para romano
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Converter número arábico para romano");
        System.out.println("2 - Converter número romano para arábico");
        System.out.print("Digite sua opção (1 ou 2): ");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        if (opcao == 1) {
            System.out.print("Digite o número arábico para conversão: ");
            int numeroArabe = scanner.nextInt();
            try {
                String numeroRomano = conversor.converterParaRomano(numeroArabe);
                System.out.println("Número romano: " + numeroRomano);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } else if (opcao == 2) {
            System.out.print("Digite o número romano para conversão: ");
            String numeroRomano = scanner.nextLine();
            try {
                int numeroArabe = conversor.converterParaArabe(numeroRomano);
                System.out.println("Número arábico: " + numeroArabe);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } else {
            System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}