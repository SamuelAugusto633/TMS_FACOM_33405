/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_jogo_da_velha;

/**
 *
 * @author Samuel
 */
public class JogoDaVelha {

    private String[][] tabuleiro;
    private String jogadorAtual;
    private int jogadas;

    public JogoDaVelha() {
        tabuleiro = new String[3][3];
        jogadorAtual = "X";
        jogadas = 0;

        // Inicializando o tabuleiro com espaços vazios
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = " ";
            }
        }
    }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public String getJogadorAtual() {
        return jogadorAtual;
    }

    public void fazerJogada(int linha, int coluna) {
        if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3 || !tabuleiro[linha][coluna].equals(" ")) {
            throw new IllegalArgumentException("Movimento inválido");
        }

        tabuleiro[linha][coluna] = jogadorAtual;
        jogadas++;
        if (jogadorAtual.equals("X")) {
            jogadorAtual = "O";
        } else {
            jogadorAtual = "X";
        }
    }

    public boolean verificarVitoria() {
        // Verifica linhas, colunas e diagonais
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0].equals(tabuleiro[i][1]) && tabuleiro[i][0].equals(tabuleiro[i][2]) && !tabuleiro[i][0].equals(" ")) {
                return true;
            }
            if (tabuleiro[0][i].equals(tabuleiro[1][i]) && tabuleiro[0][i].equals(tabuleiro[2][i]) && !tabuleiro[0][i].equals(" ")) {
                return true;
            }
        }
        if (tabuleiro[0][0].equals(tabuleiro[1][1]) && tabuleiro[0][0].equals(tabuleiro[2][2]) && !tabuleiro[0][0].equals(" ")) {
            return true;
        }
        if (tabuleiro[0][2].equals(tabuleiro[1][1]) && tabuleiro[0][2].equals(tabuleiro[2][0]) && !tabuleiro[0][2].equals(" ")) {
            return true;
        }
        return false;
    }

public boolean verificarEmpate() {
    // Verifica se já há um vencedor
    if (verificarVitoria()) {
        return false; // Não é empate se houver um vencedor
    }

    // Verifica se o tabuleiro está cheio e sem vencedor
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[i][j].equals(" ")) {
                return false; // Se houver algum espaço vazio, o jogo não acabou
            }
        }
    }

    // Se o tabuleiro estiver cheio e não houver vitória, é empate
    return true;
}


}
