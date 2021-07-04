package com.unicamp.mc322.lab13.order;

import java.time.LocalDateTime;

public class InternetOrder extends Order implements IOrder {
	
	public InternetOrder(PersonPT customer) {
		super(customer);
		LocalDateTime now = LocalDateTime.now();
		setCode("INTERNET_" + now.getYear() + now.getMonth() + now.getDayOfMonth() 
				+ "_" + now.getHour() + now.getMinute() + now.getSecond());
	}

}
