/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ores.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.ores.item.*;
import net.mcreator.ores.OresMod;

public class OresModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(OresMod.MODID);
	public static final DeferredItem<Item> PLATINUM_ORE;
	public static final DeferredItem<Item> RAW_PLATINUM;
	public static final DeferredItem<Item> PLATINUM;
	public static final DeferredItem<Item> PLATINUM_SWORD;
	public static final DeferredItem<Item> REINFORCED_GOLD_PICKAXE;
	public static final DeferredItem<Item> REINFORCED_GOLD_ARMOR_HELMET;
	public static final DeferredItem<Item> REINFORCED_GOLD_ARMOR_CHESTPLATE;
	public static final DeferredItem<Item> REINFORCED_GOLD_ARMOR_LEGGINGS;
	public static final DeferredItem<Item> REINFORCED_GOLD_ARMOR_BOOTS;
	public static final DeferredItem<Item> REINFORCED_ROD;
	public static final DeferredItem<Item> REINFORCED_GOLD_INGOT;
	public static final DeferredItem<Item> REINFOR;
	public static final DeferredItem<Item> REINFORCEDGOLDTEMPLATE;
	static {
		PLATINUM_ORE = block(OresModBlocks.PLATINUM_ORE);
		RAW_PLATINUM = REGISTRY.register("raw_platinum", RawPlatinumItem::new);
		PLATINUM = REGISTRY.register("platinum", PlatinumItem::new);
		PLATINUM_SWORD = REGISTRY.register("platinum_sword", PlatinumSwordItem::new);
		REINFORCED_GOLD_PICKAXE = REGISTRY.register("reinforced_gold_pickaxe", ReinforcedGoldPickaxeItem::new);
		REINFORCED_GOLD_ARMOR_HELMET = REGISTRY.register("reinforced_gold_armor_helmet", ReinforcedGoldArmorItem.Helmet::new);
		REINFORCED_GOLD_ARMOR_CHESTPLATE = REGISTRY.register("reinforced_gold_armor_chestplate", ReinforcedGoldArmorItem.Chestplate::new);
		REINFORCED_GOLD_ARMOR_LEGGINGS = REGISTRY.register("reinforced_gold_armor_leggings", ReinforcedGoldArmorItem.Leggings::new);
		REINFORCED_GOLD_ARMOR_BOOTS = REGISTRY.register("reinforced_gold_armor_boots", ReinforcedGoldArmorItem.Boots::new);
		REINFORCED_ROD = REGISTRY.register("reinforced_rod", ReinforcedRodItem::new);
		REINFORCED_GOLD_INGOT = REGISTRY.register("reinforced_gold_ingot", ReinforcedGoldIngotItem::new);
		REINFOR = REGISTRY.register("reinfor", ReinforItem::new);
		REINFORCEDGOLDTEMPLATE = REGISTRY.register("reinforcedgoldtemplate", ReinforcedgoldtemplateItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}