package nebulous.scifigen;

import java.util.Random;

public class NameGenerator {

	public static Random rand = new Random();
	public static String finalName = "";
	public static char[] vowels = {97, 101, 105, 111, 117};

	public static final String myName = "zzz zzz";
	
	public static void main(String[] args) {
		System.out.println("Random Name: " + generateName());
		System.out.println("Generated Name: " + generateName(myName));
	}
	
	public static String generateName(){
		char[] first = new char[rand.nextInt(5) + 3];
		char[] last = new char[rand.nextInt(7) + 3];
		
		for(int i = 0; i < first.length; i++){
			first[i] = getCharFromInt(rand.nextInt(25));
			if(i % 2 == 0) first[i] = vowels[rand.nextInt(5)];
		}
		
		for(int i = 0; i < last.length; i++){
			last[i] = getCharFromInt(rand.nextInt(25));
			if(i % 2 == 0) last[i] = vowels[rand.nextInt(5)];
		}
		
		first[0] = Character.toUpperCase(first[0]);
		last[0] = Character.toUpperCase(last[0]);
		
		return String.copyValueOf(first) + " " + String.copyValueOf(last);
	}
	
	public static String generateName(String name){
		String[] names = name.split(" ");
		
		char[] first = names[0].toCharArray();
		char[] last = names[1].toCharArray();
		
		char[] newFirst = new char[first.length];
		char[] newLast = new char[last.length];
		
		for(int i = 0; i < first.length; i++){
			boolean isVowel = false;
			
			for(int j = 0; j < vowels.length; j++)
				if(first[i] == vowels[j]) isVowel = true;
			
			if(!isVowel) newFirst[i] = (char)(first[i] + last.length);
			else{
				newFirst[i] = first[i]; // Do something cool with vowels
			}
		}
		
		
		for(int i = 0; i < last.length; i++){
			boolean isVowel = false;
			
			for(int j = 0; j < vowels.length; j++)
				if(last[i] == vowels[j]) isVowel = true;
			
			if(!isVowel) newLast[i] = (char)(last[i] + first.length);
			else{
				newLast[i] = last[i]; // Do something cool with vowels
			}
		}
		
		return String.copyValueOf(newFirst) + " " + String.copyValueOf(newLast);
	}
	
	public static char getCharFromInt(int num){
		if(num >= 26 && num >= 0) System.err.println("Unable to read int to char: " + num);
		else return ((char)(num + 97));
		return 0;
	}

}
