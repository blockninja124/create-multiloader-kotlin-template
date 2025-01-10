package net.electrisoma.bloodisfuel.registry;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Rarity;

import static net.electrisoma.bloodisfuel.BloodIsFuel.REGISTRATE;

@SuppressWarnings({"unused", "deprecation", "all"})
public class BIF_Items {
    public static final ItemEntry<Item> GROUND_MEAT =
            REGISTRATE.item("ground_meat", Item::new)
                    .model((c, p) -> p
                            .withExistingParent(c.getId().getPath(),
                            new ResourceLocation("item/generated")).texture("layer0",
                            new ResourceLocation(BloodIsFuel.MOD_ID,"item/" + c.getId().getPath())))

                    .properties(p -> p
                    .rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder()
                    .meat()
                    .nutrition(4)
                            .saturationMod(0.1f)
                    .effect(new MobEffectInstance(MobEffects.HUNGER,
                            600, 0),0.8f)
                    .effect(new MobEffectInstance(MobEffects.POISON,
                            300, 2),0.8f)
                    .build()))
                    .tag(BloodTags.AllItemTags.GROUND_MEAT.tag)
                    .lang("Ground Meat")
                    .tab(CreativeTabs.BASE_CREATIVE_TAB.getKey())
                    .register();

    private static ItemEntry<Item> item(String name) {
        ResourceKey<CreativeModeTab> tab = CreativeTabs.BASE_CREATIVE_TAB.getKey();
        assert tab != null;
        return REGISTRATE.item(name, Item::new)
                .tab(tab)
                .register();
    }

    public static void register() {}
}