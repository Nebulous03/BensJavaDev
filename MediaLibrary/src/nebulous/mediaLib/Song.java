package nebulous.mediaLib;

public class Song {
	
	private String name;
	private double rating;
	private double price;
	
	public Song(String name, double rating, double price){
		this.name = name;
		this.rating = rating;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


}
