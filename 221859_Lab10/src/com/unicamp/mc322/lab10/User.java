package com.unicamp.mc322.lab10;

import java.awt.Point;

public class User {

	private String name;
	private String cpf;
	private Point address;
	private int totalOrders;
	
	public User(String name, String cpf, Point address) {
		this.name = name;
		this.cpf = cpf;
		this.address = address;
		this.totalOrders = 0;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public Point getAddress() {
		return address;
	}

	public int getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}
	
}
