package com.site21.persistentblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HangingRootsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HangingRootsBlock.class)
public class HangingRootsBlockMixin {
    @Inject(at = @At("HEAD"), method = "createBlockStateDefinition")
    protected void persistentblocks$createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder, CallbackInfo ci) {
        builder.add(BlockStateProperties.PERSISTENT);
    }

    @Inject(at = @At("HEAD"), method = "canSurvive", cancellable = true)
    protected void persistentblocks$canSurvive(@NotNull BlockState state, LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (state.getValue(BlockStateProperties.PERSISTENT)) {
            cir.setReturnValue(true);
        }
    }
}
