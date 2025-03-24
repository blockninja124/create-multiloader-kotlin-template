package com.blockninja.examplemod;

import com.simibubi.create.CreateBuildInfo;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;

import net.createmod.catnip.lang.FontHelper.Palette;

import net.minecraft.resources.ResourceLocation;

import dev.architectury.injectables.annotations.ExpectPlatform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExampleMod {
    public static final String MOD_ID = "examplemod";
    public static final String NAME = "Example mod";
    public static final String VERSION = "findVersion()";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    private static final CreateRegistrate REGISTRATE =
            CreateRegistrate.create(MOD_ID);

    static {
        REGISTRATE.setTooltipModifierFactory(item -> new
                ItemDescription.Modifier(item, Palette.STANDARD_CREATE)
                .andThen(TooltipModifier.mapNull(KineticStats.create(item))));
    }

    public static void init() {
        LOGGER.info("{} {} initializing! Create version: {} on platform", NAME, VERSION, CreateBuildInfo.VERSION);

        // register common stuff here

        finalizeRegistrate();
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }

    @ExpectPlatform
    public static void finalizeRegistrate() {
        throw new AssertionError();
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
