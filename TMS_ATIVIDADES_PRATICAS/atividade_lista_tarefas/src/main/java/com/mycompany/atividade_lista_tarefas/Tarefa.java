/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_lista_tarefas;

/**
 *
 * @author Samuel
 */
import java.io.Serializable;
import java.time.LocalDate;

public class Tarefa implements Serializable  {
    private String descricao;
    private boolean concluida;
    private LocalDate dataCriacao;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
        this.dataCriacao = LocalDate.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tarefa tarefa = (Tarefa) obj;
        return descricao.equals(tarefa.descricao);
    }

    @Override
    public int hashCode() {
        return descricao.hashCode();
    }
}
