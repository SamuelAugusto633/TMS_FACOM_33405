/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_injecao_dependencias;

/**
 *
 * @author Samuel
 */
import java.util.regex.*;

public class Usuario {
    private String nome;
    private String email;
    private String usuario;
    private int tentativasFalhas;
    private long ultimaTentativa;

    public Usuario(String nome, String email, String usuario) {
        this.nome = nome;
        this.email = email;
        this.usuario = usuario;
        this.tentativasFalhas = 0;
        this.ultimaTentativa = System.currentTimeMillis();
    }

    // Validar nome
    public boolean validarNome() {
        return nome != null && !nome.isEmpty() && nome.matches("[a-zA-Z\\s]+");
    }

    // Validar e-mail
    public boolean validarEmail() {
        return email != null && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    // Validar usuário
    public boolean validarUsuario() {
        return usuario != null && usuario.matches("^[a-zA-Z0-9._]+$");
    }

    // Método para autenticação
    public void autenticar(String senha) throws ExceededAttemptsException {
        if (tentativasFalhas >= 3 && System.currentTimeMillis() - ultimaTentativa < 30000) {
            throw new ExceededAttemptsException("Número máximo de tentativas excedido. Tente novamente após 1 minuto.");
        }
        // Se a autenticação falhar
        tentativasFalhas++;
        ultimaTentativa = System.currentTimeMillis();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getUsuario() {
        return usuario;
    }
}
