package net.electrisoma.bloodisfuel;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.electrisoma.bloodisfuel.registry.*;


public class ModSetup {

    @ExpectPlatform
    public static void useBaseTab() {
        throw new AssertionError();
    }

    public static void register() {
        useBaseTab();
        BModTab.register();
        BTags.register();
        BBlocks.register();
    }
}
