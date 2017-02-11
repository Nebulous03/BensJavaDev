package nebulous.items;

import nebulous.main.Item;

public class WoodenSword extends Item{

	public WoodenSword() {
		this.setName("Wooden Sword");
		this.setMaxStackSize(1);
	}

	@Override
	public void onUse() {
		// player.attack(this) or something
	}

	@Override
	public void update() {
		// doShineything
	}


}
