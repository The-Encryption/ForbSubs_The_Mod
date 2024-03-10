package com.twc.forbsubs.recipe;

import com.twc.forbsubs.ForbSubs;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ForbSubs.MOD_ID);

    public static final RegistryObject<RecipeSerializer<CrimsonForgeRecipe>> CRIMSON_FORGE_SERIALIZER =
            SERIALIZERS.register("ascendant_forging", () -> CrimsonForgeRecipe.Serializer.INSTANCE);


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
