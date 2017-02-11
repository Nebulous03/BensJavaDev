package abstractClass;

public abstract class Animal{
	
	private int posX = 0;
	private int posY = 0;
	
	private String name;
	
	private String imgLocation = "";
	private double scale = 0.5;
	
	public Animal(String name, int x, int y) {
		this.name = name;
		this.posX = x;
		this.posY = y;
	}
	
	public abstract String say();

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public String getImgLocation() {
		return imgLocation;
	}

	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

}
