package com.unicamp.mc322.lab01;

import java.util.Scanner;

public class Calculator {
	
	public static void main (String[] args) {
		System.out.print("Calculadora de inteiros aberta. ");
		instructions();
		Scanner input = new Scanner(System.in);
		int inputInstruction = input.nextInt();
		while (inputInstruction > 0 && inputInstruction < 7) {
			if(inputInstruction == 1)
				sum();
			if(inputInstruction == 2)
				subtract();
			if(inputInstruction == 3)
				multiply();
			if(inputInstruction == 4)
				divide();
			if(inputInstruction == 5)
				fatorial();
			if(inputInstruction == 6)
				prime();
			instructions();
			inputInstruction = input.nextInt();
		}
		input.close();
	}
	
	private static void instructions() {
		System.out.println("Escolha uma das opções abaixo:");
		System.out.println("1) Digite 1 para somar");
		System.out.println("2) Digite 2 para subtrair");
		System.out.println("3) Digite 3 para multiplicar");
		System.out.println("4) Digite 4 para dividir");
		System.out.println("5) Digite 5 para calcular fatorial");
		System.out.println("6) Digite 6 para verificar se um número é primo");
		System.out.println("7) Qualquer outro valor para sair do programa");
	}
	
	private static void sum() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o primeiro valor: ");
		int a = input.nextInt();
		System.out.println("Digite o segundo valor: ");
		int b = input.nextInt();
		int inputSum = a + b;
		System.out.println(a + " + " + b + " = " + inputSum);	
		input.close();
	}
	
	private static void subtract() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o primeiro valor: ");
		int a = input.nextInt();
		System.out.println("Digite o segundo valor: ");
		int b = input.nextInt();
		int inputSubtract = a - b;
		System.out.println(a + " - " + b + " = " + inputSubtract);		
		input.close();
	}
	
	private static void multiply() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a primeira parcela: ");
		int a = input.nextInt();
		System.out.println("Digite a segunda parcela: ");
		int b = input.nextInt();
		int inputMultiply = a * b;
		System.out.println(a + " * " + b + " = " + inputMultiply);	
		input.close();
	}
	
	private static void divide() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o dividendo: ");
		int a = input.nextInt();
		System.out.println("Digite o divisor: ");
		int b = input.nextInt();
		int inputDivide = a / b;
		System.out.println(a + " / " + b + " = " + inputDivide);	
		input.close();
	}
	
	private static int fat(int i) {
		if (i == 0 || i == 1) 
			return 1;
		else 
			return i * fat(i - 1);
	}
	
	private static void fatorial() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o valor: ");
		int a = input.nextInt();
		int inputFat = fat(a);
		System.out.println("Fatorial de " + a + " = " + inputFat);
		input.close();
	}
	
	private static boolean primeNumber(int n) {
		if (n < 2)
			return false;
		if (n % 2 == 0 || n % 3 == 0) 
			return false;
		for (int j = 5; j <= n/2; j ++)
			if (n%j == 0)
				return false;
		return true;
	}
	
	private static void prime() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o valor: ");
		int a = input.nextInt();
		boolean inputPrime = primeNumber(a);
		if (inputPrime)
			System.out.println(a + " é primo.");
		else
			System.out.println(a + " não é primo.");
		input.close();
	}
}
