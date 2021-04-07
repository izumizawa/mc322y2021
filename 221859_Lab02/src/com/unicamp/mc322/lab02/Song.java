package com.unicamp.mc322.lab02;

public class Song {
	
	public Song(String songName, String musicGenre, String artist, int songDuration) {
		this.setSongName(songName);
		this.setMusicGenre(musicGenre);
		this.setArtist(artist);
		this.setSongDuration(songDuration);
	};
	
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getMusicGenre() {
		return musicGenre;
	}

	public void setMusicGenre(String musicGenre) {
		this.musicGenre = musicGenre;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getSongDuration() {
		return songDuration;
	}

	public void setSongDuration(int songDuration) {
		this.songDuration = songDuration;
	}

	private String songName;
	private String musicGenre;
	private String artist;
	private int songDuration;
}
