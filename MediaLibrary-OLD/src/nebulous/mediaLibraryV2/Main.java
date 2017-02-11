package nebulous.mediaLibraryV2;

public class Main {

	public static Library library = new Library();
	
	public static void main(String[] args) {
		library.addBook(new Book("Amazing Book!", 9));
		library.addBook(new Book("Amazing Book V2!", 2));
		library.addMovie(new Movie("Amazing Movie!", 8));
		library.addSong(new Song("Epic Song!", 3));
		printLibrary();
		
		MediaFile.writeString("Hei");
		MediaFile.saveAndClose();
		
	}
	
	public static void printLibrary(){
		
		for(Book book : library.getBooks()){
			System.out.println("Book: " + book.getName() + " " + book.getRating() + "/10");
		}
		
		for(Movie movie : library.getMovies()){
			System.out.println("Movie: " + movie.getName() + " " + movie.getRating() + "/10");
		}
		
		for(Song song : library.getSongs()){
			System.out.println("Song: " + song.getName() + " " + song.getRating() + "/10");
		}
		
	}

}
