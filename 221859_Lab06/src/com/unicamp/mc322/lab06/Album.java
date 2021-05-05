package com.unicamp.mc322.lab06;

import java.util.List;

public class Album extends Song {

	private List<Song> songs;

	public Album(String name, String genre, String artist, int duration, List<Song> songs) {
		super(name, genre, artist, duration);
		this.songs = songs;
		setArtist();
		setDuration();
		setCurrentStorage();
	}

	public void setArtist() {
		String artist = getSongs().get(0).getArtist();
		for (int i = 0; i < getSongs().size(); i++) 
			if (getSongs().get(i).getArtist() != artist) 
				artist = "Varios autores";
		setArtist(artist);
	}

	public void setDuration() {
		int duration = 0;
		for (Song song : getSongs()) 
			duration =+ song.getDuration();
		setDuration(duration);
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}


	public void setCurrentStorage() {
		int size = 0;
		for (Song song : getSongs()) 
			size =+ song.getStorage();
		this.storage = size;
	}

}
