package com.unicamp.mc322.lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pidao {

	private List<Restaurant> restaurants;
	private List<User> clients;
	private List<DeliveryDriver> deliveryDrivers;
	private List<Order> orders;
	
	public Pidao() {
		this.restaurants = new ArrayList<Restaurant>();
		this.clients = new ArrayList<User>();
		this.deliveryDrivers = new ArrayList<DeliveryDriver>();
		this.orders = new ArrayList<Order>();
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void addRestaurant(Restaurant restaurant) {
		this.restaurants.add(restaurant);
	}
	
	public void addSnack(Snack snack, Restaurant restaurant) {
		if (restaurant == null || snack == null) 
			System.out.println("You must add a snack in the menu of a restaurant. Specify which snack and restaurant.");
		else
			this.restaurants.get(this.restaurants.indexOf(restaurant)).addSnack(snack);
	}
	
	public void removeSnack(Snack snack, Restaurant restaurant) {
		if (restaurant == null || snack == null) 
			System.out.println("You must remove a snack from the menu of a restaurant. Specify which snack and restaurant.");
		else
			this.restaurants.get(this.restaurants.indexOf(restaurant)).removeSnack(snack);
	}

	public List<User> getClients() {
		return clients;
	}

	public void addClient(User client) {
		this.clients.add(client);
	}

	public List<DeliveryDriver> getDeliveryDrivers() {
		return deliveryDrivers;
	}

	public void addDeliveryDriver(DeliveryDriver deliveryDriver) {
		this.deliveryDrivers.add(deliveryDriver);
	}

	public List<Order> getOrders() {
		return orders;
	}
	
	public void setNextStatus(Order order) {
		order.setNextStatus();
	}

	public void addOrder(Order order) {
		order.getClient().setTotalOrders(order.getClient().getTotalOrders()+1);
		this.orders.add(order);
		switch(order.getReceivingOption()) {
		case DELIVERY:
			order.setDeliveryDriver(order.getRestaurant().getAvailableDrivers().get(0));
			order.getRestaurant().removeAvailableDriver(order.getDeliveryDriver());
			break;
		
		default:
			break;
		}
		
		setNextStatus(order);
	}
	
	public void cancelOrder(Order order) {
		switch (order.getStatus()) {
		case NEW:
		case PREPARING:
			orders.remove(order);
			order.getClient().setTotalOrders(order.getClient().getTotalOrders()-1);
			break;

		default:
			System.out.println("Order status: " + order.getStatus() + "\nYou cannot cancel an order that already left the restaurant.");
			break;
		}
	}
	
	public void takeawayOrder(Order order) {
		switch (order.getReceivingOption()) {
		case TAKEAWAY:
			switch (order.getStatus()) {
			case READY:
				this.orders.remove(order);
				break;
				
			default:
				System.out.println("Order status: " + order.getStatus() + "\nYou cannot take an order unless it is ready.");
				break;
			}
			break;
		
		default:
			System.out.println("Order receiving option: " + order.getReceivingOption() + "\nYou cannot take an order that is for delivery.");
			break;
		}
	}
	
	public void rateSnack(Order order, Snack snack, Rating rating) {
		if (order.getSnacks().indexOf(snack) != -1)
			order.getSnacks().get(order.getSnacks().indexOf(snack)).addRating(rating);
		else
			System.out.println("This snack was not included in this order.");
	}
	
	public void rateRestaurant(Order order, Restaurant restaurant, Rating rating) {
		if (order.getRestaurant().equals(restaurant))
			order.getRestaurant().addRating(rating);
		else
			System.out.println("This restaurant did not deliver this order.");
	}
	
	public void rateDeliveryDriver(Order order, DeliveryDriver deliveryDriver, Rating rating) {
		if (order.getDeliveryDriver().equals(deliveryDriver))
			order.getDeliveryDriver().addRating(rating);
		else
			System.out.println("This person did not deliver this order.");
	}
	
	public void applyDiscount(String snackId, Restaurant restaurant, int discountValue, DiscountType discountType) {
		Optional<Snack> snackList = restaurant.getMenu().stream().filter(food -> food.getSnackId().equals(snackId)).findAny();
		if (snackList.isPresent()) {
			Snack snack = snackList.get();
			switch (discountType) {
			case PERCENTAGE:
				double discount = snack.getSnackPrice() * ((double)(100 - discountValue) / 100);
				snack.setDiscountPrice(discount);
				break;
			case FIXED_VALUE:
				snack.setDiscountPrice(snack.getSnackPrice() - discountValue);
				break;
			default:
				snack.setDiscountPrice(snack.getSnackPrice() - discountValue);
				break;
			}
		} else {
			System.out.println("This product [" + snackId + "] does not exist in [" + restaurant.getName() + "].");
		}
	}
	
	public void removeDiscount(String snackId, Restaurant restaurant) {
		Optional<Snack> snackList = restaurant.getMenu().stream().filter(food -> food.getSnackId().equals(snackId)).findAny();
		if (snackList.isPresent()) {
			snackList.get().setDiscountPrice(snackList.get().getSnackPrice());;
		} else {
			System.out.println("This product [" + snackId + "] does not exist in [" + restaurant.getName() + "].");
		}
	}
	
	public void printOrderSummary() {
		System.out.println("Existem " + getOrders().size() + " pedidos:\n============================================");
		for (int i = 0; i < getOrders().size(); i++) {
			Order order = getOrders().get(i);
			System.out.println("Usuario: " + order.getClient().getName() + " (" + order.getClient().getCpf() + ")");
			System.out.println("Restaurante: " + order.getRestaurant().getName() + " (" + order.getRestaurant().getCnpj() + ")");
			System.out.println("Forma de recebimento: " + order.getReceivingOption());
			System.out.println("Status do pedido: " + order.getStatus());
			for (int j = 0; j < order.getSnacks().size(); j++) 
				System.out.println("- " + order.getSnacks().get(j).getSnackId());
			System.out.printf("Valor Total: R$ %.2f \n============================================\n", order.getBill());
		}
	}
	
	public void printRestaurantMenus() {
		System.out.println("Total de restaurantes cadastrados: " + getRestaurants().size() + "\n============================================");
		for (Restaurant restaurant : restaurants) {
			System.out.println("Restaurante: " + restaurant.getName() + " (" + restaurant.getCnpj() + ")");
			for (Snack snack : restaurant.getMenu()) {
				System.out.println("\n" + snack.getSnackId() + ": " + snack.getName());
				if (snack.getDiscountPrice() < snack.getSnackPrice())
					System.out.println("Preco com desconto: " + snack.getDiscountPrice());
				System.out.println("Preco normal: " + snack.getSnackPrice());
			}
			System.out.println("============================================");
		}	
	}
	
	public void printRatingsSummary() {
		System.out.println("Avaliacoes de nossos entregadores:\n============================================");
		for (DeliveryDriver deliveryDriver : deliveryDrivers) {
			System.out.println("Pessoa entregadora: " + deliveryDriver.getName());
			if (deliveryDriver.getRating().size() > 0) {
				double meanRating = 0;
				for (Rating rating : deliveryDriver.getRating()) {
					meanRating += rating.getRating();
					System.out.println("Nota: " + rating.getRating());
					if (!rating.getReview().isEmpty())
						System.out.println("Comentario: " + rating.getReview());
				}
				meanRating = meanRating / deliveryDriver.getRating().size();
				System.out.println("Avaliacao media de: " + meanRating + "\n--------------------------------------------");
			} else {
				System.out.println("Avaliacao media de: indefinida pois nao existem avaliacoes ainda.\n--------------------------------------------");
			}
		}
		System.out.println("============================================\nAvaliacoes de nossos restaurantes:\n============================================");
		for (Restaurant restaurant : restaurants) {
			System.out.println("Restaurante: " + restaurant.getName());
			if (restaurant.getRating().size() > 0) {
				double meanRating = 0;
				for (Rating rating : restaurant.getRating()) {
					meanRating += rating.getRating();
					System.out.println("Nota: " + rating.getRating());
					if (!rating.getReview().isEmpty())
						System.out.println("Comentario: " + rating.getReview());
				}
				meanRating = meanRating / restaurant.getRating().size();
				System.out.println("Avaliacao media de: " + meanRating + "\n--------------------------------------------");
			} else {
				System.out.println("Avaliacao media de: indefinida pois nao existem avaliacoes ainda.\n--------------------------------------------");
			}
		}
		System.out.println("============================================\nAvaliacoes de nossos lanches:\n============================================");
		for (Restaurant restaurant : restaurants) {
			System.out.println("--------------------------------------------\nRestaurante: " + restaurant.getName() + "\n--------------------------------------------");
			for (Snack snack : restaurant.getMenu()) {
				System.out.println("* Lanche: " + snack.getName());
				if (snack.getRating().size() > 0) {
					double meanRating = 0;
					for (Rating rating : snack.getRating()) {
						meanRating += rating.getRating();
						System.out.println("----\nNota: " + rating.getRating());
						if (!rating.getReview().isEmpty())
							System.out.println("Comentario: " + rating.getReview());
					}
					meanRating = meanRating / snack.getRating().size();
					System.out.println("----\nAvaliacao media de " + snack.getName() + ": " + meanRating + "\n--------------------------------------------");
				} else {
					System.out.println("----\nAvaliacao media de " + snack.getName() + ": indefinida pois nao existem avaliacoes ainda.\n--------------------------------------------");
				}
			}
		}
	}
}
