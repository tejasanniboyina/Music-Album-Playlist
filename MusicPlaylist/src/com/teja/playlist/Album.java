package com.teja.playlist;

import java.util.ArrayList;
import java.util.LinkedList;


public class Album {
	String name;
	String artist;
	public ArrayList<Song> songs;
	
	public Album(String name, String artist) {
		
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
	
	public Album(){
		
	}
	
	public boolean addSong(String title, double duration) {
		if(findSong(title)==null) {
			songs.add(new Song(title,duration));
			System.out.println(title + " successfully added to the list");
			return true;
		}
		else {
			System.out.println("Song with name " + title +" already in the list");
			return false;
		}
	}
	
	public Song findSong(String title)
	{
		for(Song checkedSong : songs ) {
			if(checkedSong.getTitle().equals(title)) {
				return checkedSong;
			}
		}
		return null;
	}
	
	
	public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList) {
		int index = trackNumber - 1;
		if(index > 0 && index <= this.songs.size()) {
			playList.add(this.songs.get(index));
			return true;
		}
		System.out.println("This album does not have a song with this track number : " + trackNumber);
		return false;
	}
	
	public boolean addToPlaylist(String title, LinkedList<Song> playList) {
		for(Song checkedSong : this.songs) {
			if(checkedSong.getTitle().equals(title)) {
				playList.add(checkedSong);
				return true;
			}
		}
		System.out.println("This album does not have the song "+ title);
		return false;
		
	}
	 
	
	
}
