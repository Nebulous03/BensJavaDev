package nebulous.main;

public class ItemStack {
	
	private Item item;
	private int count;

	public ItemStack(Item item, int count) {
		this.item = item;
		this.count = count;
	}
	
	public ItemStack() {
		this.item = null;
		this.count = 0;
	}
	
	public boolean increase(int ammount){
		if(count + ammount > item.getMaxStackSize()){
			System.err.println("Error increasing stack by " + ammount + " for item [" + "(" + count +")" + item.getName() +
					"], exceded max stack size of " + item.getMaxStackSize() + ".");
			return false;
		}
		else count += ammount;
		return true;
	}
	
	public boolean decrease(int ammount){
		if(count - ammount < 0){
			System.err.println("Error increasing stack by " + ammount + " for item [" + "(" + count +")" + item.getName() +
					"], cannot decrease below zero.");
			return false;
		}
		else count -= ammount;
		if(count == 0) clearStack();
		return true;
	}
	
	public void clearStack(){
		count = 0;
		item = null;
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
