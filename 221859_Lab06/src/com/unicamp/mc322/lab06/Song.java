package com.unicamp.mc322.lab06;

public class Song {
	
	private String name;
	private String genre;
	private String artist;
	private int duration; // in seconds
	protected int storage; // in MB

	public Song(String name, String genre, String artist, int duration) {
		this.setName(name);
		this.setGenre(genre);
		this.setArtist(artist);
		this.setDuration(duration);
		setStorage();
	};
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage() {
		this.storage = 5 * (getDuration()/60);
	}
	
}
