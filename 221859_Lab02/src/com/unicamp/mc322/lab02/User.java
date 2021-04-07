package com.unicamp.mc322.lab02;

import java.util.ArrayList;
import java.util.List;

public class User {

	public User(String name, String cpf) {
		this.setName(name);
		this.setCpf(cpf);
		setIsSubscriber(false);
		setUserPlaylists();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getIsSubscriber() {
		return isSubscriber;
	}

	public void setIsSubscriber(Boolean isSubscriber) {
		this.isSubscriber = isSubscriber;
	}

	public List<Playlist> getUserPlaylists() {
		return userPlaylists;
	}

	public void setUserPlaylists() {
		ArrayList<Playlist> playlistList = new ArrayList<Playlist>(10);
		this.userPlaylists = playlistList;
	}
	
	public void addPlaylist(Playlist newPlaylist) {
		// User is not premium
		if (!getIsSubscriber()) {
			if (getUserPlaylists().size() >= 3) {
				System.out.println("Limite de playlists gratuitas alcançado. Seja assinante e obtenha até 10 playlists!");
			}
			else {
				this.userPlaylists.add(newPlaylist);
			}
		}
		// Premium user
		else {
			if (getUserPlaylists().size() < 10) {
				this.userPlaylists.add(newPlaylist);
			}
			else {
				System.out.println("Limite de 10 playlists alcançado.");
			}
		}
	}
	
	public void removePlaylist(Playlist deletedPlaylist) {
		this.userPlaylists.remove(deletedPlaylist);
	}
	
	public void transferPlaylist(Playlist tranferedPlaylist, User newOwner) {
		newOwner.addPlaylist(tranferedPlaylist);
		this.userPlaylists.remove(tranferedPlaylist);
	}
	public void showPlaylists() {
		System.out.println("User: " + getName());
		System.out.println("Number of Playlists: " + getUserPlaylists().size());
		for (int i = 0; i < userPlaylists.size(); i++) {
			System.out.println("Playlist " + (i+1) + ": " + userPlaylists.get(i).getPlaylistName());
			System.out.println("\tNumber of songs: " + userPlaylists.get(i).getPlaylistSongs().size());
			System.out.println("\tSongs: ");
			for (int k = 0; k < userPlaylists.get(i).getPlaylistSongs().size(); k++) {
				System.out.println("\t- " + userPlaylists.get(i).getPlaylistSongs().get(k).getSongName() + " - " + userPlaylists.get(i).getPlaylistSongs().get(k).getArtist() + ";");
			}
		}
	}

	public void showInformation() {
		System.out.println("Nome: " + getName());
		System.out.println("CPF: " + getCpf());
		if (getBirthdate() != null)
			System.out.println("Data de nascimento: " + getBirthdate());
		if (getGender() != null)
			System.out.println("Gênero: " + getGender());
		System.out.print("Assinante: ");
		if (getIsSubscriber())
			System.out.println("premium\n");
		else
			System.out.println("free\n");
	}
	
	private String name;
	private String cpf;
	private String birthdate;
	private String gender;
	private Boolean isSubscriber;
	private List<Playlist> userPlaylists;

}
