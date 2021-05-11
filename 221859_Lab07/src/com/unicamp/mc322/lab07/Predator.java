package com.unicamp.mc322.lab07;

import java.awt.Point;

public class Predator extends Obstacle {

	public Predator(String icon, Point location[]) {
		if (checkRestrictions(location)) {
			setIcon(icon);
			setLocation(location);
		} else {
			System.out.println("Predator creation failed. It must locate in one or two adjacent positions.");
		}
	}
	
	private boolean checkRestrictions(Point location[]) {
		boolean check = true;
		if (location.length > 2 || location.length < 1)
			check = false;
		else if (location.length == 2) {
			if (location[0].getX() - location[1].getX() > 1 || location[0].getX() - location[1].getX() < -1)
				check = false;
			if (location[0].getY() - location[1].getY() > 1 || location[0].getY() - location[1].getY() < -1)
				check = false;
		}
		return check;	
	}

}
