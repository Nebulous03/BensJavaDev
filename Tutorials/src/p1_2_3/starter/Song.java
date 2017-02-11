package p1_2_3.starter;

public class Song {
	
	public String name;
	public double rating;
	public double price;
	public boolean favorite;

	public Song(String name, double rating, double price, boolean favorite) {
		this.name = name;
		this.rating = rating;
		this.price = price;
		this.favorite = favorite;
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

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

}
