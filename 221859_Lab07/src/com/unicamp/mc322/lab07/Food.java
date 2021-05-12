package com.unicamp.mc322.lab07;

import java.awt.Point;

public abstract class Food {

	private String name;
	private String icon;
	private Point location;
	private float satisfactionPoints;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public float getSatisfactionPoints() {
		return satisfactionPoints;
	}

	public void setSatisfactionPoints(float satisfactionPoints) {
		this.satisfactionPoints = satisfactionPoints;
	}

}
