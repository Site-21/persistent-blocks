package com.site21.persistentblocks.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CropBlock.class)
public class CropBlockMixin {
    @ModifyReturnValue(method = "isRandomlyTicking", at = @At("RETURN"))
    private boolean modifyIsRandomlyTickingReturnValue(boolean original, @NotNull BlockState state) {
        return !state.getValue(BlockStateProperties.PERSISTENT) && original;
    }
}
