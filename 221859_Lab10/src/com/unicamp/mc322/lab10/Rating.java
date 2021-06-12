package com.unicamp.mc322.lab10;

public class Rating {

	private double rating;
	private String review;
	
	public Rating(double rating, String review) {
		if (rating <= 5 && rating >= 0) {
			this.rating = rating;
			this.review = review;
		}
		else
			System.out.println("Ratings must be between 0 and 5 stars.");
	}

	public double getRating() {
		return rating;
	}

	public String getReview() {
		return review;
	}

}
