package com.twc.forbsubs.event;

import com.twc.forbsubs.ForbSubs;
import com.twc.forbsubs.recipe.CrimsonBoilerRecipe;
import com.twc.forbsubs.recipe.CrimsonForgeRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ForbSubs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, CrimsonForgeRecipe.Type.ID, CrimsonForgeRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, CrimsonBoilerRecipe.Type.ID, CrimsonBoilerRecipe.Type.INSTANCE);
    }
}