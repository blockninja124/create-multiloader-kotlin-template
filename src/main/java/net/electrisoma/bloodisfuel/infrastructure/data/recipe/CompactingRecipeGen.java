package net.electrisoma.bloodisfuel.infrastructure.data.recipe;

import com.simibubi.create.AllRecipeTypes;
import net.electrisoma.bloodisfuel.registry.BIF_Fluids;
import net.electrisoma.bloodisfuel.registry.BloodTags;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;


@SuppressWarnings("unused")
public class CompactingRecipeGen extends BloodProcessingRecipeGen{
    GeneratedRecipe
//            VISCERA_FROM_MEATS =
//            create("viscera_from_meats", b -> b
//                    .require(BloodTags.AllItemTags.MEATS.tag)
//                    .output(BIF_Fluids.VISCERA.get(), 100)
//                    .output(BloodTags.AllItemTags.MEATS.tag)),
//
//            VISCERA_FROM_FISHES =
//            create("viscera_from_fishes", b -> b
//                    .require(BloodTags.AllItemTags.FISHES.tag)
//                    .output(BIF_Fluids.VISCERA.get(), 25));

            VISCERA_FROM_BEEF =
                    create("viscera_from_beef", b -> b
                    .require(Items.BEEF)
                    .output(BIF_Fluids.VISCERA.get(), 100)
                    .output(.4F, Items.BEEF)),

            VISCERA_FROM_PORK =
            create("viscera_from_pork", b -> b
                    .require(Items.PORKCHOP)
                    .output(BIF_Fluids.VISCERA.get(), 100)
                    .output(.4F, Items.PORKCHOP)),

            VISCERA_FROM_MUTTON =
            create("viscera_from_mutton", b -> b
                    .require(Items.MUTTON)
                    .output(BIF_Fluids.VISCERA.get(), 100)
                    .output(.4F, Items.MUTTON)),

            VISCERA_FROM_RABBIT =
            create("viscera_from_rabbit", b -> b
                    .require(Items.RABBIT)
                    .output(BIF_Fluids.VISCERA.get(), 100)
                    .output(.4F, Items.RABBIT)),

            VISCERA_FROM_FLESH =
            create("viscera_from_flesh", b -> b
                    .require(Items.ROTTEN_FLESH)
                    .output(BIF_Fluids.VISCERA.get(), 100)
                    .output(.4F, Items.ROTTEN_FLESH)),


            VISCERA_FROM_COD =
            create("viscera_from_cod", b -> b
                    .require(Items.COD)
                    .output(BIF_Fluids.VISCERA.get(), 25)
                    .output(.4F, Items.COD)),

            VISCERA_FROM_SALMON =
            create("viscera_from_salmon", b -> b
                    .require(Items.SALMON)
                    .output(BIF_Fluids.VISCERA.get(), 25)
                    .output(.4F, Items.SALMON)),

            VISCERA_FROM_TROPICAL_FISH =
            create("viscera_from_tropical_fish", b -> b
                    .require(Items.TROPICAL_FISH)
                    .output(BIF_Fluids.VISCERA.get(), 25)
                    .output(.4F, Items.TROPICAL_FISH)),

            VISCERA_FROM_PUFFERFISH =
            create("viscera_from_pufferfish", b -> b
                    .require(Items.PUFFERFISH)
                    .output(BIF_Fluids.VISCERA.get(), 25)
                    .output(.4F, Items.PUFFERFISH));

    public CompactingRecipeGen(PackOutput generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.COMPACTING;
    }
}