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
	private List<Meeting> meetings;
	

	public Calendar() {
		this.reminders = new ArrayList<Reminder>();
		this.monthlyReminders = new ArrayList<MonthlyReminder>();
		this.weeklyReminders = new ArrayList<WeeklyReminder>();
		this.events = new ArrayList<Event>();
		this.meetings = new ArrayList<Meeting>();
	}
	
	private List<MonthlyReminder> findMonthlyRemindersByDay(int day) {
		List<MonthlyReminder> everyMonth = monthlyReminders.stream()
				.filter(today -> today.getDay() == day)
				.collect(Collectors.toList());
		return everyMonth;
	}
	
	private List<WeeklyReminder> findWeeklyRemindersByWeekday(int weekday) {
		List<WeeklyReminder> everyWeek = new ArrayList<WeeklyReminder>();
		for (WeeklyReminder w : weeklyReminders) {
			for (int day : w.getDaysOfWeek()) 
				if (day == weekday)
					everyWeek.add(w);
		}
		return everyWeek;
	}
	
	private List<Event> findEventsByDate(int day, int month, int year) {
		List<Event> todayEvents = events.stream()
				.filter(today -> today.getDay() == this.day 
				&& today.getMonth() == this.month 
				&& today.getYear() == this.year)
				.collect(Collectors.toList());
		return todayEvents;
	}
	
	private List<Meeting> findMeetingByDate(int day, int month, int year) {
		List<Meeting> todayMeetings = meetings.stream()
				.filter(today -> (today.getDay() == this.day 
				&& today.getMonth() == this.month 
				&& today.getYear() == this.year))
				.collect(Collectors.toList());
		return todayMeetings;
	}
	
	public void printTodayReminders() {
		List<MonthlyReminder> everyMonth = findMonthlyRemindersByDay(this.day);
		List<WeeklyReminder> everyWeek = findWeeklyRemindersByWeekday(this.day);
		List<Event> todayEvent = findEventsByDate(this.day, this.month, this.year);
		List<Meeting> todayMeeting = findMeetingByDate(this.day, this.month, this.year);

		System.out.println("--- TODAY REMINDERS ---\nDate: " + this.month + "/" + this.day + "/" + this.year );
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
		if (todayMeeting.size() != 0) {
			System.out.println("\n--- Meetings ---");
			for (int i = 0; i < meetings.size(); i++) {
				meetings.get(i).printReminder();
			}
		}
	}

	public void createReminder(Reminder reminder) {
		if (reminder instanceof Meeting)
			meetings.add((Meeting) reminder);
		else if (reminder instanceof Event)
			events.add((Event) reminder);
		else if (reminder instanceof WeeklyReminder)
			weeklyReminders.add((WeeklyReminder) reminder);
		else if (reminder instanceof MonthlyReminder)
			monthlyReminders.add((MonthlyReminder) reminder);
		else
			reminders.add(reminder);
	}

	public void cancelReminder(String description) {
		reminders.removeIf(reminder -> reminder.getDescription().equals(description));
		monthlyReminders.removeIf(reminder -> reminder.getDescription().equals(description));
		weeklyReminders.removeIf(reminder -> reminder.getDescription().equals(description));
		events.removeIf(reminder -> reminder.getDescription().equals(description));
	}
	
	public void confirmParticipant(Contact participant, Meeting meeting) {
		meeting.setConfirmed(participant);
		System.out.println("* The following contact has been confirmed in " + meeting.getDescription() + " ");
		participant.printContact();
	}
	
	
	public void printRemindersByDay(int month, int day, int year) {
		List<MonthlyReminder> everyMonth = findMonthlyRemindersByDay(day);
		List<WeeklyReminder> everyWeek = findWeeklyRemindersByWeekday(day);
		List<Event> todayEvent = findEventsByDate(day, month, year);
		List<Meeting> todayMeeting = findMeetingByDate(day, month, year);

		System.out.println("Reminders for date: " + month + "/" + day + "/" + year );
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
		if (todayMeeting.size() != 0) {
			System.out.println("\n--- Meetings ---");
			for (int i = 0; i < meetings.size(); i++) {
				meetings.get(i).printReminder();
			}
		}
	}
}
