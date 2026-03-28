package com.astroboost;

import com.astroboost.chunk.ChunkEngineSystem;
import com.astroboost.light.LightEngineRewrite;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AstroBoostMod implements ModInitializer {

    public static final String MOD_ID = "astroboost";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("🚀 AstroBoost ჩაიტვირთა! ვერსია 1.0.0 | MC 1.21.11");

        // Light Engine Rewrite სისტემის ინიციალიზაცია
        LightEngineRewrite.init();

        // Chunk Engine System-ის ინიციალიზაცია
        ChunkEngineSystem.init();

        LOGGER.info("🚀 AstroBoost: ყველა სისტემა ჩართულია!");
    }
}
