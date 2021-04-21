package com.unicamp.mc322.lab04;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pidao {

	private String name;
	private String cnpj;
	private int[] position;
	private List<Lanche> menu;
	private List<Pedido> orderList;
	
	public Pidao(String name, String cnpj, int x, int y) {
		this.name = name;
		this.cnpj = cnpj;
		this.position = new int[2];
		position[0] = x;
		position[1] = y;
		this.menu = new ArrayList<Lanche>();
		this.orderList = new ArrayList<Pedido>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int[] getPosition() {
		return position;
	}

	public User registerUser(String userName, String userCpf, int userX, int userY) {
		User newUser = new User(userName, userCpf, userX, userY);
		return newUser;
	}

	public void addToMenu(Lanche snack) {
		Optional<Lanche> sameSnackId = menu.stream().filter(food -> food.getSnackId().equals(snack.getSnackId())).findAny();
		if (sameSnackId.isEmpty()) {
			menu.add(snack);			
		} else {
			System.out.println("It's not possible to add an snack with an existing snack ID. Please insert another 5-digit ID.");
		}
	}

	public void removeFromMenu(Lanche snack) {
		menu.remove(snack);
	}
	
	public void printRestaurantMenu() {
		System.out.println("Restaurante " + this.getName());
		System.out.println("(CNPJ: " + this.getCnpj() + ")\n");
		System.out.println("Cardapio de hoje: ");
		for (int i = 0; i < this.menu.size(); i++) {
			Lanche snack = this.menu.get(i);
			if (snack.getDiscountPrice() == snack.getSnackPrice())
				System.out.println("[" + snack.getSnackId() + "] " + snack.getSnackName() + " R$ " + snack.getSnackPrice());
			else {
				System.out.println("[" + snack.getSnackId() + "] " + snack.getSnackName() + " R$ " + snack.getDiscountPrice() + " (PROMOCAO! Preço normal: R$" + snack.getSnackPrice() + ")");				
			}
		}
		System.out.println();
	}

	public void applyDiscount(String snackId, int discountValue, DiscountType discountType) {
		Optional<Lanche> snackList = menu.stream().filter(food -> food.getSnackId().equals(snackId)).findAny();
		if (snackList.isPresent()) {
			Lanche snack = snackList.get();
			switch (discountType) {
			case PERCENTAGE:
				double discount = snack.getSnackPrice() * ((double)(100 - discountValue) / 100);
				snack.setDiscountPrice(discount);
				break;
			case VALUE:
				snack.setDiscountPrice(snack.getSnackPrice() - discountValue);
				break;
			default:
				snack.setDiscountPrice(snack.getSnackPrice() - discountValue);
				break;
			}
		} else {
			System.out.println("This product [" + snackId + "] does not exist.");
		}
	}
	
	public void removeDiscount(String snackId) {
		Optional<Lanche> snackList = menu.stream().filter(food -> food.getSnackId().equals(snackId)).findAny();
		if (snackList.isPresent()) {
			snackList.get().setDiscountPrice(snackList.get().getSnackPrice());;
		} else {
			System.out.println("This product [" + snackId + "] does not exist.");
		}
	}

	public void orderMeal(Pedido order) {
		order.setOrderStatus(Status.PREPARING);
		order.getClient().setUserTotalOrders(order.getClient().getUserTotalOrders()+1);
		orderList.add(order);
	}
	
	public void cancelOrder(Pedido order) {
		switch (order.getOrderStatus()) {
		case NEW:
		case PREPARING:
			orderList.remove(order);
			order.getClient().setUserTotalOrders(order.getClient().getUserTotalOrders()-1);
			break;

		default:
			System.out.println("Order status: " + order.getOrderStatus() + "\nYou cannot cancel an order that already left the restaurant.");
			break;
		}
	}

	public List<Pedido> getOrderList() {
		return orderList;
	}

	public void printOrderSummary() {
		System.out.println("Existem " + getOrderList().size() + " pedidos:\n============================================");
		for (int i = 0; i < getOrderList().size(); i++) {
			Pedido order = getOrderList().get(i);
			System.out.println("Usuário: " + order.getClient().getUserName() + " (" + order.getClient().getUserCpf() + ")");
			for (int j = 0; j < order.getOrderList().size(); j++) 
				System.out.println("- " + order.getOrderList().get(j).getSnackId());
			System.out.printf("Valor Total: R$ %.2f \n============================================\n", order.getOrderBill());
		}
	}

}
