package com.unicamp.mc322.lab07;

import java.awt.Point;
import java.util.Random;

public class Tomato extends Frog {

	public Tomato(String icon, String name, Point current) {
		super(icon, name, current);
	}

	@Override
	public Point move(String direction) {
		Point moved = getCurrent();
		Point previous = new Point(getCurrent());
		Random generator = new Random();
		int randomPositions = 0;
		if (direction.compareTo("w") == 0) {
			setPrevious(previous);
			while (randomPositions != 2 && randomPositions != 3)
				randomPositions = generator.nextInt(3)+1;
			moved.setLocation(moved.x-(randomPositions), moved.y);
		} else if (direction.compareTo("a") == 0) {
			setPrevious(previous);
			moved.setLocation(moved.x, moved.y-(generator.nextInt(3)+1));
		} else if (direction.compareTo("s") == 0) {
			setPrevious(previous);
			moved.setLocation(moved.x+(generator.nextInt(3)+1), moved.y);
		} else if (direction.compareTo("d") == 0) {
			setPrevious(previous);
			while (randomPositions != 1 && randomPositions != 2 && randomPositions != 4)
				randomPositions = generator.nextInt(4)+1;
			moved.setLocation(moved.x, moved.y+(randomPositions));
		} else {
			System.out.println("Tip: you should move using 'W', 'A', 'S' or 'D'.");
		}
		setCurrent(moved);
		return getCurrent();
	}

	@Override
	public void collectFood(Food food) {
		setSatisfactionPoints((getSatisfactionPoints() + (1.1*food.getSatisfactionPoints())));
		food.setIcon("  ");
	}

}
