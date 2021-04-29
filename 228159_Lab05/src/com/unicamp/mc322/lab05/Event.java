package com.unicamp.mc322.lab05;

public class Event extends Reminder {

	private int year;
	private int month;
	private int day;
	
	public Event(String description, int year, int month, int day) {
		super(description);
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	@Override
	public void printReminder() {
		System.out.println(getDescription() + " - " + getMonth() + "/" + getDay() + "/" + getYear());
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
}
