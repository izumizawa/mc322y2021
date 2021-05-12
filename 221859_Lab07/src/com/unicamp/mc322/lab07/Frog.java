package com.unicamp.mc322.lab07;

import java.awt.Point;

public abstract class Frog {

	private String name;
	private String icon;
	private Point current;
	private Point previous;
	private double satisfactionPoints;

	public Frog(String icon, String name, Point current) {
		setIcon(icon);
		setName(name);
		setCurrent(current);
		setSatisfactionPoints(0);
	}

	public abstract Point move(String direction);
	
	public abstract void collectFood(Food food);
	
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

	public Point getCurrent() {
		return current;
	}

	public void setCurrent(Point current) {
		this.current = current;
	}

	public Point getPrevious() {
		return previous;
	}

	public void setPrevious(Point previous) {
		this.previous = previous;
	}

	public double getSatisfactionPoints() {
		return satisfactionPoints;
	}

	public void setSatisfactionPoints(double satisfactionPoints) {
		this.satisfactionPoints = satisfactionPoints;
	}
	
}
