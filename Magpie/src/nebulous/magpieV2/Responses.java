package nebulous.magpieV2;

import java.util.Random;

public class Responses {
	
	public static Random rand = new Random();
	
	/* ~ Greeting Responses ~ */
	private static String[] greetings = 
	{
		"Hello there %NAME!",
		"Hey, hey, %NAME!",
		"Why hello there %NAME!"
	};
	
	public static String getGreeting(){
		return greetings[rand.nextInt(greetings.length)] + " ";
	}

}
