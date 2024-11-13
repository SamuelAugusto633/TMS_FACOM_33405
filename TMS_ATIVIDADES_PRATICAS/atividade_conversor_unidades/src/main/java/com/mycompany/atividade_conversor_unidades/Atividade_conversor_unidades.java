/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.atividade_conversor_unidades;

/**
 *
 * @author Samuel
 */
import java.util.Scanner;

public class Atividade_conversor_unidades {

    public static void main(String[] args) {
        // Criação do objeto da classe ConversorDeUnidades
        ConversorDeUnidades conversor = new ConversorDeUnidades();
        
        // Criação do scanner para ler as entradas do usuário
        Scanner scanner = new Scanner(System.in);

      
        System.out.println("Escolha a categoria de conversão:");
        System.out.println("1. Comprimento");
        System.out.println("2. Peso");
        System.out.println("3. Temperatura");
        
  
        int categoria = scanner.nextInt();
        
        switch (categoria) {
            case 1:
                // Lógica para conversão de Comprimento
                System.out.println("Digite o valor a ser convertido:");
                double valorComprimento = scanner.nextDouble();
                System.out.println("Digite a unidade de origem (m, km, cm, mi, in):");
                String unidadeOrigemComprimento = scanner.next().toLowerCase();  
                System.out.println("Digite a unidade de destino (m, km, cm, mi, in):");
                String unidadeDestinoComprimento = scanner.next().toLowerCase();  
                
              
                try {
                    double resultadoComprimento = conversor.converterComprimento(valorComprimento, unidadeOrigemComprimento, unidadeDestinoComprimento);
                   
                    System.out.println("Resultado da conversão: " + resultadoComprimento);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                // Lógica para conversão de Peso
                System.out.println("Digite o valor a ser convertido:");
                double valorPeso = scanner.nextDouble();
                System.out.println("Digite a unidade de origem (g, kg, lb, oz):");
                String unidadeOrigemPeso = scanner.next().toLowerCase(); 
                System.out.println("Digite a unidade de destino (g, kg, lb, oz):");
                String unidadeDestinoPeso = scanner.next().toLowerCase();  
                
          
                try {
                    double resultadoPeso = conversor.converterPeso(valorPeso, unidadeOrigemPeso, unidadeDestinoPeso);
                    // Exibindo o resultado
                    System.out.println("Resultado da conversão: " + resultadoPeso);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                // Lógica para conversão de Temperatura
                System.out.println("Digite o valor a ser convertido:");
                double valorTemperatura = scanner.nextDouble();
                System.out.println("Digite a unidade de origem (C, F, K):");
                String unidadeOrigemTemperatura = scanner.next().toUpperCase();  
                System.out.println("Digite a unidade de destino (C, F, K):");
                String unidadeDestinoTemperatura = scanner.next().toUpperCase();  
                
                // Chamando o método de conversão de temperatura
                try {
                    double resultadoTemperatura = conversor.converterTemperatura(valorTemperatura, unidadeOrigemTemperatura, unidadeDestinoTemperatura);
                    
                    System.out.println("Resultado da conversão: " + resultadoTemperatura);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Categoria inválida.");
                break;
        }


        scanner.close();
    }
}
