package com.unicamp.mc322.lab09;

public class Pessoa {

	private String nome;
	private String cpf;
	private int idade;
	
	public Pessoa(String nome, int idade, String cpf) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public int getIdade() {
		return idade;
	}

}
