package nebulous.weatherApp;

import java.util.ArrayList;

public class WeatherIndex {
	
	private ArrayList<Weather> weatherHash = new ArrayList<Weather>();
	
	public WeatherIndex(){
		weatherHash.add(new Weather("Tornado", WeatherType.WARM));
		weatherHash.add(new Weather("Tropical Storm", WeatherType.WARM));
		weatherHash.add(new Weather("Hurricane", WeatherType.WARM));
		weatherHash.add(new Weather("Severe Thunderstorms", WeatherType.WARM));
		weatherHash.add(new Weather("Thunderstorms", WeatherType.EITHER));
		weatherHash.add(new Weather("Mixed Rain and Snow", WeatherType.COLD));
		weatherHash.add(new Weather("Mixed Rain and Sleet", WeatherType.COLD));
		weatherHash.add(new Weather("Mixed Snow and Sleet", WeatherType.COLD));
		weatherHash.add(new Weather("Freezing Drizzle", WeatherType.COLD));
		weatherHash.add(new Weather("Drizzle", WeatherType.EITHER));
		weatherHash.add(new Weather("Freezing Rain", WeatherType.COLD));
		weatherHash.add(new Weather("Showers", WeatherType.EITHER));
		weatherHash.add(new Weather("Showers", WeatherType.EITHER));
		weatherHash.add(new Weather("Snow Flurries", WeatherType.COLD));
		weatherHash.add(new Weather("Light Snow Showers", WeatherType.COLD));
		weatherHash.add(new Weather("Blowing Snow", WeatherType.COLD));
		weatherHash.add(new Weather("Snow", WeatherType.COLD));
		weatherHash.add(new Weather("Hail", WeatherType.COLD));
		weatherHash.add(new Weather("Sleet", WeatherType.COLD));
		weatherHash.add(new Weather("Dust", WeatherType.WARM));
		weatherHash.add(new Weather("Foggy", WeatherType.EITHER));
		weatherHash.add(new Weather("Haze", WeatherType.EITHER));
		weatherHash.add(new Weather("Smoky", WeatherType.EITHER));
		weatherHash.add(new Weather("Blustery", WeatherType.WARM));
		weatherHash.add(new Weather("Windy", WeatherType.EITHER));
		weatherHash.add(new Weather("Cold", WeatherType.COLD));
		weatherHash.add(new Weather("Cloudy", WeatherType.EITHER));
		weatherHash.add(new Weather("Mostly Cloudy Night", WeatherType.EITHER));
		weatherHash.add(new Weather("Mostly Cloudy Day", WeatherType.EITHER));
		weatherHash.add(new Weather("Partly Cloudy Night", WeatherType.EITHER));
		weatherHash.add(new Weather("Partly Cloudy Day", WeatherType.EITHER));
		weatherHash.add(new Weather("Clear Night", WeatherType.EITHER));
		weatherHash.add(new Weather("Sunny", WeatherType.WARM));
		weatherHash.add(new Weather("Fair Night", WeatherType.EITHER));
		weatherHash.add(new Weather("Fair Day", WeatherType.EITHER));
		weatherHash.add(new Weather("Mixed Rain and Hail", WeatherType.COLD));
		weatherHash.add(new Weather("Hot", WeatherType.WARM));
		weatherHash.add(new Weather("Isolated Thunderstorms", WeatherType.WARM));
		weatherHash.add(new Weather("Scattered Thunderstorms", WeatherType.WARM));
		weatherHash.add(new Weather("Scattered Thunderstorms", WeatherType.WARM));
		weatherHash.add(new Weather("Scattered Showers", WeatherType.WARM));
		weatherHash.add(new Weather("Heavy Snow", WeatherType.COLD));
		weatherHash.add(new Weather("Scattered Snow Showers", WeatherType.COLD));
		weatherHash.add(new Weather("Heavy Snow", WeatherType.COLD));
		weatherHash.add(new Weather("Partly Cloudy", WeatherType.EITHER));
		weatherHash.add(new Weather("Thundershowers", WeatherType.WARM));
		weatherHash.add(new Weather("Snow Showers", WeatherType.COLD));
		weatherHash.add(new Weather("Isolated Thundershowers", WeatherType.WARM));
//		weatherHash.add(3200, "unavailable");
	}

	public Weather getWeatherFromCode(int code){
		for(Weather weather : weatherHash){
			if(weather.getId() == code)
				return weather;
		} return null;
	}
	
	public int getSize(){
		return weatherHash.size();
	}

}
