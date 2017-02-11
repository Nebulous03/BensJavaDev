package nebulous;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MediaWriter {
	
	private static final String mediaFile = "mymedia.txt";
	private static String writeString = "";
	private static Scanner scanner;
	private static BufferedWriter writer;

	public static String read(){
		String totalString = "";
		try { 
			File location = new File(mediaFile);
			scanner = new Scanner(location);
		} catch (FileNotFoundException e) { 
			System.out.println("ERROR: Unable to read file at: " + mediaFile);
		} while(scanner.hasNextLine()){
			totalString += scanner.nextLine();
		} scanner.close(); return totalString;
	}
	
	public static void write(String text){
		writeString += text;
		try {
			writer = new BufferedWriter(new FileWriter(mediaFile));
		} catch (IOException e) {
			System.out.println("ERROR: Unable to save file at: " + mediaFile);
		} try {
			writer.write(writeString);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
