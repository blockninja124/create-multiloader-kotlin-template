package net.electrisoma.bloodisfuel.registry.fabric;

import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.electrisoma.bloodisfuel.registry.BModTab;


public class BmodTabTabsImpl {
    public static void use(BModTab.Tabs tab) {
        BloodIsFuel.registrate().setCreativeTab(tab.getKey());
    }
}
