package nebulous.weatherApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Random;

public class WeatherApp {
	
	public static WeatherIndex index = new WeatherIndex();
	
	public static void main(String[] args){

		 Random rand = new Random();
		 Runtime run = Runtime.getRuntime();
		 
		 // Parse condition
		 float temp = rand.nextInt(110) + rand.nextFloat();
		 float feels = temp + rand.nextInt(3) + rand.nextFloat();
		 float high = temp + rand.nextInt(10);
		 float low = temp - rand.nextInt(10);
		 float humidity = (temp / 110) * 100;
		 
		 int code = rand.nextInt(index.getSize());
		 String condition = parseConditionByTemp(code, temp);
		 
		 DecimalFormat tempf = new DecimalFormat("#.##");
		 
		 //Print
		 System.out.print(""
		 		+ "---------------------------------------------------\n"
		 		+ "\t\t~Nebulous Weather~\n"
		 		+ "---------------------------------------------------\n");
		 System.out.println();
		 System.out.println("\tCurrent Condition: " + condition);
		 System.out.println();
		 System.out.println("\tTemperature : " + tempf.format(temp) + "F" + " (" + tempf.format(toCelcius(temp)) + "C" + ")");
		 System.out.println("\t - Feels Like : " + tempf.format(feels) + "F" + " (" + tempf.format(toCelcius(feels)) + "C" + ")");
		 System.out.println("\t - High Temp : " + tempf.format(high) + "F" + " (" + tempf.format(toCelcius(high)) + "C" + ")");
		 System.out.println("\t - Low Temp : " + tempf.format(low) + "F" + " (" + tempf.format(toCelcius(low)) + "C" + ")");
		 System.out.println("\t - Humidity : " + tempf.format(humidity) + "%");
		 System.out.println();
		 System.out.print(""
			 	+ "---------------------------------------------------\n");
		 try {
			 
			Process javac = run.exec("cmd /C whoami");
			BufferedReader in = new BufferedReader(new InputStreamReader(javac.getInputStream()));
			String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static float toCelcius(float temp){
		float output = (temp - 32f) * (5f/9f);
		return output;
	}
	
	public static String parseCondition(int code){
		Weather weather = index.getWeatherFromCode(code);
		return weather.getName();
	}
	
	public static String parseConditionByTemp(int code, float temp){
		Weather weather = index.getWeatherFromCode(code);
		return weather.getName();
	}
	
}
