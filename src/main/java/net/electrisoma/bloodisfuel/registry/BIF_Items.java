package net.electrisoma.bloodisfuel.registry;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import static net.electrisoma.bloodisfuel.BloodIsFuel.REGISTRATE;

public class BIF_Items {
    public static final ItemEntry<Item> GROUND_MEAT = REGISTRATE.item("ground_meat", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(0).saturationMod(0.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.POISON, 100),1.0f)
                    .build()))
            .lang("Ground Meat")
            .register();

    public static void register() {}
}
