package com.unicamp.mc322.lab06;

public class Video extends Song {

	private int fps;
	private int pixels;
	
	public Video(String name, String genre, String artist, int duration, int fps, int pixels) {
		super(name, genre, artist, duration);
		
	}

	@Override
	public void setStorage() {
		int image = (pixels * fps * getDuration()) / 1000000;
		this.storage = (5 * (getDuration()/60)) + image;
	}

}
