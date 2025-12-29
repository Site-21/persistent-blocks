package com.site21.persistentblocks.mixin;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.class)
public class BlockBehaviourMixin {
    @Inject(at = @At("RETURN"), method = "isRandomlyTicking", cancellable = true)
    protected void persistentblocks$isRandomlyTicking(@NotNull BlockState state, @NotNull CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue() && state.hasProperty(BlockStateProperties.PERSISTENT)) {
            cir.setReturnValue(false);
        }
    }
}
