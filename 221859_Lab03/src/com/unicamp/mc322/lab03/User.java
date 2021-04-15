package com.unicamp.mc322.lab03;

public class User {
	
	public User(String username, String cpf, String birthdate, String gender, int currentBalance, boolean isSmoker) {
		setUsername(username);
		setCpf(cpf);
		setBirthdate(birthdate);
		setGender(gender);
		setCurrentBalance(currentBalance);
		setSmoker(isSmoker);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}

	public boolean isSmoker() {
		return isSmoker;
	}

	public void setSmoker(boolean isSmoker) {
		this.isSmoker = isSmoker;
	}
	
	public void printUserInfo() {
		System.out.println("User information:");
		System.out.println("Username: " + getUsername());
		System.out.println("CPF: " + getCpf());
		System.out.println("Birthdate: " + getBirthdate());
		System.out.println("Current balance: R$" + getCurrentBalance());
		System.out.print("Smoker: ");
		if (isSmoker())
			System.out.println("yes");
		else
			System.out.println("no");
	}

	private String username;
	private String cpf;
	private String birthdate;
	private String gender;
	private int currentBalance;
	private boolean isSmoker;

}
