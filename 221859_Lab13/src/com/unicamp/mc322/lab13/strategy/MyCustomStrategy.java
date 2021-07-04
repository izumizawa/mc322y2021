package com.unicamp.mc322.lab13.strategy;

import com.unicamp.mc322.lab13.order.IOrder;

public class MyCustomStrategy implements IOrderingStrategy {

	private float score;
	
	public MyCustomStrategy() {
	}

	@Override
	public float calculateScore(IOrder order) {
		if (order.getPerson().getAge() >= 60)
			score = (order.getPerson().getAge()/100) + order.getShifts();
		else
			score = order.getShifts();
		return score;
	}

}
