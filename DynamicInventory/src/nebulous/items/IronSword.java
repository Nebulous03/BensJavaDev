package nebulous.items;

import nebulous.main.Item;

public class IronSword extends Item{

	public IronSword() {
		this.setName("Iron Sword");
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
