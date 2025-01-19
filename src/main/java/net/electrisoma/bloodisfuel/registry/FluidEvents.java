package net.electrisoma.bloodisfuel.registry;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = BloodIsFuel.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FluidEvents {
    @SubscribeEvent
    static void onFurnaceFuel(FurnaceFuelBurnTimeEvent event) {
        for (FluidEntry<ForgeFlowingFluid.Flowing> flowingFluidEntry :
                Arrays.asList(
                        BIF_Fluids.VISCERA,
                        BIF_Fluids.BLOOD,
                        BIF_Fluids.ENRICHED_BLOOD,
                        BIF_Fluids.OIL_ENRICHED_BLOOD,
                        BIF_Fluids.DIESEL_INFUSED_BLOOD,
                        BIF_Fluids.GASOLINE_INFUSED_BLOOD)) {
            if (event.getItemStack().getItem() ==
                    flowingFluidEntry.getBucket().get()) {
                event.setBurnTime(30000);}
        }
    }
}