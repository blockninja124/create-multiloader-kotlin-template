package net.electrisoma.bloodisfuel;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.electrisoma.bloodisfuel.registry.CreativeTab;
import net.electrisoma.bloodisfuel.registry.blocks.BIF_Blocks;
import net.electrisoma.bloodisfuel.registry.fluids.BIF_Fluids;
import net.electrisoma.bloodisfuel.registry.items.BIF_Items;
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

        BIF_Fluids.register();
        BIF_Items.register();
        BIF_Blocks.register();
        CreativeTab.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        REGISTRATE.registerEventListeners(modEventBus);
    }
}