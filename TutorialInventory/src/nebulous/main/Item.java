package nebulous.main;

public class Item {
	
	private String name;
	private final int MAX_STACK_SIZE = 128;

	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxStackSize() {
		return MAX_STACK_SIZE;
	}

}
