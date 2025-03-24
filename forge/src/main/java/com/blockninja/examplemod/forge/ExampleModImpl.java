package com.blockninja.examplemod.forge;

import com.blockninja.examplemod.ExampleMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(ExampleMod.MOD_ID)
@Mod.EventBusSubscriber
public class ExampleModImpl {
    static IEventBus eventBus;

    public ExampleModImpl() {
        eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ExampleMod.init();
    }

    public static void finalizeRegistrate() {
        ExampleMod.registrate().registerEventListeners(eventBus);
    }
}
