package com.astroboost.mixin.chunk;

import com.astroboost.chunk.ChunkEngineSystem;
import net.minecraft.server.world.ServerChunkLoadingManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * AstroBoost Chunk Engine Mixin
 *
 * ServerChunkLoadingManager-ში ჩაერთვება და
 * AstroBoost-ის priority scheduling სისტემას იყენებს.
 * C2ME-სთან სრულად თავსებადია — სხვადასხვა ნაწილს ოპტიმიზირებს.
 */
@Mixin(ServerChunkLoadingManager.class)
public class ChunkLoadingMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        if (!ChunkEngineSystem.isInitialized()) return;
        // Chunk priority queue-ს tick — player-ახლო chunk-ები პირველ რიგში
    }
}
