package net.electrisoma.bloodisfuel.infrastructure.data.recipe;

import com.simibubi.create.AllRecipeTypes;
import net.electrisoma.bloodisfuel.registry.BIF_Fluids;
import net.electrisoma.bloodisfuel.registry.BloodTags;
import net.minecraft.data.PackOutput;


@SuppressWarnings("unused")
public class CompactingRecipeGen extends BloodProcessingRecipeGen{
    GeneratedRecipe
            VISCERA_FROM_MEATS =
            create("viscera_from_meats", b -> b
                    .require(BloodTags.AllItemTags.MEATS.tag)
                    .output(BIF_Fluids.VISCERA.get(), 100)),

            VISCERA_FROM_FISHES =
            create("viscera_from_fishes", b -> b
                    .require(BloodTags.AllItemTags.FISHES.tag)
                    .output(BIF_Fluids.VISCERA.get(), 25));

    public CompactingRecipeGen(PackOutput generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.COMPACTING;
    }
}