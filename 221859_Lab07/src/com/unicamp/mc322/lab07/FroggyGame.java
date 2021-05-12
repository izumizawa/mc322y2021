package com.unicamp.mc322.lab07;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FroggyGame {

	public static void runGame(Map map) {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		boolean running = true;
		while (running) {
			map.showBoard();
			System.out.print("Enter the command: ");
			String command = keyboard.nextLine();
			if (command.compareTo("quit") == 0) {
				running = false;
			} else {
				map.getFrog().move(command);
				running = map.continueGame();
			}
		}
		System.out.println("Game over!\nCongratulations, " + map.getFrog().getName() + "! You collected " + map.getFrog().getSatisfactionPoints() + " satisfaction points!");
	}
	
	public static void main(String[] args) {
		
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
		
		Firefly firefly = new Firefly("va", 1, 3);
		Cricket cricket = new Cricket("gr", 4, 7);
		
		List<Food> rewards = new ArrayList<>();
		rewards.add(firefly);
		rewards.add(cricket);
		
		// 3 Criar uma ra chamada ’Jogador 1’ começando na posição (8, 7) e com icone “J1”
		Point froggyStart = new Point(8, 7);
		Green froggy = new Green("J1", "Jogador 1", froggyStart);
//		Tomato froggy = new Tomato("J1", "Jogador 1", froggyStart);
		
		
		Map map = new Map(10, 10, "--", obstacles, rewards, froggy);

		runGame(map);
	}

}
