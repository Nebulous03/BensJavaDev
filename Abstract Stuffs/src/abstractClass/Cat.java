package abstractClass;

public class Cat extends Animal{
	
	public Cat(String name, int x, int y) {
		super(name, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String say() {
		return "\"Merow!\"";
	}
	
	@Override
	public String getImgLocation() {
		return "./imgs/monkey.jpg";
	}

}
