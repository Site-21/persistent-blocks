package com.site21.persistentblocks.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(WallBlock.class)
public class WallBlockMixin {
//    @Inject(at = @At("HEAD"), method = "createBlockStateDefinition")
//    protected void persistentblocks$createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder, CallbackInfo ci) {
//        builder.add(BlockStateProperties.PERSISTENT);
//    }

//
//    @Inject(at = @At("RETURN"), method = "updateShape(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/Direction;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;", cancellable = true)
//    protected void updateShape(@NotNull BlockState state, Direction facing, BlockState facingState, @NotNull LevelAccessor level, BlockPos currentPos, BlockPos facingPos, CallbackInfoReturnable<BlockState> cir) {
//        if (state.hasProperty(BlockStateProperties.PERSISTENT) && state.getValue(BlockStateProperties.PERSISTENT)) {
//            cir.setReturnValue(state);
//        }
//    }
//
//    @Inject(at = @At("HEAD"), method = "updateShape(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;ZZZZ)Lnet/minecraft/world/level/block/state/BlockState;", cancellable = true)
//    protected void persistentblocks$updateShape(LevelReader level, @NotNull BlockState state, BlockPos pos, BlockState neighbour, boolean northConnection, boolean eastConnection, boolean southConnection, boolean westConnection, CallbackInfoReturnable<BlockState> cir) {
//        if (state.getValue(BlockStateProperties.PERSISTENT)) {
//            cir.setReturnValue(state);
//        }
//    }
}
