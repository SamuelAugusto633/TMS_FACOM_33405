/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.atividade_testes_parametrizados;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class UsuarioTest {

    
    
    
    
    @ParameterizedTest
    @ValueSource(strings = {"SHA-256", "MD5", "SHA-1"})
    void testarAutenticacaoComAlgoritmoValido(String algoritmo) throws Exception {
        Usuario usuario = new Usuario("João Silva", "joao@dominio.com", "joao_silva");
        assertTrue(usuario.autenticar("senhaValida", algoritmo));
    }

    @ParameterizedTest
    @ValueSource(strings = {"SHA-512", "SHA-384", "INVALID"})
    void testarAutenticacaoComAlgoritmoInvalido(String algoritmo) {
        Usuario usuario = new Usuario("João Silva", "joao@dominio.com", "joao_silva");
        assertThrows(Exception.class, () -> usuario.autenticar("senhaValida", algoritmo));
    }

    @Test
    void testarTentativasExcedidas() throws Exception {
        Usuario usuario = new Usuario("João Silva", "joao@dominio.com", "joao_silva");

        assertFalse(usuario.autenticar("senhaErrada", "SHA-256"));
        assertFalse(usuario.autenticar("senhaErrada", "SHA-256"));
        assertFalse(usuario.autenticar("senhaErrada", "SHA-256"));

        assertThrows(ExceededAttemptsException.class, () -> usuario.autenticar("senhaErrada", "SHA-256"));
    }

    @ParameterizedTest
    @EnumSource(Algoritmos.class)
    void testarAlgoritmoUsandoEnum(Algoritmos algoritmo) throws Exception {
        Usuario usuario = new Usuario("João Silva", "joao@dominio.com", "joao_silva");
        assertTrue(usuario.autenticar("senhaValida", algoritmo.getNome()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"SHA-256", "MD5"})
    void testarAutenticacaoComAlgoritmosVarios(String algoritmo) throws Exception {
        Usuario usuario = new Usuario("Joao Silva", "joao@dominio.com", "joao_silva");
        assertTrue(usuario.autenticar("senhaValida", algoritmo));
    }

    @ParameterizedTest
    @CsvSource({
        "SHA-256, senhaValida, true",
        "MD5, senhaValida, true",
        "INVALID, senhaErrada, false"
    })
    void testarAutenticacaoComCsvSource(String algoritmo, String senha, boolean esperado) throws Exception {
        Usuario usuario = new Usuario("João Silva", "joao@dominio.com", "joao_silva");
        assertEquals(esperado, usuario.autenticar(senha, algoritmo));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/autenticacao.csv", numLinesToSkip = 1)
    void testarAutenticacaoComCsvFileSource(String algoritmo, String senha, boolean esperado) throws Exception {
        Usuario usuario = new Usuario("João Silva", "joao@dominio.com", "joao_silva");
        assertEquals(esperado, usuario.autenticar(senha, algoritmo));
    }

    enum Algoritmos {
        SHA_256("SHA-256"),
        MD5("MD5"),
        SHA_1("SHA-1");

        private final String nome;

        Algoritmos(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }
}
