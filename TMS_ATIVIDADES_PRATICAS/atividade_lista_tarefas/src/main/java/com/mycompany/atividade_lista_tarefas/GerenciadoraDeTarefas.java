/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_lista_tarefas;

/**
 *
 * @author Samuel
 */
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class GerenciadoraDeTarefas {
    private List<Tarefa> tarefas;

    public GerenciadoraDeTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        if (!tarefas.contains(tarefa)) {
            tarefas.add(tarefa);
        }
    }

    public void removerTarefa(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }

    public void marcarTodasComoConcluidas() {
        for (Tarefa tarefa : tarefas) {
            tarefa.marcarComoConcluida();
        }
    }

    public List<Tarefa> filtrarTarefasPorStatus(boolean concluida) {
        return tarefas.stream()
                .filter(t -> t.isConcluida() == concluida)
                .collect(Collectors.toList());
    }

    public List<Tarefa> ordenarTarefasPorData() {
    return tarefas.stream()
                  .sorted(Comparator.comparing(Tarefa::getDataCriacao))
                  .collect(Collectors.toList());
}


    public void salvarTarefasEmArquivo(String caminho) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(tarefas);
        }
    }

    public void carregarTarefasDeArquivo(String caminho) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            tarefas = (List<Tarefa>) ois.readObject();
        }
    }
}

