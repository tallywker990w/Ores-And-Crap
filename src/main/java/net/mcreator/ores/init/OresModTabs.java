/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ores.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.ores.OresMod;

@EventBusSubscriber
public class OresModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OresMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ORES = REGISTRY.register("ores",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.ores.ores")).icon(() -> new ItemStack(OresModBlocks.PLATINUM_ORE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(OresModBlocks.PLATINUM_ORE.get().asItem());
				tabData.accept(OresModItems.RAW_PLATINUM.get());
				tabData.accept(OresModItems.PLATINUM.get());
				tabData.accept(OresModItems.PLATINUM_SWORD.get());
				tabData.accept(OresModItems.REINFORCED_GOLD_PICKAXE.get());
				tabData.accept(OresModItems.REINFORCED_GOLD_ARMOR_HELMET.get());
				tabData.accept(OresModItems.REINFORCED_GOLD_ARMOR_CHESTPLATE.get());
				tabData.accept(OresModItems.REINFORCED_GOLD_ARMOR_LEGGINGS.get());
				tabData.accept(OresModItems.REINFORCED_GOLD_ARMOR_BOOTS.get());
				tabData.accept(OresModItems.REINFORCED_ROD.get());
				tabData.accept(OresModItems.REINFOR.get());
				tabData.accept(OresModItems.REINFORCEDGOLDTEMPLATE.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(OresModBlocks.PLATINUM_ORE.get().asItem());
			tabData.accept(OresModItems.RAW_PLATINUM.get());
			tabData.accept(OresModItems.PLATINUM.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(OresModItems.RAW_PLATINUM.get());
			tabData.accept(OresModItems.PLATINUM.get());
			tabData.accept(OresModItems.REINFORCED_ROD.get());
			tabData.accept(OresModItems.REINFORCEDGOLDTEMPLATE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(OresModItems.PLATINUM_SWORD.get());
			tabData.accept(OresModItems.REINFORCED_GOLD_PICKAXE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(OresModItems.REINFORCED_GOLD_ARMOR_HELMET.get());
			tabData.accept(OresModItems.REINFORCED_GOLD_ARMOR_CHESTPLATE.get());
			tabData.accept(OresModItems.REINFORCED_GOLD_ARMOR_LEGGINGS.get());
			tabData.accept(OresModItems.REINFORCED_GOLD_ARMOR_BOOTS.get());
			tabData.accept(OresModItems.REINFOR.get());
		}
	}
}