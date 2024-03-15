package com.twc.forbsubs.block;

import com.twc.forbsubs.ForbSubs;
import com.twc.forbsubs.block.custom.CrimsonBoilerBlock;
import com.twc.forbsubs.block.custom.CrimsonForgeBlock;
import com.twc.forbsubs.block.custom.GrapeVinesBlock;
import com.twc.forbsubs.item.ModCreativeModeTab;
import com.twc.forbsubs.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
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


    /*

    BLOCKS

    */


    // Regular blocks //

    public static final RegistryObject<Block> CRIMSON_BRICKS = registerBlock("crimson_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops()), ModCreativeModeTab.FORBSUBS_TAB);

    // Special blocks //

    public static final RegistryObject<Block> CRIMSON_BRICK_STAIRS = registerBlock("crimson_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.CRIMSON_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).
                    strength(9f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.FORBSUBS_TAB);
    public static final RegistryObject<Block> CRIMSON_BRICK_SLAB = registerBlock("crimson_brick_slab",
            () -> new StairBlock(() -> ModBlocks.CRIMSON_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).
                            strength(9f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.FORBSUBS_TAB);
    public static final RegistryObject<Block> CRIMSON_BRICK_WALL = registerBlock("crimson_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).
                            strength(9f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.FORBSUBS_TAB);
    public static final RegistryObject<Block> CRIMSON_BRICK_GATE = registerBlock("crimson_brick_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.STONE).
                    strength(9f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.FORBSUBS_TAB);


    // Block Entities //

    // Crops

    public static final RegistryObject<Block> GRAPE_VINES = registerBlockWithoutBlockItem("grape_vines",
            () -> new GrapeVinesBlock(BlockBehaviour.Properties.of(Material.PLANT).noOcclusion().strength(1f)));

    // Crops end

    public static final RegistryObject<Block> CRIMSON_FORGE = registerBlock("crimson_forge",
            () -> new CrimsonForgeBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(9f).requiresCorrectToolForDrops()), ModCreativeModeTab.FORBSUBS_TAB);
    public static final RegistryObject<Block> CRIMSON_BOILER = registerBlock("crimson_boiler",
            () -> new CrimsonBoilerBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(9f).noOcclusion().requiresCorrectToolForDrops()),
            ModCreativeModeTab.FORBSUBS_TAB);


    /*

    BLOCKS

    */


    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem (String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

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
