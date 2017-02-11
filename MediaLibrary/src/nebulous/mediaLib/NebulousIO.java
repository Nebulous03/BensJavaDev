package nebulous.mediaLib;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NebulousIO {
	
	private static Scanner scanner;
	private static BufferedWriter writer;

	public static String getFileAsString(String file){
		String totalString = "";
		try { 
			File location = new File(file);
			scanner = new Scanner(location);
		} catch (FileNotFoundException e) { 
			System.out.println("ERROR: Unable to read file at: " + file);
		} while(scanner.hasNextLine()){
			totalString += scanner.nextLine();
		} scanner.close(); return totalString;
	}
	
	public static void saveStringToFile(String output, String file){
		try {
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			System.out.println("ERROR: Unable to save file at: " + file);
		} try {
			writer.write(output);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
