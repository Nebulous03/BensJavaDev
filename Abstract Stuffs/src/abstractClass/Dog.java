package abstractClass;

public class Dog extends Animal{
	
	public Dog(String name, int x, int y) {
		super(name, x, y);
	}

	@Override
	public String say() {
		return "\"Bork Bork!\"";
	}
	
	@Override
	public String getImgLocation() {
		return "./imgs/dog.gif";
	}
	
	@Override
	public double getScale() {
		return 0.25;
	}

}
