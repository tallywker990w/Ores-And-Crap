package net.mcreator.ores.item;

import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.Util;

import net.mcreator.ores.init.OresModItems;

import java.util.List;
import java.util.EnumMap;

@EventBusSubscriber
public abstract class ReinforcedGoldArmorItem extends ArmorItem {
	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 9);
				map.put(ArmorItem.Type.LEGGINGS, 10);
				map.put(ArmorItem.Type.CHESTPLATE, 8);
				map.put(ArmorItem.Type.HELMET, 7);
				map.put(ArmorItem.Type.BODY, 8);
			}), 23, DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("item.armor.equip_netherite")), () -> Ingredient.of(new ItemStack(OresModItems.PLATINUM.get()), new ItemStack(Items.GOLD_INGOT)),
					List.of(new ArmorMaterial.Layer(ResourceLocation.parse("ores:reinforced_gold_armor"))), 5f, 0f);
			registerHelper.register(ResourceLocation.parse("ores:reinforced_gold_armor"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	public ReinforcedGoldArmorItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends ReinforcedGoldArmorItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(1024)).rarity(Rarity.UNCOMMON));
		}
	}

	public static class Chestplate extends ReinforcedGoldArmorItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(1024)).rarity(Rarity.UNCOMMON));
		}
	}

	public static class Leggings extends ReinforcedGoldArmorItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(1024)).rarity(Rarity.UNCOMMON));
		}
	}

	public static class Boots extends ReinforcedGoldArmorItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(1024)).rarity(Rarity.UNCOMMON));
		}
	}
}