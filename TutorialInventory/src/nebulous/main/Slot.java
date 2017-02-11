package nebulous.main;

public class Slot {
	
	private ItemStack stack;

	public Slot() {
		stack = new ItemStack(null,0);
	}

	public ItemStack getStack() {
		return stack;
	}

	public void setStack(ItemStack stack) {
		this.stack = stack;
	}

}
