package net.electrisoma.bloodisfuel.fabric.registry;

import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.electrisoma.bloodisfuel.registry.BModTab;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;

import java.util.function.Supplier;


public class BModTabImpl {
    private static final BModTab.TabInfo MAIN_TAB = register("main",
            () -> FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup.bloodisfuel"))
                    .icon(() -> Items.BEEF.getDefaultInstance())
                    .displayItems(new BModTab.RegistrateDisplayItemsGenerator(BModTab.Tabs.MAIN))
                    .build());

    public static ResourceKey<CreativeModeTab> getBaseTabKey() {
        return MAIN_TAB.key();
    }

    private static BModTab.TabInfo register(String name, Supplier<CreativeModeTab> supplier) {
        ResourceLocation id = BloodIsFuel.asResource(name);
        ResourceKey<CreativeModeTab> key = ResourceKey.create(Registries.CREATIVE_MODE_TAB, id);
        CreativeModeTab tab = supplier.get();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, key, tab);
        return new BModTab.TabInfo(key, tab);
    }

}
