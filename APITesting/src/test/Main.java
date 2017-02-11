package test;

import nebulous.utils.Console;

public class Main {

	public static void main(String[] args) {
		Console.setPrefix("Nebulous Testing");
		Console.enableTimeStamp(true);
		Console.printBlock("Hello World!\nThis is a Block!");
		Console.println("HelloWorld!");
	}

}
