package net.electrisoma.bloodisfuel.registry.fluids;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import static net.electrisoma.bloodisfuel.BloodIsFuel.REGISTRATE;

public class BIF_Fluids {
    public static final FluidEntry<ForgeFlowingFluid.Flowing> VISCERA =
            REGISTRATE.fluid("viscera",
                            new ResourceLocation("bloodisfuel:block/viscera_still"),
                            new ResourceLocation("bloodisfuel:block/viscera_flow"))
                    .lang("Viscera")
                    .properties(b -> b
                            .viscosity(1500)
                            .density(500))
                    .fluidProperties(p -> p
                            .levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> BLOOD =
            REGISTRATE.fluid("blood",
                            new ResourceLocation("bloodisfuel:block/blood_still"),
                            new ResourceLocation("bloodisfuel:block/blood_flow"))
                    .lang("Blood")
                    .properties(b -> b
                            .viscosity(1500)
                            .density(500))
                    .fluidProperties(p -> p
                            .levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .register();


    public static final FluidEntry<ForgeFlowingFluid.Flowing> ENRICHED_BLOOD =
            REGISTRATE.fluid("enriched_blood",
                            new ResourceLocation("bloodisfuel:block/enriched_blood_still"),
                            new ResourceLocation("bloodisfuel:block/enriched_blood_flow"))
                    .lang("Enriched_Blood")
                    .properties(b -> b
                            .viscosity(1500)
                            .density(500))
                    .fluidProperties(p -> p
                            .levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .register();

    public static void register() {}
}