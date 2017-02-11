package nebulous.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nebulous.tools.File;

public class Console {
	
	private static String logLocation = "./logs/defaultLog.log";
	private static String prefix = "NebulousUtils";
	private static String suffix = "";
	private static String carrot = ":";
	private static String prefixFrame = "[]";
	private static String dateFrame = "[]";
	private static File logFile = null;
	private static boolean timeStamp = false;
	
	private static Date date = null;
	
	private static DateFormat format = new SimpleDateFormat("HH:mm:ss");

	public static void print(Object text){ print(text, false); }
	public static void println(Object text){ print(text, false); }
	
	public static String print(Object text, boolean returnOnly){
		date = new Date();
		String out = ((timeStamp ? dateFrame.charAt(0) + format.format(date).toString() + dateFrame.charAt(1) : "" )
				+ prefixFrame.charAt(0) + prefix + prefixFrame.charAt(1) + carrot + text + suffix);
		if(returnOnly) return out;
		else System.out.println(out);
		return null;
	}
	
	public static String println(Object text, boolean returnOnly){
		date = new Date();
		String out = ((timeStamp ? dateFrame.charAt(0) + format.format(date).toString() + dateFrame.charAt(1) : "" )
				+ prefixFrame.charAt(0) + prefix + prefixFrame.charAt(1) + carrot + text + suffix);
		if(returnOnly) return out;
		else System.out.println(out);
		return null;
	}
	
	public static void printErr(Object text){
		date = new Date();
		System.err.println((timeStamp ? dateFrame.charAt(0) + format.format(date).toString() + dateFrame.charAt(1) : "" )
				+ prefixFrame.charAt(0) + prefix + prefixFrame.charAt(1) + carrot + text + suffix);
	}
	
	public static void openLog(String location){
		logLocation = location;
		logFile = new File(location);
		logFile.open();
	}
	
	public static void closeLog(){
		logFile.close();
		logFile = null;
	}
	
	public static void log(Object text){
		log(text, true, true);
	}
	
	public static void log(Object text, boolean printToConsole, boolean forceTimeStampInLog){
		String output = print(text, true);
		if(printToConsole) printRawln(!timeStamp ? (forceTimeStampInLog ? dateFrame.charAt(0) + 
				format.format(date).toString() + dateFrame.charAt(1) + output : output) : output);
		if(logFile == null) openLog(logLocation);
		logFile.append(text);
		logFile.close();
		logFile = null;
	}
	
	public static void printRaw(Object text){
		System.out.print(text);
	}
	
	public static void printRawln(Object text){
		System.out.println(text);
	}
	
	public static void forceStackTrace(){
		new Exception().printStackTrace();
	}
	
	public static void printBlock(String text, boolean returnOnly){
		System.out.println("--------------------------------");
		System.out.println(text);
		System.out.println("--------------------------------");
	}

	public static void setPrefix(String prefix) {
		Console.prefix = prefix;
	}
	
	public static void setSuffix(String suffix) {
		Console.suffix = suffix;
	}
	
	public static void setCarrot(String carrot){
		Console.carrot = carrot;
	}
	
	public static void setPrefixFrame(String frame){
		Console.prefixFrame = frame;
	}
	
	public static void setDateFrame(String frame){
		Console.dateFrame = frame;
	}

	public static void enableTimeStamp(boolean timeStamp) {
		Console.timeStamp = timeStamp;
	}
	
	public static void setDateFormat(DateFormat dateFormat){
		Console.format = dateFormat;
	}
	
	@Override
	protected void finalize() {
		if(logFile != null) logFile.close();
		try { super.finalize(); } catch (Throwable e) { e.printStackTrace(); }
	}
}
