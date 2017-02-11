package nebulous.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;


public class DataHandler {
	
	public static PrintWriter liveFile = null;
	
	public static void save(Object[] data, String location){
		 String outData = null;
		 String working = null;
		 
		 for(Object o : data){
			 
			 if(o instanceof Integer){
				 working = "INT:" + o;
			 } else if(o instanceof Float){
				 working = "FLT:" + o;
			 } else if(o instanceof String){
				 working = "STR:" + o;
			 } else if(o instanceof Boolean){
				 working = "BLN:" + o;
			 } else {
				 System.out.println("[DataHandler]: <ERROR> Cannot save object type: " + o.getClass().getSimpleName() + "!");
			 }
			 
			 if(outData == null) outData = working;
			 else if (working != null) outData += "\n" + working;
			 
			 working = null;
		 }
		 
		 try {
			PrintWriter out = new PrintWriter(location);
			out.println(outData);
			out.close();
			System.out.println("[DataHandler]: Successfully saved '" + location + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Delimiter-based save method.
	 * Takes delimiter, file location, and object data arguments.
	 * 
	 * ** Only Supports basic data types. Do not use custom class objects!
	 * 
	 * @param delimiter
	 * @param location
	 * @param data
	 * 
	 * @author  Ben Ratcliff
	 */
	public static void save(String delimiter, String location, Object data){
		String outData = null;
		outData = delimiter + ":" + data;
		boolean append = true;
		String[] recurringData = readRaw(location).split("\n");
		
		try {
			PrintWriter out = new PrintWriter(location);
			for(int i = 0; i < recurringData.length; i++){
				String local = recurringData[i].toString();
				if(local.contains(delimiter)){
					append = false;
					out.print(outData + "\n");
				} else {
					out.print(recurringData[i] + "\n");
				}
			}
			
			if(append){
				out.print(outData);
			}
			
			out.close();
			System.out.println("[DataHandler]: Successfully saved '" + delimiter + "' at '" + location + "'");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String readRaw(String location){
		String data = null;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(location));
			
		    try {
		        StringBuilder stringBuilder = new StringBuilder();
		        String line = reader.readLine();
	
		        while (line != null) {
		            stringBuilder.append(line);
		            stringBuilder.append("\n");
		            line = reader.readLine();
		        }
		        data = stringBuilder.toString();
		    } finally {
		        reader.close();
		    }
		    
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return data;
	}
	
	/**
	 * Delimiter based read method.
	 * Takes delimiter, and file location arguments.
	 * 
	 * @param delimiter
	 * @param location
	 * 
	 * @return Object
	 */
	public static Object read(String delimiter, String location){
		String[] data = readRaw(location).split("\n");
		String output = null;
		
		for(int i = 0; i < data.length; i++){
			String local = data[i].toString();
			if(local.startsWith("#")) continue;
			if(local.startsWith(delimiter + ":")){
				output = local.substring(delimiter.length() + 1);
				break;
			}
		}
		
		if(output != null) return output;
		else System.out.println("[DataHandler]: <ERROR> Could not find item with delimiter '" + delimiter + "'!");
		
		return null;
	}
	
	public static Object[] read(String location){
		String data = null;
		Object[] output = null;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(location));
		    try {
		        StringBuilder stringBuilder = new StringBuilder();
		        String line = reader.readLine();
	
		        while (line != null) {
		            stringBuilder.append(line);
		            stringBuilder.append("\n");
		            line = reader.readLine();
		        }
		        data = stringBuilder.toString();
		    } finally {
		        reader.close();
		    }
		    
			String[] strings = data.split("\n");
			output = new Object[strings.length];
			
			for(int i = 0; i < strings.length; i++){
				if(strings[i].contains("INT:")){
					String innerData = strings[i].substring(4);
					output[i] = Integer.parseInt(innerData);
				} else if(strings[i].contains("FLT:")){
					String innerData = strings[i].substring(4);
					output[i] = Float.parseFloat(innerData);
				} else if(strings[i].contains("STR:")){
					String innerData = strings[i].substring(4);
					output[i] = innerData;
				} else if(strings[i].contains("BLN:")){
					String innerData = strings[i].substring(4);
					output[i] = Boolean.parseBoolean(innerData);
				} else {
					System.out.println("[DataHandler]: <ERROR> Could not read object type while reading line " + i + "!");
				}
			}
			
		} catch (Exception e){
			System.out.println("[DataHandler]: <ERROR> Could not read file!");
		}
		
		return output;
	}
	
}
