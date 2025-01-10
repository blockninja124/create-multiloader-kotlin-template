package net.electrisoma.bloodisfuel.registry.fluids;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.simibubi.create.foundation.utility.Color;
import com.tterrag.registrate.builders.FluidBuilder.FluidTypeFactory;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;


import java.util.function.Consumer;
import java.util.function.Supplier;

import static net.electrisoma.bloodisfuel.BloodIsFuel.REGISTRATE;

public class BIF_Fluids {

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


    public static final FluidEntry<ForgeFlowingFluid.Flowing> ENRICHED_BLOOD =
            REGISTRATE.fluid("enriched_blood",
                            new ResourceLocation("bloodisfuel:block/blood_still"),
                            new ResourceLocation("bloodisfuel:block/blood_flow"))
                    .lang("Enriched_Blood")
                    .properties(b -> b.viscosity(1500)
                            .density(500))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .register();


    public static final FluidEntry<ForgeFlowingFluid.Flowing> VISCERA =
            REGISTRATE.fluid("viscera",
                            new ResourceLocation("bloodisfuel:block/blood_still"),
                            new ResourceLocation("bloodisfuel:block/blood_flow"))
                    .lang("Viscera")
                    .properties(b -> b.viscosity(1500)
                            .density(500))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .register();


    public static void register() {}
}