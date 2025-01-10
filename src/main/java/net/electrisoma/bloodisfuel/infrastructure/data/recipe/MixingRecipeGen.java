package net.electrisoma.bloodisfuel.infrastructure.data.recipe;

import com.github.elenterius.biofactory.init.ModFluids;
import com.github.elenterius.biomancy.init.ModFoods;
import com.github.elenterius.biomancy.init.ModItems;
import com.github.elenterius.biomancy.init.tags.ModItemTags;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.data.recipe.Mods;
import net.electrisoma.bloodisfuel.registry.BIF_Fluids;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

@SuppressWarnings({"all"})
public class MixingRecipeGen extends BloodProcessingRecipeGen {

    GeneratedRecipe
            VISCERA_TO_BLOOD =
                    create("viscera_to_blood", b -> b
                    .require(BIF_Fluids.VISCERA.get(), 1000)
                    .requiresHeat(HeatCondition.HEATED)
                    .output(BIF_Fluids.BLOOD.get(), 500)),

            ENRICHED_BLOOD_FROM_NUTRIENT_FLUID =
                    create("enriched_blood_from_nutrient_fluid", b -> b
                    .require(BIF_Fluids.BLOOD.get(), 1000)
                    .require(ModFluids.NUTRIENTS_FLUID.get(), 500)
                    .requiresHeat(HeatCondition.SUPERHEATED)
                    .output(BIF_Fluids.ENRICHED_BLOOD.get(), 500)),

            ENRICHED_BLOOD_FROM_SUGARS =
                     create("enriched_blood_from_sugars", b -> b
                     .require(BIF_Fluids.BLOOD.get(), 1000)
                     .require(ModItemTags.SUGARS)
                     .requiresHeat(HeatCondition.SUPERHEATED)
                     .output(BIF_Fluids.ENRICHED_BLOOD.get(), 500)),

            ENRICHED_BLOOD_FROM_NUTRIENT_PASTE =
                    create("enriched_blood_from_nutrient_paste", b -> b
                    .require(BIF_Fluids.BLOOD.get(), 1000)
                    .require(ModItems.NUTRIENT_PASTE.get())
                    .require(ModItems.NUTRIENT_PASTE.get())
                    .require(ModItems.NUTRIENT_PASTE.get())
                    .require(ModItems.NUTRIENT_PASTE.get())
                    .requiresHeat(HeatCondition.SUPERHEATED)
                    .output(BIF_Fluids.ENRICHED_BLOOD.get(), 500)),

            ENRICHED_BLOOD_FROM_NUTRIENT_BAR =
                    create("enriched_blood_from_nutrient_bar", b -> b
                    .require(BIF_Fluids.BLOOD.get(), 1000)
                    .require(ModItems.NUTRIENT_BAR.get())
                    .requiresHeat(HeatCondition.SUPERHEATED)
                    .output(BIF_Fluids.ENRICHED_BLOOD.get(), 500));

    public MixingRecipeGen(PackOutput generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MIXING;
    }
}
