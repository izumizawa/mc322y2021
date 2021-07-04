package com.unicamp.mc322.lab13.order;

import java.time.LocalDate;
import java.time.Period;

public class PersonPT {

	private LocalDate birthdate;
	private int age;
	private String cpf;
	private String name;

	public PersonPT(LocalDate birthdate, String cpf, String name) {
		this.birthdate = birthdate;
		this.cpf = cpf;
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public int getAge() {
		age = Period.between(this.birthdate, LocalDate.now()).getYears();
		return age;
	}

	public String getCpf() {
		return cpf;
	}

	public String getName() {
		return name;
	}

}
