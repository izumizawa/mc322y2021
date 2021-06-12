package com.unicamp.mc322.lab10;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {

	private String name;
	private String cnpj;
	private Point location;
	private List<DeliveryDriver> availableDrivers;
	private List<Snack> menu;
	private List<Rating> rating;
	
	public Restaurant(String name, String cnpj, Point location) {
		this.name = name;
		this.cnpj = cnpj;
		this.location = location;
		this.availableDrivers = new ArrayList<DeliveryDriver>();
		this.menu = new ArrayList<Snack>();
		this.rating = new ArrayList<Rating>();
	}

	public String getName() {
		return name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Point getLocation() {
		return location;
	}

	public List<DeliveryDriver> getAvailableDrivers() {
		return availableDrivers;
	}
	
	public void addAvailableDriver(DeliveryDriver deliveryDriver) {
		this.availableDrivers.add(deliveryDriver);
	}
	
	public void removeAvailableDriver(DeliveryDriver deliveryDriver) {
		this.availableDrivers.remove(deliveryDriver);
	}

	public List<Snack> getMenu() {
		return menu;
	}

	public void addSnack(Snack snack) {
		this.menu.add(snack);
	}
	
	public void removeSnack(Snack snack) {
		this.menu.remove(snack);
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void addRating(Rating rating) {
		this.rating.add(rating);
	}

}
