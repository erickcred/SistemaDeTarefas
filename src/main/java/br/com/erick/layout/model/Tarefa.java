package br.com.erick.layout.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Tarefa {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Tarefa() {}
    public Tarefa(int id, String nome, Date data, String descricao) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.descricao = descricao;
    }
    
    private int id;
    private String nome;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date data;
    private String descricao;

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return this.data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
