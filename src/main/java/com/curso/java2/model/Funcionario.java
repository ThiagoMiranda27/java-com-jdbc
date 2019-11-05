package com.curso.java2.model;

import java.time.LocalDate;

public class Funcionario {
	
	private Long idFuncionario;
	private String nome;
	private LocalDate dataNascimento;
	private Long setorId;
	
	
	public Funcionario(Long idFuncionario, String nome, LocalDate dataNascimento, Long setorId) {
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.setorId = setorId;
	}


	public Long getIdFuncionario() {
		return idFuncionario;
	}


	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Long getSetorId() {
		return setorId;
	}


	public void setSetorId(Long setorId) {
		this.setorId = setorId;
	}
	
}
