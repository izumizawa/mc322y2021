package com.unicamp.mc322.lab07;

import java.awt.Point;

public class Green extends Frog {

	public Green(String icon, String name, Point current) {
		super(icon, name, current);
	}

	@Override
	public Point move(String direction) {
		Point moved = getCurrent();
		if (direction.compareTo("w") == 0) {
			setPrevious(getCurrent());
			moved.setLocation(moved.x-1, moved.y);
		} else if (direction.compareTo("a") == 0) {
			setPrevious(getCurrent());
			moved.setLocation(moved.x, moved.y-1);
		} else if (direction.compareTo("s") == 0) {
			setPrevious(getCurrent());
			moved.setLocation(moved.x+1, moved.y);
		} else if (direction.compareTo("d") == 0) {
			setPrevious(getCurrent());
			moved.setLocation(moved.x, moved.y+1);
		} else {
			System.out.println("Tip: you should move using 'W', 'A', 'S' or 'D'.");
		}
		setCurrent(moved);
		return getCurrent();
	}

	@Override
	public void collectFood(Food food) {
		setSatisfactionPoints(getSatisfactionPoints() + food.getSatisfactionPoints());
		food.setIcon("  ");
	}

}
