package nebulous.stuff;

public class Main {

	public static void main(String[] args) {
		ArgClass<Integer, String> thing = new ArgClass<Integer, String>(12, "Hello");
		
		thing.thing();
	}

}
