package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Tarefa {
    private String nome;
    private String descricao;
    private LocalDate dataTermino;
    private int nivelPrioridade;
    private String categoria;
    private String status; //todo, doing, done

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");



    public Tarefa(String nome, String descricao, String dataTermino, int nivelPrioridade, String categoria, String status){
        this.nome = nome;
        this.descricao = descricao;
        this.setDataTermino(dataTermino);
        this.nivelPrioridade = nivelPrioridade;
        this.categoria = categoria;
        this.status = status;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String data) {
        try {
            this.dataTermino = LocalDate.parse(data, FORMATTER);
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida! Utilize o formato DD-MM-YYYY.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public int getNivelPrioridade() {
        return nivelPrioridade;
    }

    public void setNivelPrioridade(int nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String  toString() {
        return "Nome: " + nome + ", Prioridade: " + nivelPrioridade + ", Categoria: " + categoria + ", Status: " + status + ", Data: " + dataTermino.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

}



