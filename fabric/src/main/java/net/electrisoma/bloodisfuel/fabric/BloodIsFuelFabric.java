package net.electrisoma.bloodisfuel.fabric;

import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.fabricmc.api.ModInitializer;


public class BloodIsFuelFabric implements ModInitializer {
    @Override
    public void onInitialize() {

        BloodIsFuel.init();
    }
}