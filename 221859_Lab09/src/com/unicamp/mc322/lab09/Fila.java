package com.unicamp.mc322.lab09;

public class Fila {

	private Lista lista;
	
	public Fila() {
		this.lista = new Lista();
	}
	
	public void adicionar(Pessoa pessoa) {
		lista.adicionarFim(pessoa);
	}
	
	public void remover() {
		lista.removerInicio();
	}
	
	public int tamanho() {
		return lista.tamanho();
	}
	
	public void limpa() {
		lista.limpa();
	}
	
	public void imprimir() {
		lista.imprimir();
	}

}
