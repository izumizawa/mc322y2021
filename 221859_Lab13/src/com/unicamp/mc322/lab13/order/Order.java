package com.unicamp.mc322.lab13.order;

public abstract class Order implements IOrder {

	private PersonPT customer;
	private int shifts;
	private String code;
	private int score;
	
	public Order(PersonPT customer) {
		this.customer = customer;
		shifts = 0;
		score = 0;
	}

	@Override
	public void addShifts() {
		this.shifts += 1;
	}

	@Override
	public int getShifts() {
		return this.shifts;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public void printPersonSummary() {
		System.out.println("Customer of order (" + this.code + "): " + this.customer.getName());
	}

	@Override
	public void printPersonInfo() {
		System.out.println("Customer of order (" + this.code + "):" + 
							"\nName: " + this.customer.getName() +
							"\nCPF: " + this.customer.getCpf() +
							"\nAge: " + this.customer.getAge());
	}

	@Override
	public PersonPT getPerson() {
		return this.customer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
