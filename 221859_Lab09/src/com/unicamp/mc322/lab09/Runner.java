package com.unicamp.mc322.lab09;

public class Runner {

	public static void main(String[] args) {
		
		Pessoa pessoa1 = new Pessoa("Olivia", 17, "123.123.456-99");
		Pessoa pessoa2 = new Pessoa("Marcos", 26, "765.244.456-99");
		Pessoa pessoa3 = new Pessoa("Lucas", 45, "432.643.341-99");
		Pessoa pessoa4 = new Pessoa("Joana", 61, "321.123.456-99");
		
		FilaDeAtendimentoComposicao fila1 = new FilaDeAtendimentoComposicao();
		fila1.adicionar(pessoa1);
		fila1.adicionar(pessoa2);
		fila1.adicionarPrioritario(pessoa3);
		fila1.adicionarPrioritario(pessoa4);
		System.out.println("Tamanho da fila 1: " + fila1.tamanho());
		fila1.imprimir();
		
		FilaDeAtencimentoHeranca fila2 = new FilaDeAtencimentoHeranca();
		fila2.adicionar(pessoa1);
		fila2.adicionar(pessoa2);
		fila2.adicionarPrioritario(pessoa3);
		fila2.adicionarPrioritario(pessoa4);
		System.out.println("\nTamanho da fila 2: " + fila1.tamanho());
		fila2.imprimir();
	}

}
