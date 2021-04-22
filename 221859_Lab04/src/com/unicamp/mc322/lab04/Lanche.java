package com.unicamp.mc322.lab04;

public class Lanche {

	private String snackId;
	private String name;
	private double snackPrice;
	private double discountPrice;
	
	public Lanche(String snackId, String name, double snackPrice) {
		this.snackId = snackId;
		this.name = name;
		this.snackPrice = snackPrice;
		this.discountPrice = snackPrice;
	}

	public String getSnackId() {
		return snackId;
	}

	public void setSnackId(String snackId) {
		this.snackId = snackId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
