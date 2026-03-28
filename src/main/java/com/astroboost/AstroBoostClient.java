package com.astroboost;

import com.astroboost.gui.AstroBoostOptionsScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class AstroBoostClient implements ClientModInitializer {

    public static KeyBinding openGuiKey;

    @Override
    public void onInitializeClient() {
        // Keybind: F8 → AstroBoost GUI გახსნა
        openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.astroboost.opengui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F8,
                "category.astroboost"
        ));

        // Tick event - keybind შემოწმება
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (openGuiKey.wasPressed()) {
                client.setScreen(new AstroBoostOptionsScreen(null));
            }
        });

        AstroBoostMod.LOGGER.info("🚀 AstroBoost Client ჩაიტვირთა! F8 → GUI");
    }
}
