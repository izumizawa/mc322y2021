package com.unicamp.mc322.lab09;

public class FilaDeAtendimentoComposicao {

	private Fila filaNormal;
	private Fila filaPrioritaria;

	public FilaDeAtendimentoComposicao() {
		this.filaNormal = new Fila();
		this.filaPrioritaria = new Fila();
	}
	public void adicionar(Pessoa pessoa) {
		filaNormal.adicionar(pessoa);
	}
	
	public void adicionarPrioritario(Pessoa pessoa) {
		filaPrioritaria.adicionar(pessoa);
	}
	
	public void remover() {
		if (filaPrioritaria.tamanho() > 0) 
			filaPrioritaria.remover();
		else
			filaNormal.remover();
	}
	
	public int tamanho() {
		return filaNormal.tamanho() + filaPrioritaria.tamanho();
	}
	
	public void imprimir() {
		System.out.println("--------------------\nFila prioritária:");
		filaPrioritaria.imprimir();
		System.out.println("--------------------\nFila normal:");
		filaNormal.imprimir();
	}
	
}
