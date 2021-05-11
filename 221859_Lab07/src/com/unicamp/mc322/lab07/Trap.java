package com.unicamp.mc322.lab07;

import java.awt.Point;

public class Trap extends Obstacle {

	public Trap(String icon, Point[] location) {
		if (checkRestrictions(location)) {
			setIcon(icon);
			setLocation(location);
		} else {
			System.out.println("Trap creation failed. It must locate in 1, 2 or 3 positions with maximum distance of 2 between two points.");
		}
	}

	private int manhattanDistance(Point a, Point b) {
		int x, y;
		x = a.x - b.x;
		if (x < 0)
			x = x * (-1);
		y = a.y - b.y;
		if (y < 0)
			y = y * (-1);
		return x + y;
	}
	
	private boolean checkRestrictions(Point[] location) {
		boolean check = true;
		if (location.length > 3 || location.length < 1)
			check = false;
		else if (location.length >= 2) {
			if (manhattanDistance(location[0], location[1]) > 2)
				check = false;
			if (location.length == 3) {
				if (manhattanDistance(location[0], location[2]) > 2)
					check = false;
				if (manhattanDistance(location[1], location[2]) > 2)
				check = false;
			} 
		}
		return check;
	}
}
