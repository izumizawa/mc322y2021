package com.unicamp.mc322.lab13.strategy;

import com.unicamp.mc322.lab13.order.IOrder;

public class PriorityScore implements IOrderingStrategy {

	private float score;
	
	public PriorityScore() {
	}

	@Override
	public float calculateScore(IOrder order) {
		this.score = (order.getPerson().getAge()/100) + ((7/100)*order.getShifts());
		return score;
	}

}
