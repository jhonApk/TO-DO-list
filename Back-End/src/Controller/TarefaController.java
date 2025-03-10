package Controller;

import Model.Tarefa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TarefaController {
    private List<Tarefa> tarefas = new ArrayList<>();

    public void addTarefa(Tarefa tarefa) {
        int i = 0;
        while (i < tarefas.size() && tarefas.get(i).getNivelPrioridade() >= tarefa.getNivelPrioridade()) {
            i++;
        }
        tarefas.add(i, tarefa);
    }



    public List<Tarefa> listTarefas(){
        return tarefas;
    }

    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public List<Tarefa> filtrarTarefas(String filtro, String valor){
        return tarefas.stream()
                .filter(tarefasFilter ->
                        (filtro.equals("categoria") && tarefasFilter.getCategoria().equalsIgnoreCase(valor)) ||
                        (filtro.equals("prioridade") && String.valueOf(tarefasFilter.getNivelPrioridade()).equals(valor)) ||
                        (filtro.equals("status") && tarefasFilter.getStatus().equalsIgnoreCase(valor)) ||
                        (filtro.equals("data") && tarefasFilter.getDataTermino().equals(LocalDate.parse(valor, FORMATTER))) ||
                        (filtro.equals("todas")))
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
