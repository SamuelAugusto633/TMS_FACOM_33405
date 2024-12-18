/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.introducao_ao_junit_5;

/**
 *
 * @author Samuel
 */
public class MathUtil {
     /**
     * Construtor privado para evitar que a classe seja instanciada.
     * Uma vez que ela só possui métodos estáticos e não
     * tem atributos, é totalmente desnecessário criar instâncias dela.
     */
    private MathUtil(){}
    
    /**
     * Calcula o MDC de dois números.
     * @param a 1º valor pra calcular o MDC
     * @param b 2º valor pra calcular o MDC
     * @return o MDC calculado
     *
     * @see <a href="https://pt.wikipedia.org/wiki/Máximo_divisor_comum#Propriedades">Propriedades MDC</a>
     */
    
    public static int mdc(int a, int b){
        
        if (b > 0 && a % b == 0){
            return b;
        }
        
        return -1;
    }

    
    
    /**
     * Verifica se um número é primo.
     * Um primo é um número natual maior que 1, que não pode ser formado pela multiplicação
     * de dois números naturais menores.
     *
     * @param numero número a ser testado.
     * @return true se o número for primo, false caso contrário
     *
     * @see <a href="https://pt.wikipedia.org/wiki/Número_primo">Número Primo</a>
     * @see <a href="https://en.wikipedia.org/wiki/Prime_number">Prime Number</a>
     */
    public static boolean isPrimo(final long numero){
        if(numero <= 1){
            return false;
        }

        for(long i = 2; i < numero; i++){
            if(numero%i==0){
                return false;
            }
        }

        return true;
    }
}