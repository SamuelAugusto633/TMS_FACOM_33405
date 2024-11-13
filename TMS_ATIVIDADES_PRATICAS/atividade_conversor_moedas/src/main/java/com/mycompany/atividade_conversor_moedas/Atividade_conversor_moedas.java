/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.atividade_conversor_moedas;
import java.util.Scanner;
/**
 *
 * @author Samuel
 */
public class Atividade_conversor_moedas {

    public static void main(String[] args) {
        // Configura o conversor de moedas com um serviço fictício
        TaxaCambioService taxaCambioService = new TaxaCambioService() {
            @Override
            public double obterTaxa(String moedaOrigem, String moedaDestino) throws Exception {
                // Taxas fictícias para teste
                if (moedaOrigem.equals("USD") && moedaDestino.equals("BRL")) return 5.0;
                if (moedaOrigem.equals("EUR") && moedaDestino.equals("BRL")) return 6.0;
                if (moedaOrigem.equals("AUD") && moedaDestino.equals("USD")) return 0.7;
                throw new Exception("Taxa de câmbio não disponível para as moedas especificadas.");
            }
        };

        ConversorMoedas conversor = new ConversorMoedas(taxaCambioService);
        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.println("Bem-vindo ao Conversor de Moedas!");
            System.out.print("Digite a moeda de origem (exemplo: USD ou Dólar Americano): ");
            String moedaOrigem = scanner.nextLine();

            System.out.print("Digite a moeda de destino (exemplo: BRL ou Real Brasileiro): ");
            String moedaDestino = scanner.nextLine();

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            
            double valorConvertido = conversor.converter(moedaOrigem, moedaDestino, valor);
            System.out.printf("Resultado: %.2f %s = %.2f %s%n", valor, moedaOrigem, valorConvertido, moedaDestino);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}