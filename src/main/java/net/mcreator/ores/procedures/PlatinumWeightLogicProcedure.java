package net.mcreator.ores.procedures;

import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ores.init.OresModItems;

@EventBusSubscriber
public class PlatinumWeightLogicProcedure {

    // Unique identifier for your mod's scale modifier
    private static final ResourceLocation PLATINUM_SCALE_MODIFIER_ID = ResourceLocation.fromNamespaceAndPath("ores", "platinum_weight_scale");

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        execute(event.getEntity());
    }

    public static void execute(Entity entity) {
        if (entity == null) return;
        if (!(entity instanceof Player player)) return;

        // Run server-side to keep client visual rendering in sync
        if (player.level().isClientSide()) return;

        int totalPlatinumCount = 0;

        // Count platinum items
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (stack.is(OresModItems.RAW_PLATINUM.get()) || stack.is(OresModItems.PLATINUM.get())) {
                totalPlatinumCount += stack.getCount();
            }
        }

        AttributeInstance scaleAttribute = player.getAttribute(Attributes.SCALE);
        
        if (scaleAttribute != null) {
            // Remove any existing platinum modifier first to reset calculations cleanly
            scaleAttribute.removeModifier(PLATINUM_SCALE_MODIFIER_ID);

            if (totalPlatinumCount >= 64) {
                // Slowness V
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 4, false, false));
                
                // Multiply scale by 0.5 (Shrink to 50%)
                AttributeModifier heavyModifier = new AttributeModifier(PLATINUM_SCALE_MODIFIER_ID, -0.5D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
                scaleAttribute.addTransientModifier(heavyModifier);

            } else if (totalPlatinumCount > 0) {
                // Slowness II
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1, false, false));
                
                // Multiply scale by 0.8 (Shrink to 80%)
                AttributeModifier lightModifier = new AttributeModifier(PLATINUM_SCALE_MODIFIER_ID, -0.2D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
                scaleAttribute.addTransientModifier(lightModifier);
            }
        }
    }
}
