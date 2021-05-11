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
	
	private void populateFreeSpaces() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (board[i][j] == null)
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
//		populateFrog();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (j == width - 1)
					System.out.println(board[i][j] + "\n");
				else 
					System.out.print(board[i][j] + "  ");
			}
		}
	}

}
