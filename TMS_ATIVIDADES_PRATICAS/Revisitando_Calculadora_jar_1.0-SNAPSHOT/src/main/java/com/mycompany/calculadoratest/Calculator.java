/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoratest;

/**
 *
 * @author Samuel
 */


public class Calculator {

    // Função de Soma
    public double somar(double a, double b) {
        return a + b;
    }

    // Função de Subtração
    public double subtrair(double a, double b) {
        return a - b;
    }

    // Função de Multiplicação
    public double multiplicar(double a, double b) {
        return a * b;
    }

    // Função de Divisão
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Não é possível dividir por zero");
        }
        return a / b;
    }

    // Função de Raiz Quadrada
    public double raizQuadrada(double a) {
        if (a < 0) {
            throw new ArithmeticException("Não é possível calcular a raiz quadrada de um número negativo");
        }
        return Math.sqrt(a);
    }

    // Função de Potência
    public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }
}
