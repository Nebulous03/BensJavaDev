package nebulous.mediaLib;


public class Main {

	public static Library library = new Library();
	
	public static void main(String[] args) {
		
//		library.loadFromFile("mymedia.txt");
		
		library.addMovie(new Movie("Ben is the best", 5.0, 12.00));
		library.addMovie(new Movie("Ben is even better", 10.1, 360.00));
		library.addSong(new Song("This song is AMAZING", 8.1, 0.89));
		library.addSong(new Song("This song is MORE AMAZING", 9.99999, 0.99));
		library.addBook(new Book("Im a book!", 12.5, 12345.00));
		
		library.saveToFile("mymedia.txt");
		
		//Printing Library:
		
		printLibrary();
		
		double totalSongCost = 0;
		double totalMovieCost = 0;
		double totalBookCost = 0;
		
		for(Song song : library.getSongs())
			totalSongCost += song.getPrice();
		for(Movie movie : library.getMovies())
			totalMovieCost += movie.getPrice();
		for(Book book : library.getBooks())
			totalBookCost += book.getPrice();
		
		double averageSongCost = totalSongCost / library.getSongs().size();
		double averageMovieCost = totalMovieCost / library.getMovies().size();
		double averageBookCost = totalBookCost / library.getBooks().size();
		
		System.out.println("Average Song Cost: " + "$" + averageSongCost);
		System.out.println("Average Movie Cost: " + "$" + averageMovieCost);
		System.out.println("Average Book Cost: " + "$" + averageBookCost);
		
		
		//Use finders:
		
		System.out.println("----------------------------");
		
		System.out.println("Finding \"This song is AMAZING\"...");
		if(library.findSong("This song is AMAZING") != null) 
			System.out.println("FOUND! : " + library.findSong("This song is AMAZING").getName());
		
		System.out.println("----------------------------");
		
		
	}
	
	public static void printLibrary(){
		
		for(Book book : library.getBooks()){
			System.out.println(
					"Book: \t- Title: " + book.getName() + "\n\t" + 
							"- Rating: " + book.getRating() + "/10\n\t"
							+"- Price: $" + book.getPrice() + "\n");
		}
		
		for(Movie movie : library.getMovies()){
			System.out.println(
					"Movie: \t- Title: " + movie.getName() + "\n\t" + 
							"- Rating: " + movie.getRating() + "/10\n\t"
							+"- Price: $" + movie.getPrice() + "\n");
		}
		
		for(Song song : library.getSongs()){
			System.out.println(
					"Song: \t- Title: " + song.getName() + "\n\t" + 
							"- Rating: " + song.getRating() + "/10\n\t"
							+"- Price: $" + song.getPrice() + "\n");
		}
		
	}

}
