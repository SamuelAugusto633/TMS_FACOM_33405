
/*

* versão original do codigo  "atividade_deteccao_de_code_smells" esta nesta mesma pasta de exercicios
*
 * O que mudou na versão melhorada e sem CODE SMELLS:
 * 
 * Divisão de responsabilidades:
 * 
 * - Classe ValidadorPassagem: Responsável por verificar se o dia e o horário são válidos para comprar a passagem.
 * - Classe CalculadoraPreco: Responsável por calcular o preço da passagem com base no dia da semana.
 * - Classe VendaPassagens: Responsável pela interação com o usuário e orquestração do fluxo de compra de passagens.
 * 
 * Tratamento de exceções:
 * 
 * - agora  a um tratamento de exceção usando try-catch para capturar exceções de entrada inválida, como quando o usuário insere um valor não numérico.
 * - o codigo Também lida com exceções gerais para capturar erros inesperados e dar uma mensagem amigável ao usuário.
 * 
 * Validação de entrada do usuário:
 * 
 * - O código agora lida melhor com entradas inválidas, como valores de cidades ou horários incorretos.
 * - Se o usuário tentar inserir um valor inválido, como um número fora do intervalo de 1 a 4 para a cidade ou um horário inválido, o código captura a exceção e informa o usuário.
 * 
 * Benefícios dessa versão:
 * 
 * - Modularidade: Agora temos várias classes com responsabilidades claras, o que facilita a manutenção e os testes.
 * - Tratamento de erros: O código é mais robusto e pode lidar com entradas inválidas sem travar.
 * - Facilidade de manutenção: Agora é mais fácil adicionar novas funcionalidades ou fazer alterações, pois as responsabilidades estão bem separadas.
 * 
 * 
 */





package com.mycompany.atividade_deteccao_de_code_smells;




public class Atividade_deteccao_de_code_smells {

    public static void main(String[] args) {
       
        System.out.println("Iniciando a aplicação de venda de passagens...");
        
        
        VendaPassagens.main(args);
    }
}
