package com.unicamp.mc322.lab06;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String name;
	private String cpf;
	private String birthdate;
	private String gender;
	private Boolean isSubscriber;
	private List<Playlist> playlists;
	private int currentStorage; // in MB

	public User(String name, String cpf) {
		this.setName(name);
		this.setCpf(cpf);
		setIsSubscriber(false);
		setPlaylists();
		this.currentStorage = 0;
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

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists() {
		ArrayList<Playlist> playlistList = new ArrayList<Playlist>();
		this.playlists = playlistList;
	}
	
	public int getCurrentStorage() {
		return currentStorage;
	}

	public void incCurrentStorage(int storage) {
		this.currentStorage += storage;
	}
	
	public void decCurrentStorage(int storage) {
		this.currentStorage -= storage;
	}
	
	public void addPlaylist(Playlist newPlaylist) {
		// User is not premium
		if (!getIsSubscriber()) {
			if (getCurrentStorage() + newPlaylist.getStorage() >= 200) {
				System.out.println("Playlist nao adicionada. Limite de armazenamento gratuito alcançado. Seja assinante e obtenha muito mais vantagens!");
			}
			else if (newPlaylist.getHigherDurationSong().getDuration() < 60) {
				this.playlists.add(newPlaylist);
				incCurrentStorage(newPlaylist.getStorage());
			}
			else {
				this.playlists.add(newPlaylist);
				incCurrentStorage(newPlaylist.getStorage());
			}
		}
		// Premium user
		else {
			if (getPlaylists().size() + newPlaylist.getStorage() < 900 || newPlaylist.getHigherDurationSong().getDuration() < 60) {
				this.playlists.add(newPlaylist);
				incCurrentStorage(newPlaylist.getStorage());
			}
			else {
				System.out.println("Playlist nao adicionada. Limite de 900MB de armazenamento alcancado.");
			}
		}
	}
	
	public void removePlaylist(Playlist deletedPlaylist) {
		this.playlists.remove(deletedPlaylist);
		decCurrentStorage(deletedPlaylist.getStorage());
	}
	
	public void transferPlaylist(Playlist tranferedPlaylist, User newOwner) {
		newOwner.addPlaylist(tranferedPlaylist);
		if (newOwner.getPlaylists().contains(tranferedPlaylist)) {
			this.playlists.remove(tranferedPlaylist);
			decCurrentStorage(tranferedPlaylist.getStorage());
		}
	}
	
	public void showPlaylists() {
		System.out.println("User: " + getName());
		System.out.println("Number of Playlists: " + getPlaylists().size());
		for (int i = 0; i < playlists.size(); i++) {
			System.out.println("Playlist " + (i+1) + ": " + playlists.get(i).getName());
			System.out.println("\tNumber of songs: " + playlists.get(i).getSongs().size());
			System.out.println("\tSongs: ");
			for (int k = 0; k < playlists.get(i).getSongs().size(); k++) {
				System.out.println("\t- " + playlists.get(i).getSongs().get(k).getName() + " - " + playlists.get(i).getSongs().get(k).getArtist() + ";");
			}
		}
	}

	public void showInformation() {
		System.out.println("Nome: " + getName());
		System.out.println("CPF: " + getCpf());
		if (getBirthdate() != null)
			System.out.println("Data de nascimento: " + getBirthdate());
		if (getGender() != null)
			System.out.println("Genero: " + getGender());
		System.out.print("Assinante: ");
		if (getIsSubscriber())
			System.out.println("premium");
		else
			System.out.println("free");
		System.out.print("Espaco de armazenamento utilizado: " + getCurrentStorage());
		if (getIsSubscriber())
			System.out.println("/900");
		else
			System.out.println("/200");
	}

}
