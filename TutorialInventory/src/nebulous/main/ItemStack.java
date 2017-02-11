package nebulous.main;

public class ItemStack {
	
	private Item item;
	private int count;

	public ItemStack(Item item, int count) {
		this.item = item;
		this.count = count;
	}
	
	public void increase(int ammount){
		if(count + ammount > item.getMaxStackSize())
			System.out.println("Error increasing stack, exceded max stack size.");
		else count += ammount;
	}
	
	public void decrease(int ammount){
		if(count - ammount < 0)
			System.out.println("Error decreasing stack, stacksize decreased below 0.");
		else count -= ammount;
		if(count <= 0){
			clearStack();
		}
	}
	
	public void clearStack(){
		this.item = null;
		this.count = 0;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
