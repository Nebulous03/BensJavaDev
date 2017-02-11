package nebulous.crack;

public class MainClass {
	
	public static int [] original_numbers = new int [] {4, 10, 14, /* */ 2, 21, 10, 23, 22, 16, /* */ 7, 1, 3, 18, 8, /* */ 11, 11, /* */ 18, 8, 7, 17};
	public static byte[] original_bytes   = new byte[] {4, 10, 14, /* */ 2, 21, 10, 23, 22, 16, /* */ 7, 1, 3, 18, 8, /* */ 11, 11, /* */ 18, 8, 7, 17};
	
	public static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" .toCharArray();
	
	public static void main(String[] args) {
		
		/*
		 *  NOTES
		 * 
		 *  Discoveries:
		 *  
		 *  Factor 4 substitution cipher
		 *  
		 *  Hints:
		 *  
		 *  Factor 1 
		 *  	- Ceasar based on letter count
		 *  
		 */
		
		System.out.println(runStageOneCipher());
		runShiftCiphers();
		
	}
	
	public static char[] runStageOneCipher() {
		
		int word1length = 3;
		int word2length = 6;
		int word3length = 5;
		int word4length = 2;
		int word5length = 4;
		
		int word1pointer = 0;
		int word2pointer = 3;
		int word3pointer = 9;
		int word4pointer = 14;
		int word5pointer = 16;
		
		String wordOne   = toAlphabet((shiftLetters(original_numbers, word5length))).substring(word1pointer, word1length); 
		String wordTwo   = toAlphabet((shiftLetters(original_numbers, word1length))).substring(word2pointer, word2pointer + word2length); 
		String wordThree = toAlphabet((shiftLetters(original_numbers, word2length))).substring(word3pointer, word3pointer + word3length); 
		String wordFour  = toAlphabet((shiftLetters(original_numbers, word3length))).substring(word4pointer, word4pointer + word4length); 
		String wordFive  = toAlphabet((shiftLetters(original_numbers, word4length))).substring(word5pointer, word5pointer + word5length); 
		
		return (wordOne + " " + wordTwo + " " + wordThree + " " + wordFour + " " + wordFive).toCharArray();
	}
	
	public static void runShiftCiphers() {
		
			System.out.println("\n Original from ints: " + toAlphabet(shiftLetters(original_numbers, 0)));
		
		/* ---------------------------------------------
		   |     ATTEMPT #1 - Conversion to Letters    |
		   --------------------------------------------- */
			
			System.out.println("\n Conversion to Alphebet by index-shift\n");
			for(int i = 0; i < 26; i++) {
				System.out.print("Shift: " + i + " - ");
				System.out.println(toAlphabet(shiftLetters(original_numbers, i)));
			}
		
		/* ----------------------------------------------------------
		   |     ATTEMPT #2 - Conversion to Letters by a factors    |
		   ---------------------------------------------------------- */
		
			int FACTOR = 4;
			
			System.out.println("\nConversion to Alphebet by index-shift, factor of " + FACTOR + "\n");
			
			for(int i = 0; i < 26; i++) {
				
				int[] shifted = shiftLetters(original_numbers, i);
				
				for(int j = 0; j < FACTOR; j++) {
					System.out.print("Shift " + i + ", Factor " + (j + 1) + " - ");
					shifted = shiftLetters(shifted, i);
					System.out.println(toAlphabet(shiftLetters(shifted, i)));
				}
				
				System.out.print("\n");
			}
			
		/* ---------------------------------------------------------------------
		   |     ATTEMPT #3 - Conversion to Letters by reversal and factors    |
		   --------------------------------------------------------------------- */
			
			System.out.println("Conversion to Alphebet by index-shift and reversal, factor of " + FACTOR + "\n");
			
			for(int i = 0; i < 26; i++) {
				
				int[] shifted = reverseLetters(shiftLetters(original_numbers, i));
				
				for(int j = 0; j < FACTOR; j++) {
					System.out.print("Reversed Shift " + i + ", Factor " + (j + 1) + " - ");
					shifted = shiftLetters(shifted, i);
					System.out.println(toAlphabet(shiftLetters(shifted, i)));
				}
				
				System.out.print("\n");
			}
			
		/* ---------------------------------------------------------------
		   |     ATTEMPT #4 - Conversion to Letters by complex ciphers   |
		   --------------------------------------------------------------- */
			
			// Abandoned.. 
			
	}
	
	public static int[] shiftLetters(int[] char_ints, int shift) {
		int[] result = new int[char_ints.length];
		
		for(int i = 0; i < char_ints.length; i++) {
			
			int letter = char_ints[i] + shift - 1;
			if(letter >= 26) letter -= 26;
			if(letter < 0) letter += 26;
			
			result[i] = letter;
		}
		
		return result;
	}
	
	public static int[] reverseLetters(int[] char_ints) {
		int[] result = new int[char_ints.length];
		
		for(int i = 0; i < char_ints.length; i++) {
			result[i] = Math.abs(char_ints[i] - 25);
		}
		
		return result;
	}
	
	public static String toAlphabet(int[] char_ints) {
		char[] result = new char[char_ints.length];
		
		for(int i = 0; i < char_ints.length; i++) {
			result[i] = alphabet[char_ints[i]];
		}
		
		return String.copyValueOf(result);
	}

}
