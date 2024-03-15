package com.twc.forbsubs;

import com.mojang.logging.LogUtils;
import com.twc.forbsubs.block.ModBlocks;
import com.twc.forbsubs.block.entity.ModBlockEntities;
import com.twc.forbsubs.item.ModItems;
import com.twc.forbsubs.recipe.ModRecipes;
import com.twc.forbsubs.screen.CrimsonBoilerScreen;
import com.twc.forbsubs.screen.CrimsonForgeScreen;
import com.twc.forbsubs.screen.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

@Mod(ForbSubs.MOD_ID)
public class ForbSubs {

    public static final String MOD_ID = "forbsubs";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public ForbSubs() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);

        ModRecipes.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        MenuScreens.register(ModMenuTypes.CRIMSON_FORGE_MENU.get(), CrimsonForgeScreen::new);
        MenuScreens.register(ModMenuTypes.CRIMSON_BOILER_MENU.get(), CrimsonBoilerScreen::new);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRIMSON_BOILER.get(), RenderType.translucent());
    }

    ;
}