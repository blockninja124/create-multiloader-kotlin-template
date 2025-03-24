package com.blockninja.examplemod;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;

import net.createmod.catnip.lang.FontHelper.Palette;

import dev.architectury.injectables.annotations.ExpectPlatform;


public class ExampleMod {
    // Must match with gradle.properties mod_id
    public static final String MOD_ID = "examplemod";

    private static final CreateRegistrate REGISTRATE =
            CreateRegistrate.create(MOD_ID);

    static {
        REGISTRATE.setTooltipModifierFactory(item -> new
                ItemDescription.Modifier(item, Palette.STANDARD_CREATE)
                .andThen(TooltipModifier.mapNull(KineticStats.create(item))));
    }

    public static void init() {

        // register common stuff here

        // Loader dependent
        finalizeRegistrate();
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }

    @ExpectPlatform
    public static void finalizeRegistrate() {
        throw new AssertionError();
    }

}
