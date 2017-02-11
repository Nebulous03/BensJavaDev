package test;

public class Main {
	
	public static void main(String[] args) {
		
		int x = 0;
		
		for(int i = 0; i < 10000; i++) {
			
			if(x == 0) {
				System.out.println("Hello World!");
				x++;
			}
			
			if(x == 1) {
				System.out.println("Hello World 2!");
			}
		
		}
	}

}
