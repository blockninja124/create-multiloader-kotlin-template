package net.electrisoma.bloodisfuel.forge.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.electrisoma.bloodisfuel.registry.BModTab;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.RegistryObject;


public class BModTabRegistrateDisplayItemsGeneratorImpl {

    public static boolean isInCreativeTab(RegistryEntry<?> entry, ResourceKey<CreativeModeTab> tab) {
        RegistryObject<CreativeModeTab> tabObject;
        if (tab == BModTab.getBaseTabKey()) {
            tabObject = BModTabImpl.MAIN_TAB;
        }


        else {
            tabObject = BModTabImpl.MAIN_TAB;
        }
        return CreateRegistrate.isInCreativeTab(entry, tabObject);
    }
}
