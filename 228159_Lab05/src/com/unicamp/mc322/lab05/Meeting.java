package com.unicamp.mc322.lab05;

public class Meeting extends Event {

	private String[] participants;
	
	public Meeting(String description, int year, int month, int day, String[] participants) {
		super(description, year, month, day);
		this.participants = participants;
	}

	public String[] getParticipants() {
		return participants;
	}

}
