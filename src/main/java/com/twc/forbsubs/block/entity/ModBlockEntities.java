package com.twc.forbsubs.block.entity;

import com.twc.forbsubs.ForbSubs;
import com.twc.forbsubs.block.ModBlocks;
import com.twc.forbsubs.block.entity.custom.CrimsonForgeBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ForbSubs.MOD_ID);

    public static final RegistryObject<BlockEntityType<CrimsonForgeBlockEntity>> CRIMSON_FORGE_ENTITY =
            BLOCK_ENTITIES.register("crimson_forge_entity", () ->
                    BlockEntityType.Builder.of(CrimsonForgeBlockEntity::new,
                            ModBlocks.CRIMSON_FORGE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}