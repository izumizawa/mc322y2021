package com.unicamp.mc322.lab06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Playlist {
	
	private String name;
	private int storage;
	private List<Song> songs;
	private Song currentSong;

	public Playlist(String name) {
		this.name = name;
		this.storage = 0;
		this.currentSong = null;
		setSongs();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage() {
		int size = 0;
		for (Song song : getSongs()) 
			size =+ song.getStorage();
		this.storage = size;
	}

	public List<Song> getSongs() {
		return songs;
	}
	
	public void setSongs() {
		ArrayList<Song> songsList = new ArrayList<Song>();
		this.songs = songsList;
	}
	
	public void addSong(Song newSong) {
//		if (songs.size() == 0)
//			setCurrentSong(newSong);
		this.songs.add(newSong);
		setStorage();
		this.songs.sort(Comparator.comparing(Song::getName));
	}
	
	public void deleteSong(Song unwantedSong) {
		this.songs.remove(unwantedSong);
		setStorage();
	}
	
	public Song getLowerDurationSong() {
		Song lowerDurationSong = songs.get(0);
		for (int i = 1; i < songs.size(); i++) {
			if (songs.get(i).getDuration() < lowerDurationSong.getDuration()) 
				lowerDurationSong = songs.get(i);
		}
		return lowerDurationSong;
	}
	
	public Song getHigherDurationSong() {
		Song higherDurationSong = songs.get(0);
		for (int i = 1; i < songs.size(); i++) {
			if (songs.get(i).getDuration() > higherDurationSong.getDuration()) 
				higherDurationSong = songs.get(i);
		}
		return higherDurationSong;
	}
	
	public int getAverageSongsDuration() {
		int durationSongs = songs.get(0).getDuration();
		for (int i = 1; i < songs.size(); i++) {
			durationSongs = durationSongs + songs.get(i).getDuration();
		}
		return durationSongs / songs.size();
	}
	
	public int getPlaylistDuration() {
		int playlistDuration = songs.get(0).getDuration();
		for (int i = 1; i < songs.size(); i++) {
			playlistDuration = playlistDuration + songs.get(i).getDuration();
		}
		return playlistDuration;
	}

	public String getArtistWithMoreSongs() {
		String playlistArtistWithMoreSongs = null;
		String firstArtist = songs.get(0).getArtist();
		Long playlistArtistWithMoreMusicSongs = songs.stream().filter(songs -> songs.getArtist().equals(firstArtist)).count();
		playlistArtistWithMoreSongs = firstArtist;
		for (int i = 1; i < songs.size(); i++) {
			String playlistArtist = songs.get(i).getArtist();
			Long playlistArtistSongs = songs.stream().filter(songs -> songs.getArtist().equals(playlistArtist)).count();
			if (playlistArtistSongs > playlistArtistWithMoreMusicSongs) {
				playlistArtistWithMoreMusicSongs = playlistArtistSongs;
				playlistArtistWithMoreSongs = playlistArtist;
			}
		}
		return playlistArtistWithMoreSongs;
	}
	
	public Song play() {
		Song aux = getCurrentSong();
		if (aux == null)
			setCurrentSong(getSongs().get(0));
		else 
			for (int i = 0; i < getSongs().size(); i++) 
				if (aux.equals(songs.get(i))) 
					setCurrentSong(songs.get(i+1));
		return getCurrentSong();
	}
	
	public Song play(Boolean shuffle) {
		Random generator = new Random();
		Song randomSong = getCurrentSong();
		Song previouslySong = getCurrentSong();
		if (shuffle)
			while (previouslySong.equals(randomSong)) {
				randomSong = songs.get(generator.nextInt(this.songs.size()));
				setCurrentSong(randomSong);
			}
		return getCurrentSong();
	}
	
	public Song getCurrentSong() {
		return currentSong;
	}

	public void setCurrentSong(Song currentSong) {
		this.currentSong = currentSong;
	}

}