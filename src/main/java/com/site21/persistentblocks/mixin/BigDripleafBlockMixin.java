package com.site21.persistentblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BigDripleafBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Tilt;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BigDripleafBlock.class)
public class BigDripleafBlockMixin {
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

    @Inject(at = @At("HEAD"), method = "tick", cancellable = true)
    protected void persistentblocks$tick(@NotNull BlockState state, ServerLevel level, BlockPos pos, net.minecraft.util.RandomSource random, CallbackInfo ci) {
        if (state.getValue(BlockStateProperties.PERSISTENT)) {
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "setTiltAndScheduleTick", cancellable = true)
    private void persistentblocks$setTiltAndScheduleTick(@NotNull BlockState state, Level level, BlockPos pos, Tilt tilt, SoundEvent sound, CallbackInfo ci) {
        if (state.getValue(BlockStateProperties.PERSISTENT)) {
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "resetTilt", cancellable = true)
    private static void persistentblocks$resetTilt(@NotNull BlockState state, Level level, BlockPos pos, CallbackInfo ci) {
        if (state.getValue(BlockStateProperties.PERSISTENT)) {
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "setTilt", cancellable = true)
    private static void persistentblocks$setTilt(@NotNull BlockState state, Level level, BlockPos pos, Tilt tilt, CallbackInfo ci) {
        if (state.getValue(BlockStateProperties.PERSISTENT)) {
            ci.cancel();
        }
    }
}
