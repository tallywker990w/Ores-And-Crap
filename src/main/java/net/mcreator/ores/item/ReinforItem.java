package net.mcreator.ores.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ReinforItem extends Item {
	public ReinforItem() {
		super(new Item.Properties().durability(900).rarity(Rarity.UNCOMMON));
	}

	@Override
	public int getEnchantmentValue() {
		return 24;
	}
}