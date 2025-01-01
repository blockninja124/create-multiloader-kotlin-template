package net.electrisoma.bloodisfuel;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.electrisoma.bloodisfuel.register.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(BloodIsFuel.MOD_ID)
public class BloodIsFuel {
    public static final String MOD_ID = "bloodisfuel";

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create("bloodisfuel");
    public BloodIsFuel() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Fluids.register();
        CreativeTab.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        REGISTRATE.registerEventListeners(modEventBus);
    }
}