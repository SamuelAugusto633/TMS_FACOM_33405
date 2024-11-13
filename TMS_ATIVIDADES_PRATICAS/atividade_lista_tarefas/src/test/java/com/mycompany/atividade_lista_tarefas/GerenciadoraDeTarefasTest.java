/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.atividade_lista_tarefas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.List;

public class GerenciadoraDeTarefasTest {

    @Test
    public void testeAdicionarTarefa() {
        GerenciadoraDeTarefas gerenciadora = new GerenciadoraDeTarefas();
        Tarefa tarefa = new Tarefa("Estudar Java");
        gerenciadora.adicionarTarefa(tarefa);
        assertEquals(1, gerenciadora.ordenarTarefasPorData().size());
    }

    @Test
    public void testeAdicionarTarefaDuplicada() {
        GerenciadoraDeTarefas gerenciadora = new GerenciadoraDeTarefas();
        Tarefa tarefa = new Tarefa("Estudar Java");
        gerenciadora.adicionarTarefa(tarefa);
        gerenciadora.adicionarTarefa(tarefa);  // Tarefa duplicada
        assertEquals(1, gerenciadora.ordenarTarefasPorData().size());  // Não deve duplicar
    }

    @Test
    public void testeRemoverTarefa() {
        GerenciadoraDeTarefas gerenciadora = new GerenciadoraDeTarefas();
        Tarefa tarefa = new Tarefa("Estudar Java");
        gerenciadora.adicionarTarefa(tarefa);
        gerenciadora.removerTarefa(tarefa);
        assertEquals(0, gerenciadora.ordenarTarefasPorData().size());
    }

    @Test
    public void testeMarcarTodasComoConcluidas() {
        GerenciadoraDeTarefas gerenciadora = new GerenciadoraDeTarefas();
        Tarefa tarefa1 = new Tarefa("Estudar Java");
        Tarefa tarefa2 = new Tarefa("Estudar JUnit");
        gerenciadora.adicionarTarefa(tarefa1);
        gerenciadora.adicionarTarefa(tarefa2);
        gerenciadora.marcarTodasComoConcluidas();
        assertTrue(tarefa1.isConcluida());
        assertTrue(tarefa2.isConcluida());
    }

    @Test
    public void testeFiltrarTarefasPorStatus() {
        GerenciadoraDeTarefas gerenciadora = new GerenciadoraDeTarefas();
        Tarefa tarefa1 = new Tarefa("Estudar Java");
        Tarefa tarefa2 = new Tarefa("Estudar JUnit");
        tarefa1.marcarComoConcluida();
        gerenciadora.adicionarTarefa(tarefa1);
        gerenciadora.adicionarTarefa(tarefa2);
        
        List<Tarefa> tarefasConcluidas = gerenciadora.filtrarTarefasPorStatus(true);
        assertEquals(1, tarefasConcluidas.size());
    }

    @Test
    public void testeOrdenarTarefasPorData() {
        GerenciadoraDeTarefas gerenciadora = new GerenciadoraDeTarefas();
        Tarefa tarefa1 = new Tarefa("Estudar Java");
        Tarefa tarefa2 = new Tarefa("Estudar JUnit");
        gerenciadora.adicionarTarefa(tarefa2);
        gerenciadora.adicionarTarefa(tarefa1);

        List<Tarefa> tarefasOrdenadas = gerenciadora.ordenarTarefasPorData();
        assertEquals(tarefa1, tarefasOrdenadas.get(0));  // Tarefa mais antiga
    }

    @Test
    public void testeSalvarECarregarTarefas() throws IOException, ClassNotFoundException {
        GerenciadoraDeTarefas gerenciadora = new GerenciadoraDeTarefas();
        Tarefa tarefa = new Tarefa("Estudar Java");
        gerenciadora.adicionarTarefa(tarefa);
        
        // Salvar tarefas
        gerenciadora.salvarTarefasEmArquivo("tarefas.dat");

        // Carregar tarefas
        GerenciadoraDeTarefas gerenciadoraCarregada = new GerenciadoraDeTarefas();
        gerenciadoraCarregada.carregarTarefasDeArquivo("tarefas.dat");
        
        assertEquals(1, gerenciadoraCarregada.ordenarTarefasPorData().size());
    }
}
