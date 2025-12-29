package com.site21.persistentblocks.mixin;

import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CropBlock.class)
public class CropBlockMixin {
    @Inject(at = @At("RETURN"), method = "isRandomlyTicking", cancellable = true)
    protected void persistentblocks$isRandomlyTicking(@NotNull BlockState state, @NotNull CallbackInfoReturnable<Boolean> cir) {
        if (state.hasProperty(BlockStateProperties.PERSISTENT)) {
            cir.setReturnValue(!state.getValue(BlockStateProperties.PERSISTENT) && cir.getReturnValue());
        }
    }
}
