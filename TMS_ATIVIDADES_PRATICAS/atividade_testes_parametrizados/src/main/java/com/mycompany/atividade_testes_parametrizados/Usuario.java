/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_testes_parametrizados;

/**
 *
 * @author Samuel
 */
public class Usuario {
    private String nome;
    private String email;
    private String usuario;
    private int tentativasFalhas = 0;
    private long ultimaTentativa = 0;

    public Usuario(String nome, String email, String usuario) {
        this.nome = nome;
        this.email = email;
        this.usuario = usuario;
    }

    public boolean autenticar(String senha, String algoritmo) throws Exception {
        if (System.currentTimeMillis() - ultimaTentativa < 30000 && tentativasFalhas >= 3) {
            throw new ExceededAttemptsException("Número máximo de tentativas excedido");
        }

        if (!algoritmoValido(algoritmo)) {
            throw new Exception("Algoritmo desconhecido");
        }

        // Supondo uma validação simples de senha
        if (senha.equals("senhaValida")) {
            tentativasFalhas = 0; // Resetando as tentativas após sucesso
            return true;
        } else {
            tentativasFalhas++;
            ultimaTentativa = System.currentTimeMillis();
            return false;
        }
    }

    private boolean algoritmoValido(String algoritmo) {
        return algoritmo.equals("SHA-256") || algoritmo.equals("MD5") || algoritmo.equals("SHA-1");
    }
}
