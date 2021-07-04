package com.unicamp.mc322.lab13.strategy;

import com.unicamp.mc322.lab13.order.IOrder;

public interface IOrderingStrategy {
	public float calculateScore(IOrder order);
}
