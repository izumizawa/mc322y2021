package com.unicamp.mc322.lab06;

import java.util.ArrayList;
import java.util.List;

public class Musicfy2 {

	public static void main(String[] args) {
		User user1 = new User("Rachel", "123.123.123-12");
		User user2 = new User("Marcel", "123.456.123-99");
		user1.setBirthdate("10/04/1998");
		user2.setGender("Male");
		user2.setIsSubscriber(true);
		
		user1.showInformation();
		user2.showInformation();
		
		Song song1 = new Song("Alô Ambev", "Sertanejo", "Zé Neto & Cristiano", 230);
		Song song2 = new Song("Feels", "Pop", "Calvin Harris", 640);
		Song song3 = new Song("Roar", "Pop", "Katy Perry", 420);
		Song song4 = new Song("Anima", "Hardcore", "Xi", 152);

		Video video1 = new Video("Alô Ambev", "Sertanejo", "Zé Neto & Cristiano", 230, 140, 921600);
		PodcastChannel podcastChannel1 = new PodcastChannel("Hipsters.tech", "Tech", "Alura", 3600, 10);
		
		List<Song> songs = new ArrayList<Song>();
		songs.add(song1);
		songs.add(song4);
		Album album1 = new Album("Hits", "Pop", "", 123, songs);
		
		Playlist rockPlaylist = new Playlist("Awesome Rock Songs");
		rockPlaylist.addSong(song1);
		rockPlaylist.addSong(album1);
		user1.addPlaylist(rockPlaylist);
		
		Playlist osuPlaylist = new Playlist("Osu Memories");
		osuPlaylist.addSong(video1);
		osuPlaylist.addSong(podcastChannel1);
		user1.addPlaylist(osuPlaylist);
		
		Playlist popPlaylist = new Playlist("Popular Songs");
		popPlaylist.addSong(song3);
		popPlaylist.addSong(song2);
		user2.addPlaylist(popPlaylist);

		Song asong1 = osuPlaylist.play();
		System.out.println("\n - Tocando: " + asong1.getName() + " by " + asong1.getArtist());
        Song asong3 = osuPlaylist.play(true);
		System.out.println("\n - Tocando aleatório: " + asong3.getName() + " by " + asong3.getArtist());
		
		System.out.println("\n - Artista com mais músicas na playlist " + popPlaylist.getName() + " é "+ popPlaylist.getArtistWithMoreSongs());
		System.out.println("\n - Média de duração em segundos de playlist " + popPlaylist.getName() + " é "+ popPlaylist.getAverageSongsDuration());
		System.out.println("\n - Música com menor duração na playlist " + popPlaylist.getName() + " é "+ popPlaylist.getLowerDurationSong().getName() + " de " + popPlaylist.getLowerDurationSong().getArtist());
	
		System.out.println("---------------------");
		
		user1.showPlaylists();
		user2.showPlaylists();
	}

}

