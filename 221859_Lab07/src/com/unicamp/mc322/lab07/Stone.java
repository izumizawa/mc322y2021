package com.unicamp.mc322.lab07;

import java.awt.Point;

public class Stone extends Obstacle {

	public Stone(String icon, int x, int y) {
		setIcon(icon);
		Point location[] = new Point[1];
		location[0] = new Point(x, y);
		setLocation(location);
	}

}
