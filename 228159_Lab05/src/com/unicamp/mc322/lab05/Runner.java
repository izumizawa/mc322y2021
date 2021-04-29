package com.unicamp.mc322.lab05;

import java.time.LocalDateTime;

public class Runner {

	static final int WEEK_LENGTH = 7;
	
	public static void main(String[] args) {
		
		Calendar calendar = new Calendar();
		calendar.createReminder("Drink water");
		calendar.createReminder("Pay spotify bill", 28);
		calendar.createReminder("Pay netflix bill", 28);
		
		int[] greysPremiere = {1, 3};
		calendar.createReminder("Watch Grey's Anatomy", greysPremiere);
		int[] bathroomCleansing = {3, 7, 2};
		calendar.createReminder("Clean bathroom", bathroomCleansing);
		calendar.createReminder("Dentist appointment", 2021, 4, 28);

		calendar.cancelReminder("Watch Grey's Anatomy");
		
		String[] participants = {"Hellen", "Marshall", "Paul"};
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		calendar.printTodayReminders();

	}

}
