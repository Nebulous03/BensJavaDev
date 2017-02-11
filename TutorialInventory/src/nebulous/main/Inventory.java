package nebulous.main;

public class Inventory {
	
	private Slot[] slots;
	private int size;
	private int height;
	private int width;
	
	public Inventory(int defaultSize){
		this.size = defaultSize;
		this.slots = new Slot[defaultSize];
		for(int i = 0; i < defaultSize; i++){
			slots[i] = new Slot();
		}
	}
	
	public Inventory(int width, int height){
		this.height = height;
		this.width = width;
		this.size = width * height;
		this.slots = new Slot[size];
		for(int i = 0; i < size; i++){
			slots[i] = new Slot();
		}
	}
	
	public void printInventory(int width, int height){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				ItemStack stack = slots[x + y * width].getStack();
				if(stack.getItem() == null){
					System.out.print("[(" + 0 + ")" + "Empty" + "]");
				} else {
					System.out.print("[(" + stack.getCount() + ")" + stack.getItem().getName() + "]");
				}
			}
			System.out.print("\n");
		}
	}
	
	public ItemStack getItemStack(int x, int y){
		return slots[x + y * width].getStack();
	}
	
	public void setItem(Item item, int ammount, int slot){
		slots[slot].setStack(new ItemStack(item, ammount));
	}
	
	public void setItem(Item item, int ammount, int x, int y){
		slots[x + y * width].setStack(new ItemStack(item, ammount));
	}
	
	
	public void addItem(Item item, int ammount){
		//Teach me how to JFrame, teach me, teach me how to JFrame
		
	}

	public Slot[] getSlots() {
		return slots;
	}

	public void setSlots(Slot[] slots) {
		this.slots = slots;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
