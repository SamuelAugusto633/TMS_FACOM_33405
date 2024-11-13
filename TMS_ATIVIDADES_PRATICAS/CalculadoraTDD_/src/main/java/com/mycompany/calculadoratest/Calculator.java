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

    // Método somar com verificação de entrada para NaN
    public double somar(double a, double b) {
        // Verifica se algum dos valores é NaN
        if (Double.isNaN(a) || Double.isNaN(b)) {
            throw new IllegalArgumentException("Os valores fornecidos não podem ser NaN");
        }
        // Retorna v
        return a + b;
    }

    
    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Não é possível dividir por zero");
        }
        return a / b;
    }

    public double raizQuadrada(double a) {
        if (a < 0) {
            throw new ArithmeticException("Não é possível calcular a raiz quadrada de um número negativo");
        }
        return Math.sqrt(a);
    }

    public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }
}
