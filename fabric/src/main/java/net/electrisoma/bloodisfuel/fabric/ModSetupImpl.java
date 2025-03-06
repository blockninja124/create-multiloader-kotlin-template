package net.electrisoma.bloodisfuel.fabric;

import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.electrisoma.bloodisfuel.registry.BModTab;


public class ModSetupImpl {
    public static void useBaseTab() {
        BloodIsFuel.registrate().setCreativeTab(BModTab.getBaseTabKey());
    }
}
