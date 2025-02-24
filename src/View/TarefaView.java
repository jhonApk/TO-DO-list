package View;

import Controller.TarefaController;
import Model.Tarefa;

import java.util.List;
import java.util.Scanner;

public class TarefaView {
    private TarefaController controller;
    private Scanner scanner;


    public TarefaView() {
        controller = new TarefaController();
        scanner = new Scanner(System.in);
    }

    public void exibirMenu(){
        int opcao;

        do{
            System.out.println("===== Menu =====");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Listar por Categoria");
            System.out.println("4. Listar por Prioridade");
            System.out.println("5. Listar por Status");
            System.out.println("6. Atualizar Status de uma Tarefa");
            System.out.println("7. Remover Tarefa");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> addTarefa();
                case 2 -> listarTarefas();
                case 3 -> filtrarTarefas("categoria");
                case 4 -> filtrarTarefas("prioridade");
                case 5 -> filtrarTarefas("status");
                case 6 -> atualizarStatus();
                case 7 -> removerTarefa();
                case 8 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

        }while (opcao != 8);
    }

    private void addTarefa(){
        System.out.print("Nome da tarefa: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Data de término (YYYY-MM-DD): ");
        String dataTermino = scanner.nextLine();
        System.out.print("Nível de prioridade (1-5): ");
        int prioridade = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Status (todo, doing, done): ");
        String status = scanner.nextLine();

        controller.addTarefa(new Tarefa(nome, descricao, dataTermino, prioridade, categoria, status));
        System.out.println("Tarefa adicionada com sucesso!\n");
    }

    private void listarTarefas(){
        List<Tarefa> tarefas = controller.listTarefas();
        tarefas.forEach(System.out::println);
    }

    private void filtrarTarefas(String filtro){
        System.out.print("Digite o valor para o filtro (" + filtro + "): ");
        String valor = scanner.nextLine();
        List<Tarefa> tarefas = controller.filtrarTarefas(filtro.toString(), valor);
        tarefas.forEach(System.out::println);
    }

    private void atualizarStatus(){
        System.out.print("Digite o nome da tarefa a ser atualizada: ");
        String nome = scanner.nextLine();
        System.out.print("Novo status (todo, doing, done): ");
        String status = scanner.nextLine();
        if (controller.atualizarStatus(nome, status)) {
            System.out.println("Tarefa atualizada com sucesso!\n");
        } else {
            System.out.println("Tarefa não encontrada!\n");
        }
    }

    private void removerTarefa(){
        System.out.print("Digite o nome da tarefa a ser removida: ");
        String nome = scanner.nextLine();
        if (controller.removerTarefa(nome)) {
            System.out.println("Tarefa removida com sucesso!\n");
        } else {
            System.out.println("Tarefa não encontrada!\n");
        }
    }
}