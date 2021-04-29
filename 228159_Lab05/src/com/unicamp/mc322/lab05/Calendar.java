package com.unicamp.mc322.lab05;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calendar {
	
	private LocalDateTime dateTime = LocalDateTime.now();
	private int year = dateTime.getYear();
	private int month = dateTime.getMonthValue();
	private int day = dateTime.getDayOfMonth();
	private int weekday = dateTime.getDayOfWeek().getValue();

	private List<Reminder> reminders; 
	private List<MonthlyReminder> monthlyReminders;
	private List<WeeklyReminder> weeklyReminders;
	private List<Event> events;
	

	public Calendar() {
		this.reminders = new ArrayList<Reminder>();
		this.monthlyReminders = new ArrayList<MonthlyReminder>();
		this.weeklyReminders = new ArrayList<WeeklyReminder>();
		this.events = new ArrayList<Event>();
	}
	
	public void printTodayReminders() {
		List<MonthlyReminder> everyMonth = monthlyReminders.stream().filter(today -> today.getDay() == this.day).collect(Collectors.toList());
		List<WeeklyReminder> everyWeek = new ArrayList<WeeklyReminder>();
		List<Event> todayEvent = events.stream()
				.filter(today -> today.getDay() == this.day 
				&& today.getMonth() == this.month 
				&& today.getYear() == this.year)
				.collect(Collectors.toList());
		
		for (WeeklyReminder w : weeklyReminders) {
			for (int day : w.getDaysOfWeek()) 
				if (day == this.weekday)
					everyWeek.add(w);
		}
		System.out.println("--- TODAY REMINDERS ---\n" + this.year + " " + this.month + " " + this.day);
		System.out.println("\n--- Reminders ---");
		for (int i = 0; i < reminders.size(); i++) 
			reminders.get(i).printReminder();
		if (everyMonth.size() != 0) {
			System.out.println("\n--- Monthly Reminders ---");
			for (int i = 0; i < everyMonth.size(); i++) {
				everyMonth.get(i).printReminder();
			}
		}
		if (everyWeek.size() != 0) {
			System.out.println("\n--- Weekly Reminders ---");
			for (int i = 0; i < everyWeek.size(); i++) {
				everyWeek.get(i).printReminder();
			}
		}
		if (todayEvent.size() != 0) {
			System.out.println("\n--- Events ---");
			for (int i = 0; i < events.size(); i++) {
				events.get(i).printReminder();
			}
		}
	}

	public void createReminder(Reminder reminder) {
		reminders.add(reminder);
	}
	
	public void createReminder(String description) {
		Reminder reminder = new Reminder(description);
		reminders.add(reminder);
	}
	
	public void createReminder(String description, int month) {
		MonthlyReminder monthlyReminder = new MonthlyReminder(description, month);
		monthlyReminders.add(monthlyReminder);
	}
	
	public void createReminder(String description, int[] daysOfWeek) {
		WeeklyReminder weeklyReminder = new WeeklyReminder(description, daysOfWeek);
		weeklyReminders.add(weeklyReminder);
	}
	
	public void createReminder(String description, int year, int month, int day) {
		Event event = new Event(description, year, month, day);
		events.add(event);
	}

	public void cancelReminder(String description) {
		reminders.removeIf(reminder -> reminder.getDescription().equals(description));
		monthlyReminders.removeIf(reminder -> reminder.getDescription().equals(description));
		weeklyReminders.removeIf(reminder -> reminder.getDescription().equals(description));
		events.removeIf(reminder -> reminder.getDescription().equals(description));
	}
}
