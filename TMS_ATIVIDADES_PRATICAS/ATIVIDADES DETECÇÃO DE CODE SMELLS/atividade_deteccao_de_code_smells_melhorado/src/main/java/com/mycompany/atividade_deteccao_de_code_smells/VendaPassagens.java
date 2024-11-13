/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_deteccao_de_code_smells;

/**
 *
 * @author Samuel
 */


import java.util.InputMismatchException;
import java.util.Scanner;

public class VendaPassagens {

    // Constantes para as cidades
    private static final String[] CIDADES = {"Monte Carmelo", "Uberlândia", "Patrocínio", "Uberaba"};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Solicita a cidade de destino
            System.out.println("Escolha a cidade de destino:");
            for (int i = 0; i < CIDADES.length; i++) {
                System.out.println((i + 1) + ". " + CIDADES[i]);
            }
            int cidadeEscolhida = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            // Solicita o dia da semana
            System.out.println("Informe o dia da semana (Segunda, Quarta, Sexta, Domingo):");
            String diaEscolhido = scanner.nextLine().toLowerCase();

            // Solicita o horário
            System.out.println("Informe o horário da viagem (em formato 24 horas, por exemplo: 14 para 14:00):");
            int horarioEscolhido = scanner.nextInt();

            // Validação da passagem
            if (ValidadorPassagem.isPassagemValida(diaEscolhido, horarioEscolhido)) {
                if (cidadeEscolhida >= 1 && cidadeEscolhida <= CIDADES.length) {
                    double preco = CalculadoraPreco.calcularPreco(diaEscolhido);
                    System.out.println("Passagem comprada para " + CIDADES[cidadeEscolhida - 1] + " no dia " + diaEscolhido + " com preço: R$ " + preco);
                } else {
                    System.out.println("Cidade inválida!");
                }
            } else {
                System.out.println("Não é possível comprar a passagem nesse dia e horário.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Por favor, insira um número válido.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}
