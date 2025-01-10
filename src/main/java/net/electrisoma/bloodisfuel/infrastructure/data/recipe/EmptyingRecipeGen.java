package net.electrisoma.bloodisfuel.infrastructure.data.recipe;

import com.github.elenterius.biomancy.init.tags.ModItemTags;
import com.simibubi.create.AllRecipeTypes;
import net.electrisoma.bloodisfuel.registry.BIF_Fluids;
import net.minecraft.data.PackOutput;

@SuppressWarnings("unused")
public class EmptyingRecipeGen extends BloodProcessingRecipeGen{
    GeneratedRecipe
        VISCERA_FROM_MEATS =
            create("viscera_from_meats", b -> b
            .require(ModItemTags.RAW_MEATS)
            .output(BIF_Fluids.VISCERA.get(), 100));

    public EmptyingRecipeGen(PackOutput generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.EMPTYING;
    }
}
