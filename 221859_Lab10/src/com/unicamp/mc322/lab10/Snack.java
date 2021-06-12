package com.unicamp.mc322.lab10;

import java.util.ArrayList;
import java.util.List;

public class Snack {

	private String snackId;
	private String name;
	private double snackPrice;
	private double discountPrice;
	private List<Rating> rating;
	
	public Snack(String snackId, String name, double snackPrice) {
		this.snackId = snackId;
		this.name = name;
		this.snackPrice = snackPrice;
		this.discountPrice = snackPrice;
		this.rating = new ArrayList<Rating>();
	}

	public String getSnackId() {
		return snackId;
	}

	public String getName() {
		return name;
	}
	
	public double getSnackPrice() {
		return snackPrice;
	}
	
	public void setSnackPrice(double snackPrice) {
		this.snackPrice = snackPrice;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void addRating(Rating rating) {
		this.rating.add(rating);
	}
	
}
