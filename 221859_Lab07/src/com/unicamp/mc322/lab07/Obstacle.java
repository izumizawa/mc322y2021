package com.unicamp.mc322.lab07;

import java.awt.Point;

public abstract class Obstacle {

	private String icon;
	private Point location[];
//	
//	public Obstacle() {
//		// TODO Auto-generated constructor stub
//	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Point[] getLocation() {
		return location;
	}

	public void setLocation(Point location[]) {
		this.location = location;
	}

}
