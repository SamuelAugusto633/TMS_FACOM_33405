/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.atividade_validador_senhas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

public class ValidadorSenhaTest {
    private ValidadorSenha validadorSenha;

    @BeforeEach
    public void setUp() {
        validadorSenha = new ValidadorSenha();
    }

    @Test
    public void testSenhaValida() {
        String senha = "Senha@123";
        Assertions.assertTrue(validadorSenha.validarSenha(senha));
    }

    @Test
    public void testSenhaMenorQue8Caracteres() {
        String senha = "Ab@1";
        Assertions.assertFalse(validadorSenha.validarSenha(senha));
    }

    @Test
    public void testSenhaSemLetraMaiuscula() {
        String senha = "senha@123";
        Assertions.assertFalse(validadorSenha.validarSenha(senha));
    }

    @Test
    public void testSenhaSemLetraMinuscula() {
        String senha = "SENHA@123";
        Assertions.assertFalse(validadorSenha.validarSenha(senha));
    }

    @Test
    public void testSenhaSemNumero() {
        String senha = "Senha@Senha";
        Assertions.assertFalse(validadorSenha.validarSenha(senha));
    }

    @Test
    public void testSenhaSemCaractereEspecial() {
        String senha = "Senha123";
        Assertions.assertFalse(validadorSenha.validarSenha(senha));
    }

    @Test
    public void testSenhaComEspacos() {
        String senha = "Senha 123";
        Assertions.assertFalse(validadorSenha.validarSenha(senha));
    }
}
