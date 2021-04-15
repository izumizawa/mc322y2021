package com.unicamp.mc322.lab03;

public class Booking {
	
	public Booking(User user, Hotel hotel, int room, int days) {
		Room hotelRoom = hotel.getHotelRooms().get(room);
		Room bookedRoom;
		int daily;
		boolean updateBalance = true;
		System.out.println("Hello, " + user.getUsername());
		if (!hotelRoom.isOccupied()) {
			if (room < 10) {
				daily = hotel.getVipRoomPrice();
				bookedRoom = new Room(true);
			}
			else {
				daily = hotel.getStandardRoomPrice();
				bookedRoom = new Room(false);
			}
			if (user.isSmoker()) {
				if (!hotel.getHotelRooms().get(room).getAcceptSmokers()) {
					System.out.println("Sorry, this room does not accept smokers.");
					updateBalance = false;
				}
			}
			if (updateBalance) {
				bookedRoom.setOccupied(true);
				bookedRoom.setUser(user);
				bookedRoom.setBookedDays(days);
				hotel.setHotelRooms(bookedRoom, room);
				user.setCurrentBalance(user.getCurrentBalance()-(daily*days));
				System.out.println("Booking succeeded!");
			}
		} else {
			System.out.println("Sorry, this room is not currently available.");
		}
	}
	
	public static void cancelBooking(User user, Hotel hotel, int room) {
		if (hotel.getHotelRooms().get(room).getUser() != null)
			if (hotel.getHotelRooms().get(room).getUser().equals(user)) {
				if (room < 10)
					user.setCurrentBalance((int) (user.getCurrentBalance() + (0.7*hotel.getVipRoomPrice()*hotel.getHotelRooms().get(room).getBookedDays())));
				else
					user.setCurrentBalance((int) (user.getCurrentBalance() + (0.7*hotel.getStandardRoomPrice()*hotel.getHotelRooms().get(room).getBookedDays())));
				hotel.getHotelRooms().get(room).setOccupied(false);
				hotel.getHotelRooms().get(room).setUser(null);
				hotel.getHotelRooms().get(room).setBookedDays(0);
				System.out.println("Booking cancelled.");
			} else {
				System.out.println("Room " + room + " was not booked by " + user.getUsername() + " at " + hotel.getHotelName() + " hotel.");
			}
		else
			System.out.println("Room " + room + " was not booked by " + user.getUsername() + " at " + hotel.getHotelName() + " hotel.");
	}

	public static void main(String[] args) {

//		System.out.println("\n--- 1 - Crie os seguintes Hotéis: ---");
		Hotel hotel1 = new Hotel("Praia Tropical", "Rua Tajubá, 201 - Florianópolis, SC", "3225-8997", 900, 100);
		Hotel hotel2 = new Hotel("Campo Florestal", "Rua Monteiro, 456 - Goiânia, GO", "3654-8974", 2000, 50);
		hotel1.printCurrentHotelState();
		System.out.println();
		hotel2.printCurrentHotelState();
		
//		System.out.println("\n--- 2 - Crie os seguintes usuários: ---");
		User user1 = new User("Roberci Silva", "784245698-21", "12/04/1996", "Masculino", 1000, true);
		user1.printUserInfo();
		System.out.println();
		User user2 = new User("Marcela Domingues", "269784061-45", "22/07/1998", "Feminino", 2000, false);
		user2.printUserInfo();
		
//		System.out.println("\n--- 3 - Crie dois tipos de quartos: ---");
		System.out.println("Room 1");
		Room room1 = new Room(false, false, false, false);
		room1.printRoomInfo();
		System.out.println("\nRoom 2");
		Room room2 = new Room(true, false, true, true);
		room2.printRoomInfo();
		
		// Setting hotel rooms as these rooms
		for (int i = 0; i < 10; i++) {
			hotel1.setHotelRooms(room2, i);
			hotel2.setHotelRooms(room2, i);
		}
		for (int i = 10; i < 100; i++) {
			hotel1.setHotelRooms(room1, i);
			hotel2.setHotelRooms(room1, i);
		}
		
//		System.out.println("\n--- 4 - Crie as seguintes reservas: ---");
		Booking booking1 = new Booking(user1, hotel1, 2, 1);
		Booking booking2 = new Booking(user2, hotel2, 13, 4);


//		System.out.println("\n--- 5 - Tente reservar para Roberci Silva, no Hotel Praia Tropical, o quarto de número 87 por 1 dia. ---");
		Booking booking5 = new Booking(user1, hotel1, 87, 1);
		System.out.println();

//		System.out.println("\n--- 6 - Tente cancelar a reserva de Marcela Domingues no Hotel Praia Tropical, no quarto de número 22. ---");
		cancelBooking(user2, hotel1, 22);
		System.out.println();

//		System.out.println("\n--- 7 - Reserve para Roberci Silva, no Hotel Campo Florestal, o quarto de número 99 por 1 dia. ---");
		Booking booking7 = new Booking(user1, hotel2, 99, 1);
		System.out.println();
		
//		System.out.println("\n--- 8 - Cancele a reserva do item acima. ---");
		cancelBooking(user1, hotel2, 99);
		System.out.println();
		
//		System.out.println("\n--- 9 - Tente reservar para Marcela Domingues, no Hotel Campo Florestal, o quarto de número 87 por 1 dia. ---");
		Booking booking8 = new Booking(user2, hotel2, 87, 1);
		hotel2.getHotelRooms().get(87).printRoomInfo();
		System.out.println();
		
//		 Canceling booking
		cancelBooking(user2, hotel2, 87);
		hotel2.getHotelRooms().get(87).printRoomInfo();
	}

}
