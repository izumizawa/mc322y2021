package com.unicamp.mc322.lab10;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private User client;
	private Restaurant restaurant;
	private DeliveryDriver deliveryDriver;
	private List<Snack> snacks;
	private ReceivingOption receivingOption;
	private Status status;
	private double bill;
	
	public Order(User client, Restaurant restaurant, ReceivingOption receivingOption) {
		this.client = client;
		this.restaurant = restaurant;
		this.snacks = new ArrayList<Snack>();
		this.receivingOption = receivingOption;
		this.status = Status.NEW;
	}

	public User getClient() {
		return client;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public DeliveryDriver getDeliveryDriver() {
		return deliveryDriver;
	}

	public void setDeliveryDriver(DeliveryDriver deliveryDriver) {
		this.deliveryDriver = deliveryDriver;
	}

	public List<Snack> getSnacks() {
		return snacks;
	}

	public void addSnack(Snack snack) {
		if (restaurant.getMenu().indexOf(snack) != -1)
			this.snacks.add(snack);
		else
			System.out.println("This snack is not avalable in this restaurant.");
	}
	
	public void removeSnack(Snack snack) {
		this.snacks.remove(snack);
	}

	public ReceivingOption getReceivingOption() {
		return receivingOption;
	}

	public Status getStatus() {
		return status;
	}

	public void setNextStatus() {
		switch (status) {
		case NEW:
			status = Status.PREPARING;
			setBill();
			break;

		case PREPARING:
			status = Status.READY;
			break;

		case READY:
			status = Status.TRAVELING;
			break;

		case TRAVELING:
			status = Status.DELIVERED;
			break;

		default:
			break;
		}
	}

	public double getBill() {
		return bill;
	}

	public void setBill() {
		double finalBill = 0;

		for (int i = 0; i < snacks.size(); i ++) {
			if (snacks.get(i).getDiscountPrice() == snacks.get(i).getSnackPrice())
				finalBill += snacks.get(i).getSnackPrice();
			else
				finalBill += snacks.get(i).getDiscountPrice();
		}

		switch (receivingOption) {
		case DELIVERY:
			finalBill += 0.5 * Math.sqrt(Math.pow((client.getAddress().getX() - restaurant.getLocation().getX()), 2) +
					Math.pow((client.getAddress().getY() - restaurant.getLocation().getY()), 2));
			break;
			
		default:
			break;
		}

		if (client.getTotalOrders() == 0) {
			finalBill = 0.8 * finalBill;
		}

		bill = finalBill;
	}

}
