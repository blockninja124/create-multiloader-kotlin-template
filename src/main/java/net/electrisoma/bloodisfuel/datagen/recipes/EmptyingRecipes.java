package net.electrisoma.bloodisfuel.datagen.recipes;


import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.electrisoma.bloodisfuel.registry.fluids.BIF_Fluids;
import net.electrisoma.bloodisfuel.utils.BIF_Tags;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;



@SuppressWarnings({"all"})
public class EmptyingRecipes extends BloodProcessingRecipe {
    GeneratedRecipe
            VISCERA_FROM_COD = create("viscera", b -> b
                    .require(BIF_Tags.forgeItemTag("cod"))
                    .output(BIF_Fluids.VISCERA.get(), 10)),
            VISCERA_FROM_SALMON = create("viscera", b -> b
                    .require(BIF_Tags.forgeItemTag("salmon"))
                    .output(BIF_Fluids.VISCERA.get(), 10)),
            VISCERA_FROM_TROPICAL_FISH = create("viscera", b -> b
                    .require(BIF_Tags.forgeItemTag("tropical_fish"))
                    .output(BIF_Fluids.VISCERA.get(), 10));

    public EmptyingRecipes(PackOutput generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.EMPTYING;
    }
}
