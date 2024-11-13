/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.atividade_injecao_dependencias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.RepetitionInfo;

public class UsuarioTest {

    @Test
    public void testValidarNome(TestInfo testInfo, TestReporter testReporter) {
        Usuario usuario = new Usuario("Joao Silva", "joao@dominio.com", "joao_silva");
        testReporter.publishEntry("Testando validação de nome: " + testInfo.getDisplayName());
        Assertions.assertTrue(usuario.validarNome(), "Nome invalido");
    }

    @Test
    public void testValidarNomeComCaracteresEspeciais(TestInfo testInfo) {
        Usuario usuario = new Usuario("João Silva!", "joao@dominio.com", "joao_silva");
        Assertions.assertFalse(usuario.validarNome(), "Nome não pode conter caracteres especiais");
    }

    @Test
    public void testValidarEmail(TestInfo testInfo) {
        Usuario usuario = new Usuario("João Silva", "joao@dominio.com", "joao_silva");
        Assertions.assertTrue(usuario.validarEmail(), "E-mail inválido");
    }

    @Test
    public void testValidarEmailInvalido(TestInfo testInfo) {
        Usuario usuario = new Usuario("João Silva", "joao@dominio", "joao_silva");
        Assertions.assertFalse(usuario.validarEmail(), "E-mail deve seguir o padrão usuario@dominio");
    }

    @Test
    public void testValidarUsuario(TestInfo testInfo) {
        Usuario usuario = new Usuario("João Silva", "joao@dominio.com", "joao_silva");
        Assertions.assertTrue(usuario.validarUsuario(), "Usuário inválido");
    }

    @Test
    public void testAutenticarComTentativasExcedidas(TestInfo testInfo) {
        Usuario usuario = new Usuario("João Silva", "joao@dominio.com", "joao_silva");
        try {
            usuario.autenticar("senhaerrada");
            usuario.autenticar("senhaerrada");
            usuario.autenticar("senhaerrada");
            usuario.autenticar("senhaerrada");
        } catch (ExceededAttemptsException e) {
            Assertions.assertEquals("Número máximo de tentativas excedido. Tente novamente após 1 minuto.", e.getMessage());
        }
    }
}

