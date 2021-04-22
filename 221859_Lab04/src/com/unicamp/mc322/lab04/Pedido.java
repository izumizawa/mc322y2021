package com.unicamp.mc322.lab04;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private User client;
	private List<Lanche> orderList;
	private Status orderStatus;
	private double orderBill;
	
	public Pedido(User user) {
		this.setClient(user);
		this.setOrderStatus(Status.NEW);
		this.orderList = new ArrayList<Lanche>();
	}

	public void addItem(Lanche snack) {
		orderList.add(snack);
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public List<Lanche> getOrderList() {
		return orderList;
	}

	public Status getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Status orderStatus) {
		switch (orderStatus) {
		case PREPARING:
			setOrderBill();
			break;
		default:
			break;
		}
		this.orderStatus = orderStatus;
	}

	public double getOrderBill() {
		return orderBill;
	}
	
	public void setOrderBill() {
		double finalBill = 0;
		for (int i = 0; i < orderList.size(); i ++) {
			if (orderList.get(i).getDiscountPrice() == orderList.get(i).getSnackPrice())
				finalBill += orderList.get(i).getSnackPrice();
			else
				finalBill += orderList.get(i).getDiscountPrice();
		}
		if (this.client.getUserTotalOrders() == 0) {
			finalBill = finalBill * 0.8;
		} else if (this.client.getUserTotalOrders() % 10 == 0) {
			if (finalBill <= 60)
				finalBill = 0;
			else
				finalBill -= 60;
		} else {
			if (finalBill > 100)
				finalBill = finalBill * 0.9;
		}
		this.orderBill = finalBill;
	}

}
