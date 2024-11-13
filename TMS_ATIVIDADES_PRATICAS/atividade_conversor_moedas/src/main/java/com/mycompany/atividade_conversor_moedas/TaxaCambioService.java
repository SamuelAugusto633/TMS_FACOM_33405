/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_conversor_moedas;

/**
 *
 * @author Samuel
 */
public interface TaxaCambioService {
    double obterTaxa(String moedaOrigem, String moedaDestino) throws Exception;
}
