package nebulous.magpie;

import java.util.Scanner;

public class MagpieMain {
	
	public static boolean shouldClose = false;
	public static String currentString = "";

	public static void main(String[] args) {
		
		/* ~ Ask Name ~ */
		print("Hello There! What is your name?");
		String name = getInput();
		
		/* ~ Ask Condition ~ */
		print("Hey there " + name + "! How are you doing today?");
		currentString = getInput().toUpperCase();
		parseInput(currentString);
		
		while(!shouldClose){
			currentString = getInput().toUpperCase();
			parseInput(currentString);
		}
	}
	
	public static void parseInput(String input){
		String text[] = input.split(" ");
		parseType(text);
	}
	
	public static void parseType(String[] text){
		switch(text[0]){
		case "EXIT":
			shouldClose = true; 
			print("Goodbye for now!");
			break;
		case "WHAT":
			parseQuestion(text); break;
		case "WHO":
			parseQuestion(text); break;
		case "I":
			parseIStatement(text); break;
		case "":
			print(""); break;
		default:
			print("Im not sure I know what you mean..."); break;
		}
	}
	
	public static void parseIStatement(String[] text){
		switch(text[1]){
		case "AM":
			parseFeeling(text); break;
		case "FEEL":
			parseFeeling(text); break;
		case "LIKE":
			parseLike(text); break;
		case "LOVE":
			parseLike(text); break;
		}
	}
	
	public static void parseFeeling(String[] text){
		boolean end = false;
		for(int i = 0; i < text.length; i++){
			if(!end)
				switch(text[i]){
				/* GOOD */
				case "GOOD": print("Great! Im glad you feel good!"); break;
				case "GREAT": print("Great! Im glad you feel good!"); break;
				case "NICE": print("Great! Im glad you feel good!"); break;
				case "FANTASIC": print("Great! Im glad you feel good!"); break;
				/* SAD */
				case "SAD": print("Awww.. Why are you sad?"); break; //TODO: set next statement
				/* BAD */
				case "BAD": print("Awww.. Why do you feel bad?"); break; 
				case "HORRIBLE": print("Awww.. Why do you feel bad?"); break;
				/* OTHER */
				case "NOT": 
					try {
						for(int j = 0; j < text.length; j++){
							switch(text[j]){
							case "GOOD": print("Awww.. Why are you sad?"); end = true; break;
							case "BAD": print("That's Great! Im glad you aren't bad good!"); end = true; break;
							}
						}
					} catch (Exception e) {
						print("Not What?");
						end = true;
				}
			}
		}
	}
	
	public static void parseQuestion(String[] text){
		
	}

	public static void parseLike(String[] text){
		String line = currentString;
		line = line.replace(text[0] + " " + text[1] + " ", "");
		print("Awesome! I " + text[1].toLowerCase() + " " + line.toLowerCase() + " too!");
	}

	public static String getInput(){
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
	
	public static void print(Object o){
		System.out.println(o);
	}
}
