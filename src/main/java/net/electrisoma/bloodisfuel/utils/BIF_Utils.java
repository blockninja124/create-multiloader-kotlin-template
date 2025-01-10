package net.electrisoma.bloodisfuel.utils;

import net.minecraft.resources.ResourceLocation;

import static net.electrisoma.bloodisfuel.BloodIsFuel.MOD_ID;

public class BIF_Utils {
    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
