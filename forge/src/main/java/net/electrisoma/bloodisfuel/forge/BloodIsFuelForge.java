package net.electrisoma.bloodisfuel.forge;

import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.electrisoma.bloodisfuel.forge.registry.BModTabImpl;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(BloodIsFuel.MOD_ID)
@Mod.EventBusSubscriber
public class BloodIsFuelForge {
    static IEventBus eventBus;

    public BloodIsFuelForge() {
        eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BModTabImpl.register(BloodIsFuelForge.eventBus);

        BloodIsFuel.init();
    }
}
