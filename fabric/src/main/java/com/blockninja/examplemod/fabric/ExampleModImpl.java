package com.blockninja.examplemod.fabric;

import com.blockninja.examplemod.ExampleMod;

import net.fabricmc.api.ModInitializer;


public class ExampleModImpl implements ModInitializer {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void onInitialize() {

        ExampleMod.init();
    }

    public static void finalizeRegistrate() {
        ExampleMod.registrate().register();
    }
}