package nebulous.scifigenV2;

import java.util.Scanner;

public class NameGeneratorV2 {
	
	/* Sci-fi Name Generator V2.0
	 * 
	 * Code by Ben Ratcliff for AP COMP-SCI APPS
	 * 
	 * Algorithms:
	 *  - Name :
	 *  	- For each letter in the input name, I get the (absolute value of) the indexed value in ALPHABET (ie the location) of the letter, then add
	 *  	the current index of letter in name, resulting in the output letter.
	 *  		( l[i] = A[abs(A[l] + l[i])] )
	 *  
	 *  	- For every 3rd letter, replace with a vowel using:
	 *  		( l[i] = v.charAt(abs(v.length - (i / v.length) - 1))
	 *  
	 *  	- I then add a space at ( name.length / 2 ) - 1
	 *  
	 *  - Planet :
	 *  	- For each letter in the name's length divided by 2, I get the (absolute value of) the length of the planet name, then add the index of the letter in
	 *  	planet name, resulting in the output letter.
	 *  		( l[i] = A[abs(A[l] + l[i])] )
	 *  
	 *  	- I then add the remainder of the planet name length divided by 12 as a planet number.
	 */
	
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	public static final String VOWELS = "aeiou";

	public static void main(String[] args) {
		
		// INPUT NAME -----------------------------------------------
		
		System.out.print("Enter your name: ");
		String inputName = getInput();
		
		// GENERATE NAME ---------------------------------------------
		
		char[] letters = inputName.toCharArray();
		
		for(int i = 0; i < letters.length; i++){
			if(letters[i] != " ".charAt(0))
				letters[i] = ALPHABET.charAt(Math.abs(ALPHABET.indexOf(letters[i]) - i));
			else letters[i] = ALPHABET.charAt(i);
			if(i % 3 == 1) letters[i] = VOWELS.charAt(Math.abs(VOWELS.length() - (i / VOWELS.length()) - 1));
		}
		
		int spaceLocation = (letters.length - letters.length / 2) - 1;
		
		letters[spaceLocation] = " ".charAt(0);
		letters[(spaceLocation) + 1] = Character.toUpperCase(letters[spaceLocation + 1]);
		letters[0] = Character.toUpperCase(letters[0]);
		
		String outputName = new String(letters);
		
		// GENERATE PLANET --------------------------------------------
		
		char[] planetName = new char[(inputName.length() / 2) + 4];
		
		for(int i = 0; i < planetName.length; i++){
			planetName[i] = ALPHABET.charAt(Math.abs(planetName.length - i));
			if(i % 3 == 1) planetName[i] = VOWELS.charAt(i % 5);
		}
		
		planetName[0] = Character.toUpperCase(planetName[0]);
		
		String outputPlanet = new String(planetName);
		outputPlanet += "-" + (outputPlanet.length() % 12);
		
		// PRINT FINAL ------------------------------------------------
		
		System.out.print("Your sci-fi name is: ");
		System.out.println(outputName + " of the planet " + outputPlanet);
		
	}
	
	public static String getInput(){
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
}
