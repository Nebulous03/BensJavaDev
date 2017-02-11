package pltw121;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NebulousIO {
	
	public static Scanner reader = null;
	public static FileWriter writer = null;
	public static BufferedWriter bWriter = null;
	
	public static void writeToFile(String fileName, String text, boolean append){
		File file = new File(fileName);
		try {
			if(!file.exists()) file.createNewFile();
			writer = new FileWriter(file.getName(), true);
			bWriter = new BufferedWriter(writer);
			PrintWriter printer = new PrintWriter(bWriter);
			
			if(append){ 
				printer.append(text);
			} else bWriter.write(text);
			
//			reader.close();
//			writer.close();
//			bWriter.close();
			
			System.out.println(fileName + " was saved at " + file.getAbsolutePath());
			
		} catch (Exception e){
			try {
//			reader.close();
//			writer.close();
//			bWriter.close();
			} catch (Exception e2) {
				System.err.println("ERROR CLOSING " + file.getName());
			}
			System.err.println("ERROR WRITING " + file.getName() + " TO PATH: " + file.getAbsolutePath());
		}
	}
	
	public static void writeToFile(File file, String text, boolean append){
		File lFile = file;
		try {
			if(!lFile.exists()) lFile.createNewFile();
			writer = new FileWriter(lFile.getName(), true);
			bWriter = new BufferedWriter(writer);
			PrintWriter printer = new PrintWriter(bWriter);
			
			if(append){ 
				printer.println(text);
			} else bWriter.write(text);
			
			reader.close();
			writer.close();
			bWriter.close();
			
			System.out.println(lFile.getName() + " was saved at " + lFile.getAbsolutePath());
			
		} catch (Exception e){
			try {
			reader.close();
			writer.close();
			bWriter.close();
			} catch (Exception e2) {
				System.err.println("ERROR CLOSING " + lFile.getName());
			}
			System.err.println("ERROR WRITING " + lFile.getName() + " TO PATH: " + lFile.getAbsolutePath());
		}
	}
	
	public static void appendToFile(String fileName, String text){
		writeToFile(fileName, text, true);
	}
	
	public static void appendToFile(File file, String text){
		writeToFile(file, text, true);
	}
	
	public static String readFromFile(String file){
		String result = "";
		File input = new File(file);
		try {
			reader = new Scanner(input);
			if(reader.hasNext()) result += reader.nextLine();
		} catch (FileNotFoundException e) {
			reader.close();
			System.err.println("ERROR READING " + input.getName() + "!");
			e.printStackTrace();
		} reader.close();
		return result;
	}
	
	public static String readFromFile(File file){
		String result = "";
		File input = file;
		try {
			reader = new Scanner(input);
			if(reader.hasNext()) result += reader.nextLine();
		} catch (FileNotFoundException e) {
			reader.close();
			System.err.println("ERROR READING " + input.getName() + "!");
			e.printStackTrace();
		} reader.close(); 
		return result;
	}

}
