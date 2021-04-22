package com.unicamp.mc322.lab04;

public class User {

	private String name;
	private String cpf;
	private int[] position;
	private int userTotalOrders;
	
	public User(String name, String cpf, int userX, int userY) {
		this.setName(name);
		this.setCpf(cpf);
		this.position = new int[2];
		position[0] = userX;
		position[1] = userY;
		this.setUserTotalOrders(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public int[] getPosition() {
		return position;
	}

	public int getUserTotalOrders() {
		return userTotalOrders;
	}

	public void setUserTotalOrders(int userTotalOrders) {
		this.userTotalOrders = userTotalOrders;
	}

}
