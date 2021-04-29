package com.unicamp.mc322.lab05;

import java.time.LocalDateTime;

public class Runner {

	static final int WEEK_LENGTH = 7;
	static final int YEAR = 2021;
	static LocalDateTime dateTime = LocalDateTime.now();

	public static void main(String[] args) {
		
		Calendar calendar = new Calendar();
		Reminder reminder1 = new Reminder("Drink water");
		calendar.createReminder(reminder1);
		
		MonthlyReminder monthlyReminder1 = new MonthlyReminder("Pay spotify bill", dateTime.getDayOfMonth());
		MonthlyReminder monthlyReminder2 = new MonthlyReminder("Pay netflix bill", dateTime.getDayOfMonth());
		calendar.createReminder(monthlyReminder1);
		calendar.createReminder(monthlyReminder2);


		int[] greysPremiere = {1, 3};
		WeeklyReminder weeklyReminder1 = new WeeklyReminder("Watch Grey's Anatomy", greysPremiere);
		calendar.createReminder(weeklyReminder1);
		int[] bathroomCleansing = {3, 7, 2};
		WeeklyReminder weeklyReminder2 = new WeeklyReminder("Clean bathroom", bathroomCleansing);		
		calendar.createReminder(weeklyReminder2);

		Event event1 = new Event("Dentist appointment", YEAR, dateTime.getMonthValue(), dateTime.getDayOfMonth());
		calendar.createReminder(event1);

		calendar.cancelReminder("Watch Grey's Anatomy");
		
		Contact contact1 = new Contact("Hellen", "hellen@email.com", "11987654321");
		Contact contact2 = new Contact("Paul", "paul@email.com", "11987654321");
		Contact contact3 = new Contact("Marshall", "marshall@email.com", "11987654321");
		Contact[] participants = {contact1, contact2, contact3};
		Meeting meeting1 = new Meeting("Daily KanBan meeting", YEAR, dateTime.getMonthValue(), dateTime.getDayOfMonth(), participants);
		calendar.createReminder(meeting1);
		
		
		Meeting meeting2 = new Meeting("Retro meeting", YEAR, dateTime.getMonthValue(), 30, participants);
		calendar.createReminder(meeting2);

		calendar.printTodayReminders();

		calendar.confirmParticipant(contact3, meeting1);
		
		calendar.printRemindersByDay(dateTime.getMonthValue(), 30, YEAR);
	}

}
