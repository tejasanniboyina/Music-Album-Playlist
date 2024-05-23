package com.teja.playlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	private static ArrayList<Album> albums = new ArrayList<Album>();

	
	public static void main(String[] args) {
		
		
		Album album  = new Album("Album1", "AC/DC");
		// creating album 1
		album.addSong("TNT",4.5);
		album.addSong("Highway to Hell",3.5);
		album.addSong("Thunder Struck",5.0);
		albums.add(album);

		//creating album 2
		album = new Album("Album2", "Eminem");
		album.addSong("Venom",4.5);
		album.addSong("Rap God",3.5);
		album.addSong("Not Afraid",4.5);
		albums.add(album);

		LinkedList<Song> playList1 = new LinkedList<>();
		albums.get(0).addToPlaylist("TNT", playList1);
		albums.get(0).addToPlaylist("Highway to Hell", playList1);

		albums.get(1).addToPlaylist("Venom", playList1);

		albums.get(1).addToPlaylist("Rap God", playList1);


		play(playList1);

	}

	private static void play(LinkedList<Song> playList) {
		Scanner scanner = new Scanner(System.in);
		
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playList.listIterator();
		
		if(playList.size()==0) {
			System.out.println("This play list hs no songs");
		}
		else {
			System.out.println("Now playing "+listIterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch(action) {
			case 0:
				System.out.println("playlist complete");
				quit = true;
				break;
			case 1:
				if(!forward) {
					if(listIterator.hasNext()) {
						listIterator.next();
					}
					forward = true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Now playing "+listIterator.next().toString());
				}else {
					System.out.println("No song available, reached to the end of the list");
					forward = false;
				}
				break;
			case 2:
				if(forward ) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward = false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now playing" + listIterator.previous().toString());
				}else {
					System.out.println("We are at the first song");
					forward = false;
				}
				break;
			case 3:
				if(forward) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing "+listIterator.previous().toString());
						forward = false;
					}
					else {
						System.out.println("We are at the start of the list");
					}
				}
				else {
					if(listIterator.hasNext()) {
						System.out.println("Now playing" +listIterator.next().toString());
						forward = true;
					}else {
						System.out.println("We have reached the end of the list");

					}
				}
				break;
			case 4:
				printList(playList);
				break;
			
			case 5:
				if(playList.size() > 0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now playing "+listIterator.next().toString());
						forward = true;
					}else {
						if(listIterator.hasPrevious()) {
							System.out.println("Now playing "+listIterator.previous().toString());
						}
					}
				}
				break;
			case 6:
				printMenu();
				break;
			}
			
		}
		
	}
	
	private static void printMenu() {
		System.out.println("Available options\n press");
		System.out.println("0 - to quit\n"+
				"1 - to next song\n"+
				"2 - to play previous song\n"+
				"3 - to replay the current song\n"+
				"4 - list of all songs\n"+
				"5 - delete current song\n"+
				"6 - print all availavle options");
	}
	
	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> iterator = playList.iterator();
		System.out.println("-----------------");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("-----------------");

	}
}
