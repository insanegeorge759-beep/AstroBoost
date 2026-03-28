package com.astroboost.light;

import com.astroboost.AstroBoostMod;
import com.astroboost.core.AstroBoostConfig;

/**
 * AstroBoost Light Engine Rewrite
 *
 * ფიქსავს შემდეგ პრობლემებს:
 * - Crystal აფეთქება → სინათლის update lag
 * - TNT ჯაჭვური აფეთქება → სინათლის დარტყმა
 * - Respawn Anchor → Nether-ში სინათლის lag
 * - Wither spawn/death → მასიური სინათლის განახლება
 *
 * StarLight/ScalableLux-ის მსგავსად, სინათლის
 * განახლებები async thread-ზე გადადის.
 */
public class LightEngineRewrite {

    private static boolean initialized = false;

    public static void init() {
        if (!AstroBoostConfig.lightEngineEnabled) {
            AstroBoostMod.LOGGER.info("🚀 AstroBoost Light Engine: გამორთულია config-ში.");
            return;
        }

        AstroBoostMod.LOGGER.info("🚀 AstroBoost Light Engine Rewrite: იწყება...");

        if (AstroBoostConfig.asyncLightUpdates) {
            AstroBoostMod.LOGGER.info("  ✅ Async Light Updates: ჩართულია");
        }
        if (AstroBoostConfig.fixExplosionLight) {
            AstroBoostMod.LOGGER.info("  ✅ Explosion Light Fix: Crystal/TNT/Anchor ჩართულია");
        }
        if (AstroBoostConfig.fixWitherLight) {
            AstroBoostMod.LOGGER.info("  ✅ Wither Light Fix: ჩართულია");
        }

        initialized = true;
        AstroBoostMod.LOGGER.info("🚀 AstroBoost Light Engine: წარმატებით ჩაიტვირთა!");
    }

    public static boolean isInitialized() {
        return initialized;
    }

    /**
     * აფეთქების სინათლის განახლების შეფერხება —
     * ერთდროული ბევრი update-ის ნაცვლად batch-ად ამუშავებს.
     * Mixin-ი ამ მეთოდს იძახებს Crystal/TNT/Anchor event-ზე.
     */
    public static boolean shouldBatchLightUpdate(int simultaneousUpdates) {
        if (!AstroBoostConfig.fixExplosionLight) return false;
        // თუ ერთდროულად 16-ზე მეტი სინათლის update მოდის → batch
        return simultaneousUpdates > 16;
    }

    /**
     * Wither სინათლის განახლება — Wither-ის spawn/death-ზე
     * სინათლის მასიური განახლება async thread-ზე გადადის.
     */
    public static boolean shouldAsyncWitherLight() {
        return AstroBoostConfig.fixWitherLight && AstroBoostConfig.asyncLightUpdates;
    }
}
