package com.unicamp.mc322.lab02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Playlist {

	public Playlist(String playlistName, String playlistGender) {
		this.playlistName = playlistName;
		this.playlistGender = playlistGender;
		setPlaylistSongs();
	}
	
	public String getPlaylistName() {
		return playlistName;
	}
	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public String getPlaylistGender() {
		return playlistGender;
	}

	public void setPlaylistGender(String playlistGender) {
		this.playlistGender = playlistGender;
	}

	public List<Song> getPlaylistSongs() {
		return playlistSongs;
	}
	
	public void setPlaylistSongs() {
		ArrayList<Song> songsList = new ArrayList<Song>(100);
		this.playlistSongs = songsList;
	}
	
	public void addSong(Song newSong) {
		if (playlistSongs.size() == 0)
			setCurrentSong(newSong);
		this.playlistSongs.add(newSong);
		this.playlistSongs.sort(Comparator.comparing(Song::getSongName));
	}
	
	public void deleteSong(Song unwantedSong) {
		this.playlistSongs.remove(unwantedSong);
	}
	
	public Song getLowerDurationSong() {
		Song lowerDurationSong = playlistSongs.get(0);
		for (int i = 1; i < playlistSongs.size(); i++) {
			if (playlistSongs.get(i).getSongDuration() < lowerDurationSong.getSongDuration()) 
				lowerDurationSong = playlistSongs.get(i);
		}
		return lowerDurationSong;
	}
	
	public Song getHigherDurationSong() {
		Song higherDurationSong = playlistSongs.get(0);
		for (int i = 1; i < playlistSongs.size(); i++) {
			if (playlistSongs.get(i).getSongDuration() > higherDurationSong.getSongDuration()) 
				higherDurationSong = playlistSongs.get(i);
		}
		return higherDurationSong;
	}
	
	public int getAverageSongsDuration() {
		int durationSongs = playlistSongs.get(0).getSongDuration();
		for (int i = 1; i < playlistSongs.size(); i++) {
			durationSongs = durationSongs + playlistSongs.get(i).getSongDuration();
		}
		return durationSongs / playlistSongs.size();
	}
	
	public int getPlaylistDuration() {
		int playlistDuration = playlistSongs.get(0).getSongDuration();
		for (int i = 1; i < playlistSongs.size(); i++) {
			playlistDuration = playlistDuration + playlistSongs.get(i).getSongDuration();
		}
		return playlistDuration;
	}

	public String getArtistWithMoreSongs() {
		String playlistArtistWithMoreSongs = null;
		String firstArtist = playlistSongs.get(0).getArtist();
		Long playlistArtistWithMoreMusicSongs = playlistSongs.stream().filter(playlistSongs -> playlistSongs.getArtist().equals(firstArtist)).count();
		playlistArtistWithMoreSongs = firstArtist;
		for (int i = 1; i < playlistSongs.size(); i++) {
			String playlistArtist = playlistSongs.get(i).getArtist();
			Long playlistArtistSongs = playlistSongs.stream().filter(playlistSongs -> playlistSongs.getArtist().equals(playlistArtist)).count();
			if (playlistArtistSongs > playlistArtistWithMoreMusicSongs) {
				playlistArtistWithMoreMusicSongs = playlistArtistSongs;
				playlistArtistWithMoreSongs = playlistArtist;
			}
		}
		return playlistArtistWithMoreSongs;
	}
	
	public Song play() {
		if (currentSong.equals(playlistSongs.get(0))) {
			setCurrentSong(playlistSongs.get(1));
			return getCurrentSong();
		}
		return getCurrentSong();
	}
	
	public Song play(Boolean shuffle) {
		Random generator = new Random();
		Song randomSong = getCurrentSong();
		Song previouslySong = getCurrentSong();
		if (shuffle)
			while (previouslySong.equals(randomSong)) {
				randomSong = playlistSongs.get(generator.nextInt(this.playlistSongs.size()));
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

	private String playlistName;
	private String playlistGender;
	private List<Song> playlistSongs;
	private Song currentSong;

}
