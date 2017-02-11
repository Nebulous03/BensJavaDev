package nebulous.something;

public class Main {

	public static void main(String[] args) {
		
		new ItemIndex();
		Inventory inv = new Inventory(16);
		
		ItemIndex.createItem("Copper_Ingot");
		ItemIndex.createItem("Iron_Ingot");
		ItemIndex.createItem("Silver_Ingot");
		ItemIndex.createItem("Gold_Ingot");
		ItemIndex.createItem("Wooden_Sword");
		ItemIndex.createItem("Iron_Sword");
		
		inv.addItem(ItemIndex.getIDfromName("Iron_Sword"));
		inv.printInv(4, 4);
	}

}
