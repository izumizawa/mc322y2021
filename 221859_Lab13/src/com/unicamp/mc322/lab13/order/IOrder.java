package com.unicamp.mc322.lab13.order;

public interface IOrder {
	public void addShifts();
	public int getShifts();
	public String getCode();
	public void printPersonSummary();
	public void printPersonInfo();
	public PersonPT getPerson();
}
