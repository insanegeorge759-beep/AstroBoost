package com.astroboost.core;

public class AstroBoostConfig {

    // ──────────────────────────────────────────
    // CHUNK ENGINE
    // ──────────────────────────────────────────
    public static boolean chunkEngineEnabled = true;
    public static int chunkThreadCount = 2;          // Celeron-ისთვის 2 thread
    public static boolean prioritizePlayerChunks = true;
    public static boolean c2meCompatMode = true;     // C2ME თავსებადობა

    // ──────────────────────────────────────────
    // LIGHT ENGINE
    // ──────────────────────────────────────────
    public static boolean lightEngineEnabled = true;
    public static boolean fixExplosionLight = true;  // Crystal/TNT/Anchor fix
    public static boolean fixWitherLight = true;
    public static boolean asyncLightUpdates = true;

    // ──────────────────────────────────────────
    // GRAPHICS - თავიდანვე LOW FPS რეჟიმი
    // ──────────────────────────────────────────
    public static boolean particlesEnabled = false;       // გამორთული
    public static boolean animationsEnabled = false;      // გამორთული
    public static boolean entityAnimationsEnabled = false;
    public static boolean weatherEffectsEnabled = false;  // წვიმა/თოვლი გამორთული
    public static boolean drippingEnabled = false;        // წვეთები გამორთული
    public static boolean flameAnimationEnabled = false;  // ცეცხლი სტატიკური
    public static boolean waterAnimationEnabled = false;  // წყალი სტატიკური
    public static boolean lavaAnimationEnabled = false;
    public static boolean portalAnimationEnabled = false;
    public static boolean blockAnimationEnabled = false;

    // ──────────────────────────────────────────
    // HUD
    // ──────────────────────────────────────────
    public static boolean showFpsHud = true;
    public static boolean showChunkStatus = false;
    public static boolean showLightStatus = false;
}
