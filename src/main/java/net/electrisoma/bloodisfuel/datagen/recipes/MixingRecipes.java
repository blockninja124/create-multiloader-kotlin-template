package net.electrisoma.bloodisfuel.datagen.recipes;


import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.minecraft.data.PackOutput;
import net.electrisoma.bloodisfuel.registry.fluids.BIF_Fluids;
import net.minecraft.world.item.Items;

@SuppressWarnings({"all"})
public class MixingRecipes extends BloodProcessingRecipe {
    GeneratedRecipe
            BLOOD = create("blood", b -> b
            .require(BIF_Fluids.VISCERA.get(), 250)
            .output(BIF_Fluids.BLOOD.get(), 125)
            .requiresHeat(HeatCondition.HEATED)),

            ENRICHED_BLOOD = create("enriched_blood", b -> b
                    .require(BIF_Fluids.BLOOD.get(), 250)
                    .require(Items.SUGAR)
                    .output(BIF_Fluids.BLOOD.get(), 10));


    public MixingRecipes(PackOutput generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MIXING;
    }
}
