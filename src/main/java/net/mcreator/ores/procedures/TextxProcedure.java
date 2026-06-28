package net.mcreator.ores.procedures;

import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

@EventBusSubscriber
public class TextxProcedure {

    // Automatically trigger this procedure whenever a player joins the world/server
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        execute(event.getEntity().level(), event.getEntity());
    }

    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null || world == null) return;

        // Ensure it runs on the server side and the target is a real player
        if (!world.isClientSide() && entity instanceof ServerPlayer serverPlayer) {
            
            // Check if the player has already seen this greeting before
            if (!serverPlayer.getPersistentData().getBoolean("hasSeenModGreeting")) {
                
                // Execute your title command securely
                serverPlayer.getServer().getCommands().performPrefixedCommand(
                    serverPlayer.createCommandSourceStack().withPermission(4).withSuppressedOutput(),
                    "title @s title {\"text\":\"Hope you love this mod!\",\"color\":\"red\",\"bold\":true}"
                );
                
                // Mark the player so they never trigger this procedure again
                serverPlayer.getPersistentData().putBoolean("hasSeenModGreeting", true);
            }
        }
    }
}
