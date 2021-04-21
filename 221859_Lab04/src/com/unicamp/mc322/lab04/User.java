package com.unicamp.mc322.lab04;

public class User {

	private String userName;
	private String userCpf;
	private int[] userPosition;
	private int userTotalOrders;
	
	public User(String userName, String userCpf, int userX, int userY) {
		this.setUserName(userName);
		this.setUserCpf(userCpf);
		this.userPosition = new int[2];
		userPosition[0] = userX;
		userPosition[1] = userY;
		this.setUserTotalOrders(0);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCpf() {
		return userCpf;
	}

	public void setUserCpf(String userCpf) {
		this.userCpf = userCpf;
	}
	
	public int[] getPosition() {
		return userPosition;
	}

	public int getUserTotalOrders() {
		return userTotalOrders;
	}

	public void setUserTotalOrders(int userTotalOrders) {
		this.userTotalOrders = userTotalOrders;
	}

}
