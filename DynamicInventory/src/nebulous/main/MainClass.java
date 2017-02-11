package nebulous.main;

import nebulous.items.Dagger;
import nebulous.items.IronSword;
import nebulous.items.WoodenSword;

public class MainClass {
	
	public static void main(String[] args){
		Inventory inventory = new Inventory(128);
        inventory.resize(12, 100);
		
		//Test adding unstackable items:
		inventory.addItem(new IronSword(), 1); // P
		inventory.addItem(new IronSword(), 1); // P
		inventory.addItem(new IronSword(), 1); // P
		
		//Test stacking / stacking beyond stacksize:
		inventory.addItem(new Dagger(), 11); //P
		inventory.addItem(new Dagger(), 1);	 //P
		inventory.addItem(new Dagger(), 1);  //P
		
		//Test adding to position
		inventory.addItem(new IronSword(), 1, 3, 3); //P
//		inventory.addItem(new Dagger(), 10, 3, 3);	 //P
		
		//Test adding beyond stacksize
//		inventory.addItem(new WoodenSword(), 2); //P
//		inventory.addItem(new WoodenSword(), 128, 9, 9); //P

		//Test force add items:
		inventory.addItem(new WoodenSword(), 128, 9, 9, true); //P
		inventory.addItem(new Dagger(), 18, 6, 7, true); //P
		
		inventory.printInventory();
//      inventory.printInventory(4,360);
//      inventory.resize(30,24);
//      inventory.printInventory();
	}

}
