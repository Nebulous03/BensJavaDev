package abstractClass;

public class Fish extends Animal{

	public Fish(String name, int x, int y) {
		super(name, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String say() {
		return "\"Blub Blub\"";
	}

	@Override
	public String getImgLocation() {
		return "./imgs/monkey.jpg";
	}
	
}
