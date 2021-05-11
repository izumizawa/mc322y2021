package com.unicamp.mc322.lab07;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FroggyGame {

	public static void runGame() {
		Scanner keyboard = new Scanner(System.in);
		boolean running = true;
		while (running) {
		System.out.print("Enter the command: ");
		String command = keyboard.nextLine();
		if (command.compareTo("quit") == 0) {
		running = false;
		} else if (command.compareTo("w") == 0) {
		// ...
		} else if (command.compareTo("a") == 0) {
		// ...
		} else if (command.compareTo("s") == 0) {
		// ...
		} else if (command.compareTo("d") == 0) {
		// ...
		}
		}
	}
	
	public static void main(String[] args) {
		
		// 1 Criar obstaculos
		Stone stone1 = new Stone("<>", 2, 7);
		Stone stone2 = new Stone("<>", 3, 2);
		Stone stone3 = new Stone("<>", 7, 1);
		Stone stone4 = new Stone("<>", 8, 4);
		Stone stone5 = new Stone("<>", 8, 8);
		
		Point[] predatorLocation = new Point[2];
		predatorLocation[0] = new Point(4, 4);
		predatorLocation[1] = new Point(5, 5);
		Predator predator = new Predator("$$", predatorLocation);
		
		Point[] trapLocation = new Point[2];
		trapLocation[0] = new Point(0, 0);
		trapLocation[1] = new Point(0, 1);
		Trap trap = new Trap("{}", trapLocation);
		
		List<Obstacle> obstacles = new ArrayList<>();
		obstacles.add(stone1);
		obstacles.add(stone2);
		obstacles.add(stone3);
		obstacles.add(stone4);
		obstacles.add(stone5);
		obstacles.add(predator);
		obstacles.add(trap);
		
		// 2 Criar comidas
		Firefly firefly = new Firefly("va", 1, 3);
		Cricket cricket = new Cricket("gr", 4, 7);
		
		List<Food> rewards = new ArrayList<>();
		rewards.add(firefly);
		rewards.add(cricket);
		
		// 3 Criar uma ra chamada ’Jogador 1’ começando na posição (8, 7) e com icone “J1”

		// 4 Criar um Mapa com largura 10 e altura 10 e com icone “--” para as posicoes livres

		Map map = new Map(10, 10, "--", obstacles, rewards, null);
		map.showBoard();
//		runGame();
	}

}
