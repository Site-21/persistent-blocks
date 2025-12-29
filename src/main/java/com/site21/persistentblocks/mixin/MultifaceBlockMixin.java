package com.site21.persistentblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.world.level.block.LeavesBlock.PERSISTENT;

@Mixin(MultifaceBlock.class)
public class MultifaceBlockMixin {
    @Inject(at = @At("HEAD"), method = "canSurvive", cancellable = true)
    protected void persistentblocks$canSurvive(@NotNull BlockState state, LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (state.hasProperty(PERSISTENT) && state.getValue(BlockStateProperties.PERSISTENT)) {
            cir.setReturnValue(true);
        }
    }
}
