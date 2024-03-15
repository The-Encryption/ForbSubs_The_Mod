package com.twc.forbsubs.item;

import com.twc.forbsubs.ForbSubs;
import com.twc.forbsubs.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ForbSubs.MOD_ID);

    public static final RegistryObject<Item> CRIMSON_SHARD = ITEMS.register("crimson_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORBSUBS_TAB)));

    public static final RegistryObject<Item> CRIMSON_GEM = ITEMS.register("crimson_gem",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORBSUBS_TAB)));

    public static final RegistryObject<Item> GOLDEN_MEDALLION = ITEMS.register("golden_medallion",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORBSUBS_TAB)));

    public static final RegistryObject<Item> CRIMSON_MEDALLION = ITEMS.register("crimson_medallion",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORBSUBS_TAB)));

    public static final RegistryObject<Item> PESTLE_AND_MORTAR = ITEMS.register("pestle_and_mortar",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORBSUBS_TAB)));

    public static final RegistryObject<Item> GRAPE_SEEDS = ITEMS.register("grape_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GRAPE_VINES.get(), new Item.Properties().tab(ModCreativeModeTab.FORBSUBS_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
