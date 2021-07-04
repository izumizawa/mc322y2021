package com.unicamp.mc322.lab13.structure;

import com.unicamp.mc322.lab13.order.IOrder;

public interface ICrazyDS {
	public void addElement(IOrder order);
	public void removeElement(IOrder order);
	public IOrder peekElement();
	public void printElements();
	public IOrder getElementAt(int index);
}
