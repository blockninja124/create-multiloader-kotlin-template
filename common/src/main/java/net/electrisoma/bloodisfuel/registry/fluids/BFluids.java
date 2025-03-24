package net.electrisoma.bloodisfuel.registry.fluids;

import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.electrisoma.bloodisfuel.registry.BTags;

import com.simibubi.create.foundation.data.CreateRegistrate;

import com.tterrag.registrate.fabric.SimpleFlowableFluid;
import com.tterrag.registrate.util.entry.FluidEntry;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributeHandler;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.EmptyItemFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.FullItemFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.material.Fluid;

import javax.annotation.Nullable;

import static net.minecraft.world.item.Items.BUCKET;


//confusion
@SuppressWarnings({"UnstableApiUsage","unused"})
public class BFluids {
    private static final CreateRegistrate REGISTRATE = BloodIsFuel.registrate();

    public static final FluidEntry<SimpleFlowableFluid.Flowing> VISCERA =
            REGISTRATE.standardFluid("viscera")
                    .lang("Viscera")
                    .tag(BTags.forgeFluidTag("viscera"), FluidTags.WATER) // fabric: water tag controls physics

                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .flowSpeed(3)
                            .blastResistance(100f))

                    .fluidAttributes(() ->
                            new CreateAttributeHandler("block.bloodisfuel.viscera", 1500, 1400))

                    .onRegisterAfter(Registries.ITEM, viscera -> {
                        Fluid source = viscera.getSource();
                        // transfer values
                        FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
                                new FullItemFluidStorage(context, bucket ->
                                        ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
                        FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
                                new EmptyItemFluidStorage(context, bucket ->
                                        ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));
                    })
                    .register();

    public static final FluidEntry<SimpleFlowableFluid.Flowing> BLOOD =
            REGISTRATE.standardFluid("blood")
                    .lang("Blood")
                    .tag(BTags.forgeFluidTag("blood"), FluidTags.WATER) // fabric: water tag controls physics

                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .flowSpeed(3)
                            .blastResistance(100f))

                    .fluidAttributes(() ->
                            new CreateAttributeHandler("block.bloodisfuel.blood", 1500, 1400))

                    .onRegisterAfter(Registries.ITEM, blood -> {
                        Fluid source = blood.getSource();
                        // transfer values
                        FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
                                new FullItemFluidStorage(context, bucket ->
                                        ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
                        FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
                                new EmptyItemFluidStorage(context, bucket ->
                                        ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));
                    })
                    .register();

    public static final FluidEntry<SimpleFlowableFluid.Flowing> ENRICHED_BLOOD =
            REGISTRATE.standardFluid("enriched_blood")
                    .lang("Enriched Blood")
                    .tag(BTags.forgeFluidTag("enriched_blood"), FluidTags.WATER) // fabric: water tag controls physics

                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .flowSpeed(3)
                            .blastResistance(100f))

                    .fluidAttributes(() ->
                            new CreateAttributeHandler("block.bloodisfuel.enriched_blood", 1500, 1400))

                    .onRegisterAfter(Registries.ITEM, enriched_blood -> {
                        Fluid source = enriched_blood.getSource();
                        // transfer values
                        FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
                                new FullItemFluidStorage(context, bucket ->
                                        ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
                        FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
                                new EmptyItemFluidStorage(context, bucket ->
                                        ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));
                    })
                    .register();

    public static final FluidEntry<SimpleFlowableFluid.Flowing> OIL_ENRICHED_BLOOD =
            REGISTRATE.standardFluid("oil_enriched_blood")
                    .lang("Oil Enriched Blood")
                    .tag(BTags.forgeFluidTag("oil_enriched_blood"), FluidTags.WATER) // fabric: water tag controls physics

                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .flowSpeed(3)
                            .blastResistance(100f))

                    .fluidAttributes(() ->
                            new CreateAttributeHandler("block.bloodisfuel.oil_enriched_blood", 1500, 1400))

                    .onRegisterAfter(Registries.ITEM, oil_enriched_blood -> {
                        Fluid source = oil_enriched_blood.getSource();
                        // transfer values
                        FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
                                new FullItemFluidStorage(context, bucket ->
                                        ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
                        FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
                                new EmptyItemFluidStorage(context, bucket ->
                                        ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));
                    })
                    .register();



    public static void register() {
        // load the class and register everything
        BloodIsFuel.LOGGER.info("Registering fluids for " + BloodIsFuel.NAME);
    }


    private record CreateAttributeHandler(Component name, int viscosity, boolean lighterThanAir)
            implements FluidVariantAttributeHandler {
        private CreateAttributeHandler(String key, int viscosity, int density) {
            this(Component.translatable(key), viscosity, density <= 0);
        }

        public CreateAttributeHandler(String key) {
            this(key, FluidConstants.WATER_VISCOSITY, 1000);
        }

        @Override
        public Component getName(FluidVariant fluidVariant) {
            return name.copy();
        }

        @Override
        public int getViscosity(FluidVariant variant, @Nullable Level world) {
            return viscosity;
        }

        @Override
        public boolean isLighterThanAir(FluidVariant variant) {
            return lighterThanAir;
        }
    }
}
