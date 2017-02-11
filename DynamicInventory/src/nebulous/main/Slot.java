package nebulous.main;

public class Slot {

	private int id;
	private ItemStack itemStack;
	
	public Slot(int id){
		this.id = 0;
		this.itemStack = new ItemStack(null, 0);
	}
	
	public ItemStack getItemStack() {
		return itemStack;
	}
	public void setItemStack(ItemStack itemStack) {
		this.itemStack = itemStack;
	}
	public int getId() {
		return id;
	}
	
	

}
