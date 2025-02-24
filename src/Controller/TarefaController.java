package Controller;

import Model.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TarefaController {
    private List<Tarefa> tarefas = new ArrayList<>();

    public void addTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public List<Tarefa> listTarefas(){
        return tarefas;
    }

    public List<Tarefa> filtrarTarefas(String filtro, String valor){
        return tarefas.stream()
                .filter(tarefasFilter -> (filtro.equals("categoria") && tarefasFilter.getCategoria().equalsIgnoreCase(valor)) ||
                        (filtro.equals("prioridade") && String.valueOf(tarefasFilter.getNivelPrioridade()).equals(valor)) ||
                        (filtro.equals("status") && tarefasFilter.getStatus().equalsIgnoreCase(valor)))
                .collect(Collectors.toList());
    }

    public boolean atualizarStatus(String nome, String novoStatus){
        for (Tarefa atuaTarefa: tarefas ){
            if (atuaTarefa.getNome().equalsIgnoreCase(nome)){
                atuaTarefa.setStatus(novoStatus);
                return true;
            }
        }
        return false;
    }

    public boolean removerTarefa(String nome){
        return tarefas.removeIf(rmTarefa -> rmTarefa.getNome().equalsIgnoreCase(nome));
    }
}
