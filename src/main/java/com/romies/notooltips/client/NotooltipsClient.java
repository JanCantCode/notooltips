package com.romies.notooltips.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class NotooltipsClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(ClientCommandManager.literal("notooltips").executes(context -> {
            MinecraftClient.getInstance().options.heldItemTooltips = !MinecraftClient.getInstance().options.heldItemTooltips;
            context.getSource().sendFeedback(Text.of("§cToggled held item tooltips!"));
            return 1;
        })));
    }
}
