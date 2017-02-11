package nebulous.main;

public class Inventory {
	
	private Slot[] slots;
	private int size;
	private int width;
	private int height;
	
	public Inventory(int size){
		this.size = size;
		slots = new Slot[size];
		for(int i = 0; i < size; i++)
			slots[i] = new Slot(i);
	}
	
	public Inventory(int width, int height){
		this.size = width * height;
		this.width = width;
		this.height = height;
		slots = new Slot[size];
		for(int i = 0; i < size; i++)
			slots[i] = new Slot(i);
	}

    public void resize(int width, int height){
        this.width = width;
        this.height = height;
    }
	
	public void printInventory(){
        boolean shouldBreak = false;
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if(x + y * width >= slots.length){
                    shouldBreak = true;
                    break;
                } Slot slot = slots[x + y * width];
                if(slot.getItemStack() == null || slot.getItemStack().getItem() == null)
                    System.out.print("[NONE(" + (x + y * width) + ")]");
                else System.out.print("[" + "(" + slots[x + y * width].getItemStack().getCount() + ")"
                        + slots[x + y * width].getItemStack().getItem().getName() + "]");
            } if(!shouldBreak)System.out.print("\n");
        }
    }

    public void printInventory(int width, int height){
        resize(width, height);
        printInventory();
    }
	
	public void addItem(Item item, int count){
		for(int i = 0; i < slots.length; i++){
			ItemStack stack = slots[i].getItemStack();
			if(stack.getItem() == null){ 
				stack.setItem(item);
				if(!slots[i].getItemStack().increase(count))
					stack.setItem(null);
				break;
			} else if(stack.getItem().equals(item)){
				if(stack.getCount() + count < item.getMaxStackSize() + 1)
					stack.increase(count);
				else continue;
				break;
			} else if(stack.getItem() != null){
				continue;
			} else {
				System.err.println("Error adding item [" + "(" + count + ")" + item.getName() + "], no available slots in inventory");
			} 
		}
	}
	
	public void addItem(Item item, int count, int slot){
		ItemStack stack = slots[slot].getItemStack();
		if(stack.getItem() == null){ 
			stack.setItem(item);
			if(!slots[slot].getItemStack().increase(count))
				stack.setItem(null);
		} else if(stack.getItem().equals(item)){
			if(stack.getCount() + count < item.getMaxStackSize() + 1)
				stack.increase(count);
		} else if(stack.getItem() != null){
			System.err.println("Error adding item [" + "(" + count + ")" + item.getName() + "] in slot " + slot + 
					", slot already contains [" + "(" + stack.getCount() + ")" +  stack.getItem().getName() + "].");
		} else {
			System.err.println("Error adding item [" + "(" + count + ")" + item.getName() + "], no available slots in inventory");
		} 
	}
	
	public void addItem(Item item, int count, int x, int y){
		addItem(item, count, x + y * width);
	}
	
	public void addItem(Item item, int count, int slot, boolean force){
		if(force){
			ItemStack stack = new ItemStack(item, count);
			slots[slot].setItemStack(stack);
		} else {
			addItem(item, count, slot);
		}
	}
	
	public void addItem(Item item, int count, int x, int y, boolean force){
		if(force){
			ItemStack stack = new ItemStack(item, count);
			slots[x + y * width].setItemStack(stack);
		} else {
			addItem(item, count, x, y);
		}
	}
	
	public Slot getSlot(int id){
		return slots[id];
	}
	
	public Slot getSlots(int x, int y){
		return slots[x + y * width];
	}
	
	public Item getItemInSlot(int id){
		return slots[id].getItemStack().getItem();
	}
	
	public Item getItemInSlot(int x, int y){
		return slots[x + y * width].getItemStack().getItem();
	}
	
	public ItemStack getItemStackInSlot(int id){
		return slots[id].getItemStack();
	}
	
	public ItemStack getItemStackInSlot(int x, int y){
		return slots[x + y * width].getItemStack();
	}

	public Slot[] getSlots() {
		return slots;
	}

	public int getSize() {
		return size;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
