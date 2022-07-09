package dominio;

import java.util.*;
import java.util.stream.Collectors;

public class Organizador {
    private ArrayList<Tarefa> tarefas;

    public Organizador(){
        tarefas = new ArrayList<>();
    }
    public Organizador(ArrayList<Tarefa> tarefas){
        this.tarefas = new ArrayList<>(tarefas);
        Collections.sort(this.tarefas);
    }

    public void adicionarTarefa(Tarefa t){
        tarefas.add(t);
        Collections.sort(tarefas);
    }

    private ArrayList<Tarefa> obterTodasAsTarefasQue(java.util.function.Predicate<? super Tarefa> predicate){
        return new ArrayList<Tarefa>(
                tarefas
                        .stream()
                        .filter(predicate)
                        .collect(Collectors.toList())
        );
    }

    public ArrayList<Tarefa> obterTodasTarefas(){
        return obterTodasAsTarefasQue(x -> true);
    }
    public ArrayList<Tarefa> obterTarefasPorData(Data data){
        return obterTodasAsTarefasQue(x -> x.getData().compareTo(data) == 0);
    }
    public ArrayList<Tarefa> obterTarefasPorNome(String nome){
        return obterTodasAsTarefasQue(x -> x.getNome().contains(nome));
    }

    // escreve as tarefas no arquivo de texto
    public void salvarTarefas(){
        TarefaRepository tr = new TarefaRepository("banco_de_dados.txt");
        tr.deleteFile();

        for(Tarefa tarefa : tarefas){
            tr.writeObject(tarefa);
        }
    }

    // apaga as tarefas do organizador e recupera os dados do arquivo de texto
    public void recuperarTarefas(){
        tarefas = new ArrayList<Tarefa>();

        TarefaRepository tr = new TarefaRepository("banco_de_dados.txt");
        ArrayList<Salvable> salvs = tr.readFile();

        for (Salvable salv : salvs)
            adicionarTarefa((Tarefa)salv);
    }
}
