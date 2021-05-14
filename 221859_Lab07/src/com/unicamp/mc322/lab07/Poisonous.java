package com.unicamp.mc322.lab07;

import java.awt.Point;
import java.util.Random;

public class Poisonous extends Frog {

	public Poisonous(String icon, String name, Point current) {
		super(icon, name, current);
	}

	@Override
	public Point move(String direction) {
		Point moved = getCurrent();
		Point previous = new Point(getCurrent());
		Random generator = new Random();
		int randomPositions = generator.nextInt(3) + 1; // 1 a 4 posicoes
		int randomDirection = generator.nextInt(3); // direcao que a ra quiser
		setPrevious(previous);
		if (randomDirection == 0) {
			moved.setLocation(moved.x-(randomPositions), moved.y);
		} else if (randomDirection == 1) {
			moved.setLocation(moved.x, moved.y-(randomPositions));
		} else if (randomDirection == 2) {
			moved.setLocation(moved.x+(randomPositions), moved.y);
		} else if (randomDirection == 3) {
			moved.setLocation(moved.x, moved.y+(randomPositions));
		}
		setCurrent(moved);
		return getCurrent();
	}

	@Override
	public void collectFood(Food food) {
		setSatisfactionPoints((getSatisfactionPoints() + (1.2*food.getSatisfactionPoints())));
		food.setIcon("  ");
	}

}
