package net.electrisoma.bloodisfuel;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class BloodClient {
    public static void onCtorClient(IEventBus modEventBus, IEventBus forgeEventBus) {
        modEventBus.addListener(BloodClient::clientInit);;
    }


    public static void clientInit(final FMLClientSetupEvent event) {

    }
}
