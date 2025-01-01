package net.electrisoma.bloodisfuel.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTab {

    private static final DeferredRegister<CreativeModeTab> TAB_REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "bloodisfuel");

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = TAB_REGISTER.register("blood_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.blood_tab"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems((pParameters, output) -> {
                        output.accept(Fluids.BLOOD.getBucket().get());
                    })
                    .build());

    public static void register(IEventBus modEventBus) {
        TAB_REGISTER.register(modEventBus);
    }
}