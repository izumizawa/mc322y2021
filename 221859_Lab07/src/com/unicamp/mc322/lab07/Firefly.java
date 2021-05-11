package com.unicamp.mc322.lab07;

import java.awt.Point;

public class Firefly extends Food {

	public Firefly(String icon, int x, int y) {
		setName("Firefly");
		setIcon(icon);
		setLocation(new Point(x, y));
		setSatisfactionPoints(15);
	}

}
