package com.unicamp.mc322.lab04;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pidao pidaoApp = new Pidao("MARAMBAR", "123.456.789-10", 10, 2);
		
		User user1 = pidaoApp.registerUser("Marcos Paulo", "123.789.643-11", 1, 2);
		User user2 = pidaoApp.registerUser("Pereira", "123.789.643-11", 8, 4);
		
		Lanche cuscuz = new Lanche("CCZ00", "Cuscuz com ovo", 10.00);	
		Lanche macaxeira = new Lanche("MXCOS", "Macaxeira com costela no bafo", 15.00);
		Lanche coxinhaFrango = new Lanche("CXFRA", "Coxinha de frango", 8.00);
						
		pidaoApp.addToMenu(cuscuz);
		pidaoApp.addToMenu(macaxeira);
		pidaoApp.addToMenu(coxinhaFrango);
		
		pidaoApp.applyDiscount("CCZ00", 10, DiscountType.PERCENTAGE);
		pidaoApp.applyDiscount("MXCOS", 10, DiscountType.VALUE);
		pidaoApp.removeDiscount("MXCOS");
		
		Pedido p1 = new Pedido(user1);
		p1.addItem(cuscuz);
		p1.addItem(macaxeira);
		pidaoApp.orderMeal(p1);
				
		Pedido p2 = new Pedido(user2);
		p2.addItem(coxinhaFrango);
		p2.addItem(coxinhaFrango);
		pidaoApp.orderMeal(p2);
		
		Pedido p3 = new Pedido(user2);
		p3.addItem(coxinhaFrango);
		p3.addItem(coxinhaFrango);
		pidaoApp.orderMeal(p3);
		
		
		pidaoApp.printRestaurantMenu();
		
		pidaoApp.printOrderSummary();
		
		Pedido p4 = new Pedido(user1);
		p4.addItem(macaxeira);
		p4.addItem(cuscuz);
		pidaoApp.orderMeal(p4);
		pidaoApp.cancelOrder(p3);
		
		pidaoApp.printOrderSummary();

	}

}
