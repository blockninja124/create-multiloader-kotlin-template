package net.electrisoma.bloodisfuel.forge;

import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(BloodIsFuel.MOD_ID)
@Mod.EventBusSubscriber
public class BloodIsFuelImpl {
    static IEventBus eventBus;

    public BloodIsFuelImpl() {
        eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BloodIsFuel.init();
    }

    public static void finalizeRegistrate() {
        BloodIsFuel.registrate().registerEventListeners(eventBus);
    }
}
