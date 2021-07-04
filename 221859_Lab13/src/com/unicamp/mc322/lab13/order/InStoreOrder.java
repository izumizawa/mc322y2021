package com.unicamp.mc322.lab13.order;

import java.time.LocalDateTime;

public class InStoreOrder extends Order implements IOrder {

	public InStoreOrder(PersonPT customer) {
		super(customer);
		LocalDateTime now = LocalDateTime.now();
		setCode("IN_STORE_" + now.getYear() + now.getMonth() + now.getDayOfMonth() 
				+ "_" + now.getHour() + now.getMinute() + now.getSecond());
	}

}
