package testing;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		
		
		// Q1 :
		
		for (int k = 0; k < 20; k += 2) {
			if(k % 3 == 1) {
				System.out.println(k + ", ");
			}
		}
		
		// Q2:
		
		List<String> animals = new ArrayList<String>();
		
		animals.add("dog");
		animals.add("cat");
		animals.add("snake");
		animals.set(2, "lizard");
		animals.add(1, "fish");
		animals.remove(3);
		
		System.out.println(animals);
		
		// Q5:
		
		for (int j = 1; j <= 5; j++) {
			for (int k = 5; k >= j; k--) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
}
