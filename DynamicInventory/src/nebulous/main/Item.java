package nebulous.main;

public abstract class Item {
	
	private String name;
	private int maxStackSize = 128;

	public Item() {
		this.name = "unnamed_item";
	}
	
	public Item(String name) {
		this.name = name;
	}
	
	public void onUse(){ }
	
	public void update(){ }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxStackSize() {
		return maxStackSize;
	}
	
	public void setMaxStackSize(int maxStackSize) {
		this.maxStackSize = maxStackSize;
	}
	
	@Override
	public boolean equals(Object o){
		Item item = (Item) o;
		if(item.getName() == this.name) return true;
		return false;
	}

}
