package net.electrisoma.bloodisfuel;

import com.mojang.logging.LogUtils;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.electrisoma.bloodisfuel.datagen.BloodDatagen;
import net.electrisoma.bloodisfuel.registry.*;
import net.electrisoma.bloodisfuel.registry.blocks.BIF_Blocks;
import net.electrisoma.bloodisfuel.registry.fluids.BIF_Fluids;
import net.electrisoma.bloodisfuel.registry.items.BIF_Items;
import net.electrisoma.bloodisfuel.utils.BIF_Tags;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.Random;

@SuppressWarnings({"removal","all"})
@Mod(BloodIsFuel.MOD_ID)
public class BloodIsFuel {
    public static final String NAME = "Create: Blood is Fuel!";
    public static final String MOD_ID = "bloodisfuel";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final Random RANDOM = Create.RANDOM;

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    public BloodIsFuel(){
        ModLoadingContext modLoadingContext = ModLoadingContext.get();

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        REGISTRATE.registerEventListeners(modEventBus);

        BIF_Tags.init();
        CreativeTab.register(modEventBus);
        BIF_Blocks.register();
        BIF_Items.register();
        BIF_Fluids.register();

        modEventBus.addListener(EventPriority.LOWEST, BloodDatagen::gatherData);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> BloodClient.onCtorClient(modEventBus, forgeEventBus));
        modEventBus.addListener(BloodIsFuel::init);
        modEventBus.addListener(EventPriority.LOWEST, BloodDatagen::gatherData);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> BloodClient.onCtorClient(modEventBus, forgeEventBus));

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private static void init(final FMLCommonSetupEvent event) {
    }
    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}