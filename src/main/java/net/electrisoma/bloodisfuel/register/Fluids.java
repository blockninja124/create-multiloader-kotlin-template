package net.electrisoma.bloodisfuel.register;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import static net.electrisoma.bloodisfuel.BloodIsFuel.REGISTRATE;

public class Fluids {

    public static final FluidEntry<ForgeFlowingFluid.Flowing> BLOOD =
            REGISTRATE.fluid("blood",
                            new ResourceLocation("bloodisfuel:block/blood_still"),
                            new ResourceLocation("bloodisfuel:block/blood_flow"))
                    .lang("Blood")
                    .properties(b -> b.viscosity(1500)
                            .density(500))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .register();

    public static void register() {}


}