package abstractClass;

public class Monkey extends Animal implements IMovable{

	public Monkey(String name, int x, int y) {
		super(name, x, y);
	}

	@Override
	public String say() {
		return "\"Ohh ooh ooh!\"";
	}
	
	@Override
	public String getImgLocation() {
		return "./imgs/monkey.jpg";
	}

	@Override
	public void move(int xDelta, int yDelta) {
		
	}
	
}
