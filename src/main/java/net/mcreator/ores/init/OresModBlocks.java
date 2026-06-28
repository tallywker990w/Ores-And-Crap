/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ores.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.ores.block.PlatinumOreBlock;
import net.mcreator.ores.OresMod;

public class OresModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(OresMod.MODID);
	public static final DeferredBlock<Block> PLATINUM_ORE;
	static {
		PLATINUM_ORE = REGISTRY.register("platinum_ore", PlatinumOreBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}