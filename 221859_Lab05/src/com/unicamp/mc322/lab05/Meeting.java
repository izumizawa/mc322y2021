package com.unicamp.mc322.lab05;

public class Meeting extends Event {

	private Contact[] participants;
	private Contact[] confirmed;
	
	public Meeting(String description, int year, int month, int day, Contact[] participants) {
		super(description, year, month, day);
		this.participants = participants;
		this.confirmed = new Contact[participants.length];
	}

	@Override
	public void printReminder() {
		System.out.println(getDescription() + " - " + getMonth() + "/" + getDay() + "/" + getYear() + "\nInvited people:");
		for (Contact contact: participants) 
			System.out.println("- " + contact.getName() + " - " + contact.getEmail());
		if (confirmed[0] != null) {
			System.out.println("Confirmed people:");
			for (Contact contact: confirmed) 
				if (contact != null)
					System.out.println("- " + contact.getName() + " - " + contact.getEmail());
		}	
		System.out.println();
	}
	
	public Contact[] getParticipants() {
		return participants;
	}

	public Contact[] getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Contact confirmed) {
		if (getConfirmed()[0] != null)
			this.confirmed[-1] = confirmed;
		else
			this.confirmed[0] = confirmed;
	}

}
