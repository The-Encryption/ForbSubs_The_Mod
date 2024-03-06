package com.twc.forbsubs.block;

import com.twc.forbsubs.ForbSubs;
import com.twc.forbsubs.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ForbSubs.MOD_ID);

    public static final RegistryObject<Block> CRIMSON_FORGE = registerBlock("crimson_forge",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(9f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> CRIMSON_BOILER = registerBlock("crimson_boiler",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(9f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_DECORATIONS);

    private static <T extends Block> RegistryObject<T> registerBlock (String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem (String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
