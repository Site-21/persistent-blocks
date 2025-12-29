package com.site21.persistentblocks.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GrowingPlantHeadBlock.class)
public class GrowingPlantHeadBlockMixin {
    @ModifyReturnValue(method = "isRandomlyTicking", at = @At("RETURN"))
    private boolean modifyIsRandomlyTickingReturnValue(boolean original, @NotNull BlockState state) {
        return !state.getValue(BlockStateProperties.PERSISTENT) && original;
    }

    @Inject(at = @At("HEAD"), method = "updateShape", cancellable = true)
    protected void updateShape(@NotNull BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos, CallbackInfoReturnable<BlockState> cir) {
        if (state.getValue(BlockStateProperties.PERSISTENT)) {
            cir.setReturnValue(state);
        }
    }
}
