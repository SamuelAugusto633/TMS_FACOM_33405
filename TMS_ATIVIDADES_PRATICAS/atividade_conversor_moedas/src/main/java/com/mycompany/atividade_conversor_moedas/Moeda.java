/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_conversor_moedas;

/**
 *
 * @author Samuel
 */
public enum Moeda {
    USD("Dólar Americano"),
    EUR("Euro da União Europeia"),
    BRL("Real Brasileiro"),
    AUD("Dólar Australiano"),
    ARS("Peso Argentino"),
    CLP("Peso Chileno");

    private final String descricao;

    Moeda(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Moeda fromCodigo(String codigo) {
        for (Moeda moeda : values()) {
            if (moeda.name().equalsIgnoreCase(codigo)) {
                return moeda;
            }
        }
        throw new IllegalArgumentException("Código de moeda desconhecido: " + codigo);
    }

    public static Moeda fromDescricao(String descricao) {
        for (Moeda moeda : values()) {
            if (moeda.getDescricao().equalsIgnoreCase(descricao)) {
                return moeda;
            }
        }
        throw new IllegalArgumentException("Moeda desconhecida: " + descricao);
    }
}

