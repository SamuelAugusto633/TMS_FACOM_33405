/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.atividade_jogo_da_velha;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JogoDaVelhaTest {

    private final JogoDaVelha jogo = new JogoDaVelha();

    // Teste: Inicialização do Tabuleiro
    @Test
    public void testInicializarTabuleiro() {
        String[][] tabuleiro = jogo.getTabuleiro();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(" ", tabuleiro[i][j]);
            }
        }
    }

    // Teste: Alternância de Jogadores
    @Test
    public void testAlternarJogadores() {
        assertEquals("X", jogo.getJogadorAtual());
        jogo.fazerJogada(0, 0); 
        assertEquals("O", jogo.getJogadorAtual());
    }

    // Teste: Verificação de Vitória
    @Test
    public void testVerificarVitoria() {
        jogo.fazerJogada(0, 0); // Jogador X
        jogo.fazerJogada(1, 0); // Jogador O
        jogo.fazerJogada(0, 1); // Jogador X
        jogo.fazerJogada(1, 1); // Jogador O
        jogo.fazerJogada(0, 2); // Jogador X, e vence

        assertTrue(jogo.verificarVitoria()); // Jogador X deve ter vencido
    }

@Test
public void testEmpate() {
    JogoDaVelha jogo = new JogoDaVelha();

    // Jogadas que resultam em empate (um exemplo)
    jogo.fazerJogada(0, 0);
    jogo.fazerJogada(1, 0);
    jogo.fazerJogada(0, 1);
    jogo.fazerJogada(1, 1);
    jogo.fazerJogada(0, 2);
    jogo.fazerJogada(1, 2);
    jogo.fazerJogada(2, 0);
    jogo.fazerJogada(2, 1);
    jogo.fazerJogada(2, 2);  // Última jogada, resultando em empate

    // Verifica se a vitória é falsa antes de afirmar empate
    assertFalse(jogo.verificarVitoria()); // Não deve haver vencedor
    assertTrue(jogo.verificarEmpate()); // Deve ser empate
}


    // Teste: Movimentos Inválidos
    @Test
    public void testMovimentoInvalido() {
        jogo.fazerJogada(0, 0); // Jogador X
        assertThrows(IllegalArgumentException.class, () -> jogo.fazerJogada(0, 0)); // Jogar novamente na mesma posição
    }
}
