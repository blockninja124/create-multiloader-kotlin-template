package net.electrisoma.bloodisfuel.forge;

import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.electrisoma.bloodisfuel.forge.registry.BModTabImpl;

public class ModSetupImpl {
    public static void useBaseTab() {
        BloodIsFuel.registrate().setCreativeTab(BModTabImpl.MAIN_TAB);
    }
}
