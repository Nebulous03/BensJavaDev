package nebulous.something;

public class Inventory {

	private int SIZE = 0;
	private int[] items;
	
	public Inventory(int defaultSize) {
		items = new int[defaultSize];
		SIZE = defaultSize;
		for(int i = 0; i < defaultSize; i++){
			items[i] = 0;
		}
	}
	
	public void printInv(int width, int height){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				String item = "null";
				if(items[x + y * height] == 0) item = "Empty";
				else item = ItemIndex.getNameFromID(items[x + y * height]);
				System.out.print("[" + item + "]");
			} System.out.print("\n");
		}
	}
	
	public void addItem(int id){
		int slot = getNextOpenSlot(SIZE);
		if(slot == -1){
			System.out.println("Error adding item : " + id + ", No slot available.");
		} else {
			setItemInSlot(id, slot);
		}
	}
	
	public int getNextOpenSlot(int distance){
		for(int i = 0; i < distance; i++){
			if(items[i] == 0) return i;
		} return -1;
	}
	
	public void setItemInSlot(int id, int slot){
		items[slot] = id;
	}

}
