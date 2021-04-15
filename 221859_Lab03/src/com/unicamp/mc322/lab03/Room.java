package com.unicamp.mc322.lab03;

public class Room {
	
	// If room is initialized with boolean, does not accept smokers and does not have ac
	public Room(boolean isVip) {
		setVip(isVip);
		setOccupied(false);
	}
	
	public Room(boolean isVip, boolean isOccupied, boolean acceptSmokers, boolean hasAc) {
		setVip(isVip);
		setOccupied(isOccupied);
		setAcceptSmokers(acceptSmokers);
		setHasAc(hasAc);
	}
	
	public boolean isVip() {
		return isVip;
	}
	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public boolean getAcceptSmokers() {
		return acceptSmokers;
	}

	public void setAcceptSmokers(boolean acceptSmokers) {
		this.acceptSmokers = acceptSmokers;
	}

	public boolean getHasAc() {
		return hasAc;
	}

	public void setHasAc(boolean hasAc) {
		this.hasAc = hasAc;
	}
	
	public void printRoomInfo() {
		if (isVip())
			System.out.println("VIP room");
		else
			System.out.println("Standard room");
		if (isOccupied()) {
			System.out.println("Currently occupied");
			System.out.println(getUser().getUsername() + " booked this room for " + getBookedDays() + " days.");
		}
		else
			System.out.println("Currently available");
		if (getAcceptSmokers())
			System.out.println("Accept smokers");
		else
			System.out.println("Does not accept smokers");
		if (getHasAc())
			System.out.println("Air conditioning included");
		else
			System.out.println("Air conditioning not included");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getBookedDays() {
		return bookedDays;
	}

	public void setBookedDays(int bookedDays) {
		this.bookedDays = bookedDays;
	}

	private boolean isVip;
	private boolean isOccupied;
	private boolean acceptSmokers;
	private boolean hasAc;
	private User user;
	private int bookedDays;

}
