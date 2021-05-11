package com.unicamp.mc322.lab07;

import java.awt.Point;

public class Cricket extends Food {

	public Cricket(String icon, int x, int y) {
		setName("Cricket");
		setIcon(icon);
		setLocation(new Point(x, y));
		setSatisfactionPoints(20);
	}

}
