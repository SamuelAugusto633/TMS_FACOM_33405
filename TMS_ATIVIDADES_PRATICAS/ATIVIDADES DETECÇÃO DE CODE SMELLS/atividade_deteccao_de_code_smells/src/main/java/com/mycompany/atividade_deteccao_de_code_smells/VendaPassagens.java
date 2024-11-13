/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_deteccao_de_code_smells;

/**
 *
 * @author Samuel
 */
import java.util.Scanner;

public class VendaPassagens {

    // Método principal para executar a venda de passagens
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cidadeEscolhida;
        String diaDaSemana;
        int hora;
        
        // Mensagem inicial
        System.out.println("Bem-vindo ao sistema de venda de passagens de ônibus!");
        
        // Solicitando o nome da cidade
        System.out.println("Para qual cidade você deseja comprar passagens?");
        System.out.println("Opções: Monte Carmelo, Uberlândia, Patrocínio, Uberaba");
        cidadeEscolhida = scanner.nextLine();
        
        // Validando se a cidade é válida
        if (!cidadeEscolhida.equals("Monte Carmelo") && !cidadeEscolhida.equals("Uberlândia") &&
            !cidadeEscolhida.equals("Patrocínio") && !cidadeEscolhida.equals("Uberaba")) {
            System.out.println("Cidade inválida! Tente novamente.");
            return; // Interrompe a execução se a cidade não for válida
        }

        // Solicitando o dia da semana
        System.out.println("Qual o dia da semana? (ex: Segunda, Terça, Quarta, Quinta, Sexta, Sábado, Domingo)");
        diaDaSemana = scanner.nextLine();
        
        // Solicitando a hora
        System.out.println("Qual o horário da viagem? (ex: 14 para 14:00)");
        hora = scanner.nextInt();
        
        // Checando se a compra é permitida
        if (diaDaSemana.equalsIgnoreCase("domingo") && hora >= 14) {
            System.out.println("Desculpe, não é permitido comprar passagens após 14h no domingo.");
            return;
        }
        
        // Verificando o preço da passagem
        double preco = calcularPrecoPassagem(diaDaSemana);
        
        // Apresentando o preço final
        System.out.println("O preço da passagem para " + cidadeEscolhida + " é: R$ " + preco);
    }

    // Método que calcula o preço da passagem com base no dia da semana
    public static double calcularPrecoPassagem(String diaDaSemana) {
        double precoBase = 100.0; // Preço base de R$100,00

        // Aumento de preço nos dias específicos (segunda, quarta e sexta)
        if (diaDaSemana.equalsIgnoreCase("segunda") || diaDaSemana.equalsIgnoreCase("quarta") || diaDaSemana.equalsIgnoreCase("sexta")) {
            precoBase += 20.0; // Aumento de R$20,00
        }

        return precoBase;
    }
}
