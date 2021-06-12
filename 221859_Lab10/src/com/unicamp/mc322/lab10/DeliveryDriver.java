package com.unicamp.mc322.lab10;

import java.util.ArrayList;
import java.util.List;

public class DeliveryDriver {

	private String name;
	private String cpf;
	private List<Rating> rating;
	
	public DeliveryDriver(String name, String cpf) {
		this.name = name;
		this.cpf = cpf;
		this.rating = new ArrayList<Rating>();
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void addRating(Rating rating) {
		this.rating.add(rating);
	}
	
}
