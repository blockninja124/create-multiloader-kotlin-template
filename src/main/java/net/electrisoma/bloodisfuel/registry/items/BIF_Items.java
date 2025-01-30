package net.electrisoma.bloodisfuel.registry.items;

import com.simibubi.create.foundation.data.AssetLookup;
import net.electrisoma.bloodisfuel.BloodIsFuel;

import com.tterrag.registrate.util.entry.ItemEntry;

import net.electrisoma.bloodisfuel.registry.BIF_Tags;
import net.electrisoma.bloodisfuel.registry.CreativeTabs;
import net.electrisoma.bloodisfuel.registry.items.syringe_blade.SyringeBladeItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Rarity;

import static net.electrisoma.bloodisfuel.BloodIsFuel.REGISTRATE;


@SuppressWarnings({"all"})
public class BIF_Items {
    static {
        REGISTRATE.setCreativeTab(CreativeTabs.BASE_CREATIVE_TAB);
    }

    public static final ItemEntry<Item> DRAINED_MEAT =
            REGISTRATE.item("drained_meat", Item::new)
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
                    .lang("Drained Meat")
                    .tab(CreativeTabs.BASE_CREATIVE_TAB.getKey())
                    .register();

    public static final ItemEntry<SyringeBladeItem>
            SYRINGE_BLADE = REGISTRATE
            .item("syringe_blade",
                    p -> new SyringeBladeItem(Tiers.IRON,3,-2.4f,p))
            .model(AssetLookup.itemModelWithPartials())
            .tag(BIF_Tags.AllItemTags.SYRINGE_BLADE.tag)
            .register();

    public static void register() {}
}