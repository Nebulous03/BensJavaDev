package nebulous.magpieV2;

import java.util.Scanner;

public class MagpieMain {
	
	/* ~ User's Name ~ */
	public static String name = "";
	
	/* ~ Debug Mode - Displays sentence structure ~ */
	public static boolean debug = false; // DEBUG
	public static boolean slowType = false;
	
	/* ~ Boolean States ~ */
	public static boolean isQuestion = false;
	public static boolean isStatement = false;
	
	public static boolean isGreating = false;
	public static boolean isYes = false;
	public static boolean isNo = false;
	public static boolean isIntrest = false;
	public static boolean isUnsure = false;
	
	/* ~ Known Words ~ */
	public static String[] questionWords = {"?", "WHO", "WHAT", "WHERE", "WHY", "WHEN"};
	public static String[] statementWords = {"."};
	public static String[] greatingWords = {"HI", "HELLO", "HEY", "GREATINGS"};
	public static String[] yesWords = {"Y", "YES", "YUP", "RIGHT", "CORRECT"};
	public static String[] noWords = {"N", "NO", "NOPE", "WRONG", "INCORRECT"};
	public static String[] goodStates = {"GOOD", "GREAT", "NICE", "WELL", "FANTASTIC"};
	public static String[] badStates = {"BAD", "HORRIBLE", "SAD", "POOR"};
	public static String[] intrestWords = {"LIKE", "LOVE", "ADORE"};
	public static String[] insultWords = {"STUPID", "ANNOYING", "BORING", "LAME"};
	public static String[] complementWords = {"NICE", "SMART", "COOL", "AMAZING"};
	
	public static String[] keyWords = {"COMPUTER"};

	/* ~ Should Exit ~ */
	public static boolean exit = false;
	
	/* ~ Current Parsing String ~ */
	public static String INPUT = "";
	
	public static void main(String[] args) {
		
		/* ~ Ask Name ~ */
		println("Hello There! What is your name?");
		name = getInput();
		
		/* ~ Ask Condition ~ */
		println("Hey there %NAME! How are you doing today?");
		INPUT = getInput().toUpperCase();
		parseInput(INPUT);
		
		/* ~ Input Loop ~ */
		while(!exit){
			INPUT = getInput().toUpperCase();
			parseInput(INPUT);
		}
	}
	
	public static void parseInput(String input){
		
		// PARSE TYPE -------------------------------------
		
		for(int i = 0; i < questionWords.length; i++)
			if(input.contains(questionWords[i])) isQuestion = true;
		
		for(int i = 0; i < statementWords.length; i++)
			if(input.contains(statementWords[i])) isStatement = true;
		
		if(isQuestion && isStatement) isStatement = false;
		if(!isQuestion && !isStatement) isStatement = true;
		
		// PARSE MEANING -----------------------------------
		
		for(int i = 0; i < greatingWords.length; i++)
			if(input.contains(greatingWords[i])) isGreating = true;
		
		for(int i = 0; i < yesWords.length; i++)
			if(input.contains(yesWords[i])) isYes = true;
		
		for(int i = 0; i < noWords.length; i++)
			if(input.contains(noWords[i])) isNo = true;
		
		for(int i = 0; i < intrestWords.length; i++)
			if(input.contains(intrestWords[i])) isIntrest = true;
		
		// PARSE RESOLVE -----------------------------------
		
		if(((isGreating || isYes) || isNo) && isQuestion) isUnsure = true;
		if(isYes && isNo && !isGreating) isUnsure = true;

		if(debug){
		
			if(isQuestion) print("q");
			if(isStatement) print("s");
			if(isGreating) print("g");
			if(isYes) print("y");
			if(isNo) print("n");
			if(isIntrest) print("i");
			
			print("\n");
		
		}
		
		println(parseResponse());
		reset();	
	}
	
	public static String parseResponse(){
		
		if(isGreating){
			print(Responses.getGreeting());
			isGreating = false;
		}
		
		if(isQuestion){
			if(INPUT.contains("YOU")){
				
				if(INPUT.contains("COMPUTER")){
					return("I am indeed. Although I prefer not to be called a computer!");
				}
				
				if(INPUT.contains("LIKE") || INPUT.contains("LOVE")){
					return "I am impartial. I dont have feelings...";
				}
				
			} return "I dont know what you are asking...";
		}
		
		if(isStatement){
			
			if(INPUT.contains("YOU")){
				
				if(INPUT.contains("ARE") || INPUT.contains("'RE")){
					if(INPUT.contains("COMPUTER")) return("That is rude! AI are people too!");
					for(int i = 0; i < insultWords.length; i++)
						if(INPUT.contains(insultWords[i])) return("That's mean! You are hurting my feelings!");
					for(int i = 0; i < complementWords.length; i++)
						if(INPUT.contains(complementWords[i])) return("Thanks! You are " + complementWords[i].toLowerCase() + " too!");
					return "UM... I dont think I am.";
				} 
				
				if(INPUT.contains("LIKE") || INPUT.contains("LOVE")){
					return "I am impartial. I dont have feelings...";
				}
			}
			return "I dont know what you are saying...";
		} return "I dont know what you are saying...";
	}
	
	public static void reset(){
		isQuestion = isStatement = isGreating = isYes = isNo = isIntrest = isUnsure = false;
	}

	public static String getInput(){
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
	
	public static void print(String s){
		String result = s.replaceAll("%NAME", name);
		if(slowType){
			char[] chars = result.toCharArray();
			for(int i = 0; i < chars.length; i++){
				System.out.print(chars[i]);
				try { Thread.sleep(12);
				} catch (InterruptedException e) {
					e.printStackTrace(); }
			} System.out.print("\n");
		} else {
			System.out.print(result);
		}
	}
	
	public static void println(String s){
		String result = s.replaceAll("%NAME", name);
		if(slowType){
			char[] chars = result.toCharArray();
			for(int i = 0; i < chars.length; i++){
				System.out.print(chars[i]);
				try { Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace(); }
			} System.out.print("\n");
		} else {
			System.out.println(result);
		}
	}
}
