package com.site21.persistentblocks.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.site21.persistentblocks.PersistentBlocks.persistentBlocks;

@Mixin(Block.class)
public class BlockMixin {
    @Unique
    public Block persistentblocks$getThis() {
        return (Block)(Object) this;
    }

    @WrapOperation(
        method = "<init>",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/Block;createBlockStateDefinition(Lnet/minecraft/world/level/block/state/StateDefinition$Builder;)V"
        )
    )
    private void persistentblocks$wrapCreateBlockStateDefinition(Block instance, StateDefinition.Builder<Block, BlockState> builder, Operation<Void> original) {
        if (persistentblocks$isPersistentBlock()) {
            builder.add(BlockStateProperties.PERSISTENT);
        }
        original.call(instance, builder);
    }

    @Unique
    private boolean persistentblocks$isPersistentBlock() {
        Block block = persistentblocks$getThis();
        for (Class<? extends Block> blockClass : persistentBlocks) {
            if (blockClass.isInstance(block)) {
                return true;
            }
        }
        return false;
    }


    @Inject(at = @At("HEAD"), method = "canSupportCenter", cancellable = true)
    private static void persistentblocks$canSupportCenter(@NotNull LevelReader level, BlockPos pos, Direction direction, @NotNull CallbackInfoReturnable<Boolean> cir) {
        BlockState state = level.getBlockState(pos);
        if (state.hasProperty(BlockStateProperties.PERSISTENT) && state.getValue(BlockStateProperties.PERSISTENT)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(at = @At("HEAD"), method = "canSupportRigidBlock", cancellable = true)
    private static void persistentblocks$canSupportRigidBlock(@NotNull BlockGetter level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BlockState state = level.getBlockState(pos);
        if (state.hasProperty(BlockStateProperties.PERSISTENT) && state.getValue(BlockStateProperties.PERSISTENT)) {
            cir.setReturnValue(true);
        }
    }

}

