package com.unicamp.mc322.lab07;

import java.awt.Point;

public abstract class Frog {

	private String name;
	private String icon;
	private Point current;
	private Point previous;
	private int satisfactionPoints;

//	public Frog() {
//		// TODO Auto-generated constructor stub
//	}

	public abstract void move(String direction);
	
	public abstract void colectFood(Food food);
	
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

	public int getSatisfactionPoints() {
		return satisfactionPoints;
	}

	public void setSatisfactionPoints(int satisfactionPoints) {
		this.satisfactionPoints = satisfactionPoints;
	}
	
}
