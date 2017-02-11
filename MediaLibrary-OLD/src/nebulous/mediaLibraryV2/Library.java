package nebulous.mediaLibraryV2;

import java.util.ArrayList;

public class Library {
	
	private ArrayList<Song> songs = new ArrayList<Song>();
	private ArrayList<Movie> movies = new ArrayList<Movie>();
	private ArrayList<Book> books = new ArrayList<Book>();
	
	public void addSong(Song song){
		songs.add(song);
	}
	
	public void addMovie(Movie movie){
		movies.add(movie);
	}
	
	public void addBook(Book book){
		books.add(book);
	}

	public ArrayList<Song> getSongs() {
		return songs;
	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}
	
	public void populateFromFile(String file){
		String text[] = MediaFile.readString().split("|");
		for(int i = 0; i < text.length; i += 3){
			
		}
 	}

}
