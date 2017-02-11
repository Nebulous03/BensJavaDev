package nebulous;

public class Main {
	
	private static String names[] = {"Ben","Alex","Will","Tony","Laura"};
	private static Song songs[] = {new Song("Song1"), new Song("Song2"), new Song("Song3")};
	
	public static void main(String[] args){
		
		System.out.println("-----------------------------");
		
		/* Indexed For-Loop */
		for(int i = 0; i < names.length; i++){
			System.out.println(names[i]);
		}
		
		System.out.println("-----------------------------");
		
		/* Reverse Indexed For-Loop */
		for(int i = names.length - 1; i >= 0; i--){
			System.out.println(names[i]);
		}
		
		System.out.println("-----------------------------");
		
		/* For-Each-Loop */
		for(String name : names){
			System.out.println(name);
		}
		
		System.out.println("-----------------------------");
		
		/* For-Each-Loop */
		for(Song song : songs){
			System.out.println(song.getTitle());
		}
		
		System.out.println("-----------------------------");
	}

}
