package abstractClass;

public class Fox extends Animal{

	public Fox(String name, int x, int y) {
		super(name, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String say() {
		return "\"Wakakakakakow\"";
	}
	
	@Override
	public String getImgLocation() {
		return "./imgs/monkey.jpg";
	}

}
