package nebulous.testing;

import nebulous.utils.Console;

public class Main {

	public static void main(String[] args) {
//		Console.enableTimeStamp(true);
//		Console.println("Hello World!");
//		Console.setCarrot(">");
//		Console.println("Hiya, How are you?");
//		Console.setPrefixFrame("[)");
//		Console.println("Testing Testing Testing....");
//		Console.setDateFrame("<>");
//		Console.println("Testing Testing Testing....");
//		Console.setSuffix("//");
//		Console.setCarrot(" -- ");
//		Console.println("Testing Testing Testing....");
//		Console.forceStackTrace();
		
		Console.enableTimeStamp(false);
		Console.openLog("./logs/defaultLog2.log");
		Console.log("Testing the Log");
		Console.log("Testing again...");
		//Console.closeLog();
		
//		File log = new File("./logs/testLog.log");
//		log.clearFile();
//		log.open();
//		log.append("Hello 1");
//		log.append("Hello 2");
//		log.close();
	}

}
