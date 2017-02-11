package nebulous.main;

public class Console {
	
	private final static String header = "CONSOLE";
	
	public static void println(Object text){
		System.out.println("[ " + header + " ] " + text);
	}
	
	public static void print(Object text){
		System.out.print("[ " + header + " ] " + text);
	}
	
	public static void printNative(Object text){
		System.out.print(text);
	}
	
	public static void printErr(Object text){
		System.err.println("[ " + header + " ] " + text);
	}
	
	public static void printMOTD(String text){
		System.out.print(	
				
		"-------------------------------------------\n" +
		text + " \n" +
		"-------------------------------------------\n"
		
		);
	}
	
	public static final String devider = 
		"-------------------------------------------";
	
}
