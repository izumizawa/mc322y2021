package com.unicamp.mc322.lab07;

import java.awt.Point;
import java.util.List;

public class Map {

	private int height;

	private int width;
	private String[][] board;
	private String freeSpace;
	private List<Obstacle> obstacles;
	private List<Food> rewards;
	private Frog frog;
	
	public Map(int height, int width, String freeSpace, List<Obstacle> obstacles, List<Food> rewards, Frog frog) {
		this.height = height;
		this.width = width;
		this.board = new String[height][width];
		this.freeSpace = freeSpace;
		this.obstacles = obstacles;
		this.rewards = rewards;
		this.frog = frog;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}

	public List<Obstacle> getObstacles() {
		return obstacles;
	}
	
	public List<Food> getRewards() {
		return rewards;
	}
	
	public Frog getFrog() {
		return frog;
	}

	private void populateFreeSpaces() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = freeSpace;
			}
		}
	}
	
	private void populateObstacles() {
		for (int i = 0; i < obstacles.size(); i++) {
			Point[] location = obstacles.get(i).getLocation();
			for (int j = 0; j < location.length; j++) 
				board[location[j].x][location[j].y] = obstacles.get(i).getIcon();
		}
	}
	
	private void populateRewards() {
		for (int i = 0; i < rewards.size(); i++) {
			board[rewards.get(i).getLocation().x][rewards.get(i).getLocation().y] = rewards.get(i).getIcon();
		}
	}
	
	private void populateFrog() {
		board[frog.getCurrent().x][frog.getCurrent().y] = frog.getIcon();
	}
	
	public void showBoard() {
		populateFreeSpaces();
		populateObstacles();
		populateRewards();
		populateFrog();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (j == width - 1)
					System.out.println(board[i][j] + "\n");
				else 
					System.out.print(board[i][j] + "  ");
			}
		}
	}
	
	public void checkFood(Point frogLocation) {
		for (Food food : getRewards())
			if (frogLocation.equals(food.getLocation()))
				if (!food.getIcon().equals("  "))
					getFrog().collectFood(food);
	}
	
	public boolean checkObstacle(Point frogLocation) {
		boolean continueGame = true;
		for (Obstacle obstacle : getObstacles()) 
			for (Point obstacleLocation : obstacle.getLocation()) 
				if (frogLocation.equals(obstacleLocation)) 
					continueGame = false;
		
		if (frogLocation.x < 0 || frogLocation.y < 0 || frogLocation.x >= getWidth() || frogLocation.y >= getHeight())
			continueGame = false;
		
		return continueGame;
	}
	
	// Jogo acaba se a ra estiver em cima do obstaculo ou bater nas extremidades do tabuleiro
	public boolean continueGame() {
		boolean continueGame = true;
		checkFood(getFrog().getCurrent());
		continueGame = checkObstacle(getFrog().getCurrent());

		return continueGame;
	}

}
