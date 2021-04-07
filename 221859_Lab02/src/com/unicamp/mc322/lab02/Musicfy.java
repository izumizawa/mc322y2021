package com.unicamp.mc322.lab02;

public class Musicfy {

	public static void main(String[] args) {
		User user1 = new User("Marcos Paulo", "777.777.777-77");
		User user2 = new User("Cookiezi", "111.111.11-11");
		
		Song song1 = new Song("Seven Nation Army", "Rock", "The White Stripes", 120);
		Song song2 = new Song("Crazy Train", "Rock", "Ozzy Osbourne", 100);
		Song song3 = new Song("Feels", "Pop", "Calvin Harris", 640);
		Song song4 = new Song("Roar", "Pop", "Katy Perry", 420);
		Song song5 = new Song("Anima", "Hardcore", "Xi", 152);
		Song song6 = new Song("Freedom Dive", "Hardcore", "Xi", 520);
		Song song7 = new Song("Teo", "Hardcore", "Omoi", 402);
		Song song8 = new Song("Sleepwalking", "Metalcore", "Bring Me The Horizon", 623);
		
		Playlist rockPlaylist = new Playlist("Awesome Rock Songs", "Rock");
		rockPlaylist.addSong(song1);
		rockPlaylist.addSong(song2);
		
		Playlist osuPlaylist = new Playlist("Osu Memories", "hardcore");
		osuPlaylist.addSong(song5);
		osuPlaylist.addSong(song6);
		osuPlaylist.addSong(song7);
		
		Playlist metalcorePlaylist = new Playlist("Best of Metalcore", "Metalcore");
		metalcorePlaylist.addSong(song8);
		
		Playlist popPlaylist = new Playlist("Popular Songs", "Pop");
		popPlaylist.addSong(song3);
		popPlaylist.addSong(song4);

		user1.addPlaylist(rockPlaylist);
		user1.addPlaylist(metalcorePlaylist);
		user2.addPlaylist(osuPlaylist);
		user2.addPlaylist(popPlaylist);
		
		user1.showPlaylists();
		user2.showPlaylists();
		System.out.println("");
        user2.showInformation();
        
        Song asong1 = osuPlaylist.play();
		System.out.println("Tocando: " + asong1.getSongName() + " by " + asong1.getArtist());
        Song asong2 = osuPlaylist.play();
        Song asong3 = osuPlaylist.play(true);
		System.out.println("Tocando aleatório: " + asong3.getSongName() + " by " + asong3.getArtist());
		
		System.out.println("Artista com mais músicas na playlist " + popPlaylist.getPlaylistName() + " é "+ popPlaylist.getArtistWithMoreSongs());
		System.out.println("Média de duração em segundos de playlist " + popPlaylist.getPlaylistName() + " é "+ popPlaylist.getAverageSongsDuration());
		System.out.println("Música com menor duração na playlist " + popPlaylist.getPlaylistName() + " é "+ popPlaylist.getLowerDurationSong().getSongName() + " de " + popPlaylist.getLowerDurationSong().getArtist());
	}

}
