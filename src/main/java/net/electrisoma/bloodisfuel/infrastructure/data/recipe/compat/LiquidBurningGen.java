package net.electrisoma.bloodisfuel.infrastructure.data.recipe.compat;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.electrisoma.bloodisfuel.infrastructure.data.recipe.BloodProcessingRecipeGen;
import net.electrisoma.bloodisfuel.registry.BIF_Fluids;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")
public class LiquidBurningGen extends BloodProcessingRecipeGen {
    GeneratedRecipe
            VISCERA =
            create(ResourceLocation.tryParse("viscera"), b -> b
                    .require(BIF_Fluids.OIL_ENRICHED_BLOOD.get(), 100)
                    .requiresHeat(HeatCondition.HEATED)
                    .duration(100)
                    .output(BIF_Fluids.DIESEL_INFUSED_BLOOD.get(),50)
                    .output(BIF_Fluids.GASOLINE_INFUSED_BLOOD.get(), 50));

    public LiquidBurningGen(PackOutput generator) {
        super(generator);
    }
    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.valueOf("liquid_burning");
    }
}