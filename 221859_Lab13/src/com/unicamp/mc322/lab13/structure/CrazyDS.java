package com.unicamp.mc322.lab13.structure;

import java.util.LinkedList;

import com.unicamp.mc322.lab13.order.IOrder;
import com.unicamp.mc322.lab13.strategy.IOrderingStrategy;

public class CrazyDS implements ICrazyDS {

	private LinkedList<IOrder> orders;
	private IOrderingStrategy strategy;
	
	public CrazyDS(IOrderingStrategy strategy) {
		this.orders = new LinkedList<IOrder>();
		this.strategy = strategy;
	}

	@Override
	public void addElement(IOrder order) {
		int index = orders.size();
		for (int i = 0; i < orders.size(); i++) {
			if (strategy.calculateScore(orders.get(i)) < strategy.calculateScore(order)) {
				if (index == orders.size())
					index = i;
			}
		}
		this.orders.add(index, order);
	}

	@Override
	public void removeElement(IOrder order) {
		if (orders.indexOf(order) == -1)
			throw new CrazyDSException("Order not found", new ClassNotFoundException());
		this.orders.remove(order);
	}

	@Override
	public IOrder peekElement() {
		return this.orders.peek();
	}

	@Override
	public void printElements() {
		System.out.println("Orders");
		for(IOrder order : this.orders) {
			order.printPersonInfo();
			System.out.println("Shifts: " + order.getShifts());
		}
	}

	@Override
	public IOrder getElementAt(int index) {
		if (index > orders.size()) 
			throw new CrazyDSException("Index out of bounds", new IndexOutOfBoundsException());
		return this.orders.get(index);
	}

}
