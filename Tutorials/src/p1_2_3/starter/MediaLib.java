package p1_2_3.starter;

import java.util.ArrayList;

public class MediaLib {
	
	/* 	MEDIA LIB - PARSING MORE DATA (by name)
	 * 
	 * 	This lesson teaches you the basics of storing and reading data.
	 * 	We have been working with these same principles for a while now, using arrays and loops to read/store text data.
	 * 	Specifically, you will find a song by it's name and print the song (and its data) to console.
	 */
	
	/* Usable Array Lists: */
	public static ArrayList<Song> songs = new ArrayList<Song>();
	public static ArrayList<Movie> movies = new ArrayList<Movie>(); 
	public static ArrayList<Book> books = new ArrayList<Book>(); 

	/* Main Method: */
	public static void main(String args[]){
		
	/* ADD SONGS TO SONG ARRAY */
		// You may edit/add to these if you wish:
		
		songs.add(new Song("Song 1", 8, 0.99, false));
		songs.add(new Song("Song 2", 8, 0.99, false));
		songs.add(new Song("Song 3", 8, 0.99, false));
		
		
	/* FIXING ERRORS */
		// You may use this area for the "mistakes" section:
		// Copy and edit the code as PLTW 1.2.3 says.
		
		
		
		
		
		
		
	/* PARSING DATA */
		// First lets print the songs in order.
		// Write a For-Each loop to print the songs to console.
		
		
		
		
		
		
		
		// Now lets print them in reverse!
		// I do not know of a way to use a For-Each in reverse, so we will need to use and index loop.
		// Hint: Change the domain of the loop (ie. i = songs.size()-1; i >= 0; i--; ).
		
		
		
		
		
		
		
		// Great! Now lets write a loop to find a song by it's title.
		// This is more text parsing similar to what we have done before.
		// Create a loop to parse your songs for their name, then print the found song (and data) to console.
		// Hint: Loop through the songs and see if the song.getName() is equal to songName;
		
		String songName = ""; // Change to the title of a song.
		
		
		
		
		
		
		
		
		// DONE :D 
		
	}

}
