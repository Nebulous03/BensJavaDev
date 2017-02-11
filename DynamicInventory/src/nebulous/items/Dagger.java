package nebulous.items;

import nebulous.main.Item;

public class Dagger extends Item{

	public Dagger() {
		this.setName("Dagger");
		this.setMaxStackSize(12);
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
