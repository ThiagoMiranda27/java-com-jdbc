package com.curso.java2.model;

public class Setor {
    private Long idSetor;
    private String nome;

    public Setor() {
    }

    public Setor(Long idSetor, String nome) {
        this.idSetor = idSetor;
        this.nome = nome;
    }

    public Long getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Long idSetor) {
        this.idSetor = idSetor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
