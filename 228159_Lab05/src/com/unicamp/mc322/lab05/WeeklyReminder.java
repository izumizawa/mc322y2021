package com.unicamp.mc322.lab05;

import java.util.Arrays;

public class WeeklyReminder extends Reminder {

	private int[] daysOfWeek;
	
	public WeeklyReminder(String description, int[] daysOfWeek) {
		super(description);
		this.daysOfWeek = daysOfWeek;
	}
	
	@Override
	public void printReminder() {
		System.out.print(getDescription() + " - every ");
		Arrays.sort(daysOfWeek);
		for (int day : daysOfWeek) {
			if (daysOfWeek.length > 0 && day != daysOfWeek[0])
				System.out.print("& ");
			if (day == 1)
				System.out.print("Monday ");
			else if (day == 2)
				System.out.print("Tuesday ");
			else if (day == 3)
				System.out.print("Wednesday ");
			else if (day == 4)
				System.out.print("Thursday ");
			else if (day == 5)
				System.out.print("Friday ");
			else if (day == 6)
				System.out.print("Saturday ");
			else if (day == 7)
				System.out.print("Sunday ");
		}
		System.out.println();
	}

	public int[] getDaysOfWeek() {
		return daysOfWeek;
	}

}
