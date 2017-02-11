package nebulous.weatherApp;

public class Weather {
	
	private static int currentId = 0;
	
	private String name = "";
	private int id = 3200;
	private WeatherType type = WeatherType.NONE;

	public Weather(String name, WeatherType type) {
		this.name = name;
		this.type = type;
		this.id = currentId;
		currentId++;
	}

	public String getName() {
		return name;
	}

	public static int getCurrentId() {
		return currentId;
	}

	public int getId() {
		return id;
	}

	public WeatherType getType() {
		return type;
	}

}


