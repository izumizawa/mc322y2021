package com.unicamp.mc322.lab03;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

	public Hotel(String hotelName, String hotelAddress, String hotelTelephone, int vipRoomPrice, int standardRoomPrice) {
		setHotelName(hotelName);;
		setHotelAddress(hotelAddress);
		setHotelTelephone(hotelTelephone);
		setHotelRooms();
		setVipRoomPrice(vipRoomPrice);
		setStandardRoomPrice(standardRoomPrice);
	}
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelTelephone() {
		return hotelTelephone;
	}

	public void setHotelTelephone(String hotelTelephone) {
		this.hotelTelephone = hotelTelephone;
	}

	public List<Room> getHotelRooms() {
		return hotelRooms;
	}

	// Generate 100 hotel rooms
	public void setHotelRooms() {
		ArrayList<Room> roomsList = new ArrayList<Room>(100);
		for (int i = 0; i < 10; i++) 
			roomsList.add(new Room(true));
		for (int i = 10; i < 100; i++) 
			roomsList.add(new Room(false));
		this.hotelRooms = roomsList;
	}
	
	public void setHotelRooms(Room room, int index) {
		this.hotelRooms.set(index, room);
	}

	public int getVipRoomPrice() {
		return vipRoomPrice;
	}

	public void setVipRoomPrice(int vipRoomPrice) {
		this.vipRoomPrice = vipRoomPrice;
	}

	public int getStandardRoomPrice() {
		return standardRoomPrice;
	}

	public void setStandardRoomPrice(int standardRoomPrice) {
		this.standardRoomPrice = standardRoomPrice;
	}
	
	public List<Room> getAvailableRooms() {
		List<Room> availableRooms = new ArrayList<Room>(100);
		for (int i = 0; i < 100; i++) {
			if (!hotelRooms.get(i).isOccupied()) {
				availableRooms.add(hotelRooms.get(i));
			}
		}
		return availableRooms;
	}
	
	public void printAvailableRooms() {
		for (int i = 0; i < 100; i++) {
			System.out.print("Room ");
			if(hotelRooms.get(i).isVip())
				System.out.print("VIP ");
			else 
				System.out.print("standard ");
			if (!hotelRooms.get(i).isOccupied()) {
				System.out.println(i + " available");
			} else {
				System.out.println(i + " currently occupied");
			}
		}
	}
	
	public void printCurrentHotelState() {
		System.out.println("Hotel " + getHotelName());
		System.out.println("Address: " + getHotelAddress());
		System.out.println("Telephone number: " + getHotelTelephone());
		System.out.println("Standard room price: R$" + getStandardRoomPrice());
		System.out.println("VIP room price: R$" + getVipRoomPrice());
		System.out.println("\n-- Available rooms --");
		printAvailableRooms();
		
	}

	private String hotelName;
	private String hotelAddress;
	private String hotelTelephone;
	private List<Room> hotelRooms;
	private int vipRoomPrice;
	private int standardRoomPrice;

}
