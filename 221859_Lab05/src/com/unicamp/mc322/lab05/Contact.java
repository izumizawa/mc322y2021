package com.unicamp.mc322.lab05;

public class Contact {

	private String name;
	private String email;
	private String telephone;
	
	public Contact(String name, String email, String telephone) {
		this.name = name;
		this.email = email;
		this.telephone = telephone;
	}

	public void printContact() {
		System.out.println("Name: " + this.name + "\nE-mail: " + this.email + "\nTelephone: " + this.telephone);
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
}
