package net.electrisoma.bloodisfuel.fabric;

import net.electrisoma.bloodisfuel.BloodIsFuel;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;


public class BloodIsFuelImpl implements ModInitializer {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void onInitialize() {

        BloodIsFuel.init();
    }

    public static void finalizeRegistrate() {
        BloodIsFuel.registrate().register();
    }
}