package com.unicamp.mc322.lab06;

public class PodcastChannel extends Song {

	private int episodes;
	
	public PodcastChannel(String name, String genre, String artist, int duration, int episodes) {
		super(name, genre, artist, duration);
		this.episodes = episodes;
	}

	public int getEpisodes() {
		return episodes;
	}

	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}

	@Override
	public void setStorage() {
		this.storage = (getDuration()/60) * getEpisodes();
	}
}
