package com.unicamp.mc322.lab09;

import java.util.ArrayList;
import java.util.List;

public class Lista {
	
	private List<Pessoa> lista;

	public Lista() {
		this.lista = new ArrayList<Pessoa>();
	}
	
	public void adicionarInicio(Pessoa pessoa) {
		lista.add(0, pessoa);
	}
	
	public void adicionarFim(Pessoa pessoa) {
		lista.add(pessoa);
	}
	
	public void adicionar(Pessoa pessoa, int posicao) {
		lista.add(posicao, pessoa);
	}
	
	public void removerInicio() {
		lista.remove(0);
	}
	
	public void removerFim() {
		lista.remove(-1);
	}
	
	public void remover(int posicao) {
		lista.remove(posicao);
	}
	
	public int tamanho() {
		return lista.size();
	}
	
	public void limpa() {
		lista.clear();
	}
	
	public void imprimir() {
		for (Pessoa p : lista) {
			System.out.println("--------------------"
					+ "\nNome: " + p.getNome() + "\nIdade: " + p.getIdade() + "\nCPF: " + p.getCpf());
		}
	}
}
