package net.electrisoma.bloodisfuel.fabric;

import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.fabricmc.api.ModInitializer;


public class BloodIsFuelFabric implements ModInitializer {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void onInitialize() {

        BloodIsFuel.init();
    }

//    public static void finalizeRegistrate() {
//        BloodIsFuel.registrate().register();
//    }
}