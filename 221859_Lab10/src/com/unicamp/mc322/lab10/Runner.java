package com.unicamp.mc322.lab10;

import java.awt.Point;

public class Runner {

	public static void main(String[] args) {
		
		Pidao pidao = new Pidao();
		
		User user1 = new User("John", "123.123.426-99", new Point(2, 3));
		pidao.addClient(user1);
		
		Restaurant restaurant1 = new Restaurant("Marambar", "1234.5678.1234/23", new Point(4, 7));
		pidao.addRestaurant(restaurant1);
		
		Restaurant restaurant2 = new Restaurant("Estacao", "2456.5678.1234/22", new Point(5, 1));
		pidao.addRestaurant(restaurant2);
		
		DeliveryDriver deliveryDriver1 = new DeliveryDriver("Mateus", "983.627.139-35");
		pidao.addDeliveryDriver(deliveryDriver1);
		restaurant1.addAvailableDriver(deliveryDriver1);
		
		DeliveryDriver deliveryDriver2 = new DeliveryDriver("Joao", "123.456.123-55");
		pidao.addDeliveryDriver(deliveryDriver2);
		restaurant2.addAvailableDriver(deliveryDriver2);
		
		Snack batata = new Snack("BTTFR", "Batata frita", 12.00);
		Snack cuscuz = new Snack("CCZ00", "Cuscuz com ovo", 10.00);	
		Snack macaxeira = new Snack("MXCOS", "Macaxeira com costela no bafo", 15.00);
		Snack coxinhaFrango = new Snack("CXFRA", "Coxinha de frango", 8.00);
		
		pidao.addSnack(batata, restaurant1);
		pidao.addSnack(macaxeira, restaurant1);
		pidao.addSnack(coxinhaFrango, restaurant1);
		
		pidao.removeSnack(batata, restaurant1);
		
		pidao.addSnack(cuscuz, restaurant2);
		pidao.applyDiscount("CCZ00", restaurant2, 2, DiscountType.FIXED_VALUE);
		
		Order order1 = new Order(user1, restaurant1, ReceivingOption.DELIVERY);
		order1.addSnack(coxinhaFrango);
		pidao.addOrder(order1);
//		pidao.takeawayOrder(order1);
		
		Order order2 = new Order(user1, restaurant1, ReceivingOption.TAKEAWAY);
		order2.addSnack(macaxeira);
		order2.addSnack(coxinhaFrango);
		pidao.addOrder(order2);
//		pidao.takeawayOrder(order2);
		
		Rating rating1 = new Rating(4.96, "Muito atencioso e pontual");
		pidao.rateDeliveryDriver(order1, deliveryDriver1, rating1);
		
		Rating rating2 = new Rating(4.99, "Gostoso e temperatura certa");
		pidao.rateSnack(order1, coxinhaFrango, rating2);
		Rating rating3 = new Rating(3.47, "Poderia melhorar o tempero");
		pidao.rateSnack(order2, coxinhaFrango, rating3);
		
		Rating rating4 = new Rating(4.5, "");
		pidao.rateRestaurant(order2, restaurant1, rating4);
		
		pidao.printOrderSummary();
		pidao.printRestaurantMenus();
//		pidao.printRatingsSummary();
	}

}
