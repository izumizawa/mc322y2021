package com.unicamp.mc322.lab05;

public class Reminder {
	private String description;

	public Reminder(String description) {
		this.description = description;
	}
	
	public void printReminder() {
		System.out.println(getDescription());
	}
	
	public String getDescription() {
		return description;
	}
	
}
