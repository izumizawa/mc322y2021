package com.unicamp.mc322.lab05;

public class MonthlyReminder extends Reminder {

	private int day;

	public MonthlyReminder(String description, int day) {
		super(description);
		this.day = day;
	}

	@Override
	public void printReminder() {
		System.out.println(getDescription() + " - day " + getDay());
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

}
