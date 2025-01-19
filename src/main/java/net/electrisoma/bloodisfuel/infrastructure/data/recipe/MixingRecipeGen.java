package net.electrisoma.bloodisfuel.infrastructure.data.recipe;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.electrisoma.bloodisfuel.Mods;
import net.electrisoma.bloodisfuel.infrastructure.data.tags.BloodRegistrateTags;
import net.electrisoma.bloodisfuel.registry.BIF_Fluids;
import net.electrisoma.bloodisfuel.registry.BloodTags;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;



@SuppressWarnings({"all"})
public class MixingRecipeGen extends BloodProcessingRecipeGen {

    GeneratedRecipe
            VISCERA_TO_BLOOD =
            create("viscera_to_blood", b -> b
                    .require(BloodTags.AllFluidTags.VISCERA.tag,1000)
                    .requiresHeat(HeatCondition.HEATED)
                    .output(BIF_Fluids.BLOOD.get(), 500)),

            OIL_ENRICHED_BLOOD =
            create("oil_enriched_blood", b -> b
                    .require(BloodTags.AllFluidTags.CRUDE_OIL.tag,500)
                    .require(BloodTags.AllFluidTags.BLOOD.tag,500)
                    .requiresHeat(HeatCondition.SUPERHEATED)
                    .output(BIF_Fluids.OIL_ENRICHED_BLOOD.get(), 250)),

            ENRICHED_BLOOD_FROM_SUGARS =
            create("enriched_blood_from_carbohydrates", b -> b
                    .require(BloodTags.AllFluidTags.BLOOD.tag,1000)
                    .require(BloodTags.AllItemTags.CARBOHYDRATES.tag)
                    .requiresHeat(HeatCondition.SUPERHEATED)
                    .output(BIF_Fluids.ENRICHED_BLOOD.get(), 500));

            //Biofactory
//            ENRICHED_BLOOD_FROM_NUTRIENT_FLUID =
//            create("enriched_blood_from_nutrient_fluid", b -> b
//                    .require(BloodTags.AllFluidTags.BLOOD.tag,1000)
//                    .require(new ResourceLocation("biofactory:nutrient_fluid"))
//                    .requiresHeat(HeatCondition.SUPERHEATED)
//                    .output(BIF_Fluids.ENRICHED_BLOOD.get(), 500)),
//
//            //Biomancy
//            ENRICHED_BLOOD_FROM_NUTRIENT_PASTE =
//            create("enriched_blood_from_nutrient_paste", b -> b
//                    .require(BloodTags.AllFluidTags.BLOOD.tag,1000)
//                    .require(new ResourceLocation("biomancy:nutrient_paste"))
//                    .require(new ResourceLocation("biomancy:nutrient_paste"))
//                    .require(new ResourceLocation("biomancy:nutrient_paste"))
//                    .require(new ResourceLocation("biomancy:nutrient_paste"))
//                    .require(new ResourceLocation("biomancy:nutrient_paste"))
//                    .require(new ResourceLocation("biomancy:nutrient_paste"))
//                    .require(new ResourceLocation("biomancy:nutrient_paste"))
//                    .require(new ResourceLocation("biomancy:nutrient_paste"))
//                    .requiresHeat(HeatCondition.SUPERHEATED)
//                    .output(BIF_Fluids.ENRICHED_BLOOD.get(), 500)),
//
//            ENRICHED_BLOOD_FROM_NUTRIENT_BAR =
//            create("enriched_blood_from_nutrient_bar", b -> b
//                    .require(BloodTags.AllFluidTags.BLOOD.tag,1000)
//                    .require(new ResourceLocation("biomancy:nutrient_bar"))
//                    .requiresHeat(HeatCondition.SUPERHEATED)
//                    .output(BIF_Fluids.ENRICHED_BLOOD.get(), 500));

    public MixingRecipeGen(PackOutput generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MIXING;
    }
}