package com.twc.forbsubs.block.custom;

import com.twc.forbsubs.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class GrapeVinesBlock extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;
    public GrapeVinesBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getMaxAge() {
        return 5;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.GRAPE_SEEDS.get();
    }
}
