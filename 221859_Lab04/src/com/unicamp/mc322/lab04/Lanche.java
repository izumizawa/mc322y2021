package com.unicamp.mc322.lab04;

public class Lanche {

	private String snackId;
	private String snackName;
	private double snackPrice;
	private double discountPrice;
	
	public Lanche(String snackId, String snackName, double snackPrice) {
		this.snackId = snackId;
		this.snackName = snackName;
		this.snackPrice = snackPrice;
		this.discountPrice = snackPrice;
	}

	public String getSnackId() {
		return snackId;
	}

	public void setSnackId(String snackId) {
		this.snackId = snackId;
	}

	public String getSnackName() {
		return snackName;
	}

	public void setSnackName(String snackName) {
		this.snackName = snackName;
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
