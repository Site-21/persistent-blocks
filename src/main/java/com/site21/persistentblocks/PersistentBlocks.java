package com.site21.persistentblocks;

import net.minecraft.world.level.block.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

import java.util.Set;

@Mod(PersistentBlocks.MOD_ID)
public class PersistentBlocks {
    public static final String MOD_ID = "persistentblocks";
    public static final Set<Class<? extends Block>> persistentBlocks = Set.of(
            BushBlock.class,
            CandleBlock.class,
            CoralBlock.class,
            GrowingPlantBlock.class,
            FrogspawnBlock.class,
            BambooSaplingBlock.class
    );

    public PersistentBlocks(IEventBus modEventBus, ModContainer modContainer) {

    }
}
