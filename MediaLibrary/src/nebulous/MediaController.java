package nebulous;

import java.util.ArrayList;

import nebulous.mediaLib.Library;
import nebulous.mediaLib.Song;

public class MediaController {
	
	/* 	MEDIA CONTROLLER CLASS - ANSWER KEY
	 * 
	 *  - This class is designed to read and write song data from a hard drive.
	 *  - This class will write your song data from RAM to a text file
	 *    on your hard drive then read it back into RAM to display
	 *    in the console.
	 *    
	 */


	public static void main(String[] args) {
		
		// First gain access to your songs.
		// Either create songs here or create an instance of your ArrayList from MediaLib
		
		
		
		ArrayList<Song> songs = new ArrayList<Song>();
		
		songs.add(new Song("Song #1", 1, 0.99));
		songs.add(new Song("Song #2", 4, 0.98));
		songs.add(new Song("Song #3", 12, 0.97));
		
		
		
		// Create a for loop that will write your song data to "mymedia.txt"
		// Use a for loop to save the data to disk using MediaWriter.write();
		
		
		
		for(Song song : songs){
			MediaWriter.write(song.getName() + ";" + song.getRating() + ";" + song.getPrice() + ";");
		}
		
		
		
		// Now create a method to read the song data from "mymedia.txt" back to RAM
		// Use a for loop to read the data to a string, split it, then print the data to console.
		// Use MediaWriter.read(); to read the text file to a string.
		// The data must be parsed in the same way it was saved.
		
		
		
		String text[] = MediaWriter.read().split(";");
		
		for(int i = 0; i < text.length; i += 3){ // Incremented by 3 (the data index count per song)
			System.out.println(text[i] + "," + text[i + 1] + "," + text[i + 2]);
		}
		
		
		
		// DONE! :D
		
	}

}
