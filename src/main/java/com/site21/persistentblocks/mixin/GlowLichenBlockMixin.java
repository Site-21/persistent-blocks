package com.site21.persistentblocks.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GlowLichenBlock.class)
public class GlowLichenBlockMixin {
    @Inject(at = @At("HEAD"), method = "createBlockStateDefinition")
    protected void persistentblocks$createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder, CallbackInfo ci) {
        builder.add(BlockStateProperties.PERSISTENT);
    }
}
