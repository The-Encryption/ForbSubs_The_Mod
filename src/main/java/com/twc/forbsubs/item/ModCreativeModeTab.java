package com.twc.forbsubs.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab FORBSUBS_TAB = new CreativeModeTab("forbsubs") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CRIMSON_SHARD.get());
        }
    };
}
