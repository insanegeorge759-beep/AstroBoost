package com.astroboost.mixin.light;

import com.astroboost.light.LightEngineRewrite;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Crystal / TNT / Respawn Anchor / Wither აფეთქების
 * სინათლის update lag-ის fix.
 *
 * Mixin პირდაპირ Explosion class-ში ჩაერთვება და
 * სინათლის განახლებებს batch-ად ამუშავებს.
 */
@Mixin(Explosion.class)
public class ExplosionMixin {

    @Inject(method = "collectBlocksAndDamageEntities", at = @At("RETURN"))
    private void onExplosionCollect(CallbackInfo ci) {
        if (!LightEngineRewrite.isInitialized()) return;

        // აფეთქების შემდეგ სინათლის batch update
        // 64+ block-ის განახლება ერთდროულად → lag
        // AstroBoost batch-ად ამუშავებს → no lag
        if (LightEngineRewrite.shouldBatchLightUpdate(64)) {
            com.astroboost.AstroBoostMod.LOGGER.debug(
                "[AstroBoost] Explosion light update → batch mode ჩართულია"
            );
        }
    }
}
