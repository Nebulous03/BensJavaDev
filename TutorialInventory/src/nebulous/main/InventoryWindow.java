package nebulous.main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InventoryWindow {
	
	private JFrame window = new JFrame();
	private Inventory inventory;
	private int frameWidth;
	private int frameHeight;
	private int invWidth;
	private int invHeight;

	public InventoryWindow(Inventory inventory, int width, int height) {
		this.window.setTitle("Inventory");
		this.inventory = inventory;
		this.frameHeight = height;
		this.frameWidth = width;
		this.invWidth = inventory.getWidth();
		this.invHeight = inventory.getHeight();
		
		window.setLayout(null);
		window.setSize(width, height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		int slotSize = frameWidth / invWidth;

		for(int y = 0; y < invHeight; y++){
			for(int x = 0; x < invWidth; x++){
				
				// ADD ITEM PANELS
				JPanel slot = new JPanel();
				
				slot.setSize(slotSize - 4, slotSize - 4);
				slot.setBackground(Color.CYAN);
				slot.setLocation(x * slotSize, y * slotSize);
				
				System.out.println("Slot added at: " + x * slotSize + ", " + y * slotSize + ".");
				
				window.add(slot);
				
				slot.setVisible(true);
				
				//ADD ITEM NAMES
				JLabel name = new JLabel();
				if(inventory.getItemStack(x, y).getItem() == null){
					name.setText("NONE");
				} else {
					name.setText(inventory.getItemStack(x, y).getItem().getName());
				}
				name.setForeground(Color.BLACK);
				slot.add(name);
			}
		}
		
	}

}
