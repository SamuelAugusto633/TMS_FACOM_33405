/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_conversor_moedas;

/**
 *
 * @author Samuel
 */
public class ConversorMoedas {
    private TaxaCambioService taxaCambioService;

    public ConversorMoedas(TaxaCambioService taxaCambioService) {
        this.taxaCambioService = taxaCambioService;
    }

    public double converter(String moedaOrigem, String moedaDestino, double valor) throws Exception {
        // Converte nomes das moedas para seus códigos padrão, se necessário
        Moeda origem = identificarMoeda(moedaOrigem);
        Moeda destino = identificarMoeda(moedaDestino);

        double taxa = taxaCambioService.obterTaxa(origem.name(), destino.name());
        return valor * taxa;
    }

    private Moeda identificarMoeda(String moeda) {
        try {
            return Moeda.fromCodigo(moeda);
        } catch (IllegalArgumentException e) {
            return Moeda.fromDescricao(moeda);
        }
    }
}

