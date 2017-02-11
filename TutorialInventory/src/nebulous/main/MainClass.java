package nebulous.main;

public class MainClass {
	
	public static void main(String[] args){
		Inventory inventory = new Inventory(4,4);
		inventory.printInventory(4, 4);
		
		InventoryWindow window = new InventoryWindow(inventory, 640, 640);
		
	}

}
