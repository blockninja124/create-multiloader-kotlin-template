package net.electrisoma.bloodisfuel.multiloader.fabric;

import net.createmod.catnip.platform.Loader;


public class LoaderImpl {
    public static Loader getCurrent() {
        return Loader.FABRIC;
    }
}