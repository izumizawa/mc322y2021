package com.unicamp.mc322.lab09;

public class FilaDeAtencimentoHeranca extends Fila {

	private Lista listaPrioritaria;
	
	public FilaDeAtencimentoHeranca() {
		this.listaPrioritaria = new Lista();
	}

	public void adicionarPrioritario(Pessoa pessoa) {
		listaPrioritaria.adicionarFim(pessoa);
	}
	
	@Override
	public void remover() {
		if (listaPrioritaria.tamanho() > 0)
			listaPrioritaria.removerInicio();
		else
			super.remover();
	}
	
	@Override
	public int tamanho() {
		return super.tamanho() + listaPrioritaria.tamanho();
	}
	
	@Override
	public void imprimir() {
		System.out.println("--------------------\nFila prioritária:");
		listaPrioritaria.imprimir();
		System.out.println("--------------------\nFila normal:");
		super.imprimir();
	}
}
