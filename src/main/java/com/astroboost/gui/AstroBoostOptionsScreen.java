package com.astroboost.gui;

import com.astroboost.core.AstroBoostConfig;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class AstroBoostOptionsScreen extends Screen {

    private final Screen parent;
    private int scrollOffset = 0;

    public AstroBoostOptionsScreen(Screen parent) {
        super(Text.literal("🚀 AstroBoost Settings"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int x = this.width / 2;
        int startY = 50;
        int spacing = 26;
        int btnW = 200;
        int btnH = 20;
        int i = 0;

        // ═══════════════════════════════════
        // GRAPHICS სექცია
        // ═══════════════════════════════════

        // Particles
        addDrawableChild(ButtonWidget.builder(
                Text.literal("Particles: " + (AstroBoostConfig.particlesEnabled ? "§aOn" : "§cOff")),
                btn -> {
                    AstroBoostConfig.particlesEnabled = !AstroBoostConfig.particlesEnabled;
                    btn.setMessage(Text.literal("Particles: " + (AstroBoostConfig.particlesEnabled ? "§aOn" : "§cOff")));
                }
        ).dimensions(x - btnW / 2, startY + spacing * i++, btnW, btnH).build());

        // Animations
        addDrawableChild(ButtonWidget.builder(
                Text.literal("Animations: " + (AstroBoostConfig.animationsEnabled ? "§aOn" : "§cOff")),
                btn -> {
                    AstroBoostConfig.animationsEnabled = !AstroBoostConfig.animationsEnabled;
                    btn.setMessage(Text.literal("Animations: " + (AstroBoostConfig.animationsEnabled ? "§aOn" : "§cOff")));
                }
        ).dimensions(x - btnW / 2, startY + spacing * i++, btnW, btnH).build());

        // Water Animation
        addDrawableChild(ButtonWidget.builder(
                Text.literal("Water Animation: " + (AstroBoostConfig.waterAnimationEnabled ? "§aOn" : "§cOff")),
                btn -> {
                    AstroBoostConfig.waterAnimationEnabled = !AstroBoostConfig.waterAnimationEnabled;
                    btn.setMessage(Text.literal("Water Animation: " + (AstroBoostConfig.waterAnimationEnabled ? "§aOn" : "§cOff")));
                }
        ).dimensions(x - btnW / 2, startY + spacing * i++, btnW, btnH).build());

        // Lava Animation
        addDrawableChild(ButtonWidget.builder(
                Text.literal("Lava Animation: " + (AstroBoostConfig.lavaAnimationEnabled ? "§aOn" : "§cOff")),
                btn -> {
                    AstroBoostConfig.lavaAnimationEnabled = !AstroBoostConfig.lavaAnimationEnabled;
                    btn.setMessage(Text.literal("Lava Animation: " + (AstroBoostConfig.lavaAnimationEnabled ? "§aOn" : "§cOff")));
                }
        ).dimensions(x - btnW / 2, startY + spacing * i++, btnW, btnH).build());

        // Weather Effects
        addDrawableChild(ButtonWidget.builder(
                Text.literal("Weather Effects: " + (AstroBoostConfig.weatherEffectsEnabled ? "§aOn" : "§cOff")),
                btn -> {
                    AstroBoostConfig.weatherEffectsEnabled = !AstroBoostConfig.weatherEffectsEnabled;
                    btn.setMessage(Text.literal("Weather Effects: " + (AstroBoostConfig.weatherEffectsEnabled ? "§aOn" : "§cOff")));
                }
        ).dimensions(x - btnW / 2, startY + spacing * i++, btnW, btnH).build());

        // Portal Animation
        addDrawableChild(ButtonWidget.builder(
                Text.literal("Portal Animation: " + (AstroBoostConfig.portalAnimationEnabled ? "§aOn" : "§cOff")),
                btn -> {
                    AstroBoostConfig.portalAnimationEnabled = !AstroBoostConfig.portalAnimationEnabled;
                    btn.setMessage(Text.literal("Portal Animation: " + (AstroBoostConfig.portalAnimationEnabled ? "§aOn" : "§cOff")));
                }
        ).dimensions(x - btnW / 2, startY + spacing * i++, btnW, btnH).build());

        // Entity Animations
        addDrawableChild(ButtonWidget.builder(
                Text.literal("Entity Animations: " + (AstroBoostConfig.entityAnimationsEnabled ? "§aOn" : "§cOff")),
                btn -> {
                    AstroBoostConfig.entityAnimationsEnabled = !AstroBoostConfig.entityAnimationsEnabled;
                    btn.setMessage(Text.literal("Entity Animations: " + (AstroBoostConfig.entityAnimationsEnabled ? "§aOn" : "§cOff")));
                }
        ).dimensions(x - btnW / 2, startY + spacing * i++, btnW, btnH).build());

        // ═══════════════════════════════════
        // LIGHT ENGINE სექცია
        // ═══════════════════════════════════

        // Explosion Light Fix
        addDrawableChild(ButtonWidget.builder(
                Text.literal("Explosion Light Fix: " + (AstroBoostConfig.fixExplosionLight ? "§aOn" : "§cOff")),
                btn -> {
                    AstroBoostConfig.fixExplosionLight = !AstroBoostConfig.fixExplosionLight;
                    btn.setMessage(Text.literal("Explosion Light Fix: " + (AstroBoostConfig.fixExplosionLight ? "§aOn" : "§cOff")));
                }
        ).dimensions(x - btnW / 2, startY + spacing * i++, btnW, btnH).build());

        // Async Light Updates
        addDrawableChild(ButtonWidget.builder(
                Text.literal("Async Light Updates: " + (AstroBoostConfig.asyncLightUpdates ? "§aOn" : "§cOff")),
                btn -> {
                    AstroBoostConfig.asyncLightUpdates = !AstroBoostConfig.asyncLightUpdates;
                    btn.setMessage(Text.literal("Async Light Updates: " + (AstroBoostConfig.asyncLightUpdates ? "§aOn" : "§cOff")));
                }
        ).dimensions(x - btnW / 2, startY + spacing * i++, btnW, btnH).build());

        // ═══════════════════════════════════
        // HUD სექცია
        // ═══════════════════════════════════

        // FPS HUD
        addDrawableChild(ButtonWidget.builder(
                Text.literal("FPS HUD: " + (AstroBoostConfig.showFpsHud ? "§aOn" : "§cOff")),
                btn -> {
                    AstroBoostConfig.showFpsHud = !AstroBoostConfig.showFpsHud;
                    btn.setMessage(Text.literal("FPS HUD: " + (AstroBoostConfig.showFpsHud ? "§aOn" : "§cOff")));
                }
        ).dimensions(x - btnW / 2, startY + spacing * i++, btnW, btnH).build());

        // ═══════════════════════════════════
        // დახურვა
        // ═══════════════════════════════════
        addDrawableChild(ButtonWidget.builder(
                Text.literal("§aDone"),
                btn -> close()
        ).dimensions(x - btnW / 2, startY + spacing * i, btnW, btnH).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);

        // სათაური
        context.drawCenteredTextWithShadow(
                this.textRenderer,
                Text.literal("§6§l🚀 AstroBoost §r§7| §fSettings"),
                this.width / 2, 15, 0xFFFFFF
        );

        // სექციის სათაურები
        context.drawTextWithShadow(this.textRenderer, Text.literal("§e— Graphics —"), this.width / 2 - 100, 38, 0xFFFFFF);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public void close() {
        this.client.setScreen(parent);
    }
}
