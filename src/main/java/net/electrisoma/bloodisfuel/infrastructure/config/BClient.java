package net.electrisoma.bloodisfuel.infrastructure.config;

import com.simibubi.create.foundation.config.ConfigBase;

@SuppressWarnings({"unused"})
public class BClient extends ConfigBase {

    public final ConfigGroup client = group(0, "client",
            Comments.client);

    // custom fluid fog
    public final ConfigGroup fluidFogSettings =
            group(1, "fluidFogSettings", Comments.fluidFogSettings);

    public final ConfigFloat visceraTransparencyMultiplier =
            f(1,.125f,128,"viscera",Comments.visceraTransparencyMultiplier);
    public final ConfigFloat bloodTransparencyMultiplier =
            f(1,.125f,128,"blood",Comments.bloodTransparencyMultiplier);
    public final ConfigFloat enrichedBloodTransparencyMultiplier =
            f(1,.125f,128,"enriched_blood",Comments.enrichedBloodTransparencyMultiplier);



    @Override
    public String getName() {return "client";}

    private static class Comments {
        static String client = "Client-only settings - If you're looking for general settings, look inside your worlds serverconfig folder!";

        static String fluidFogSettings = "Configure your vision range when submerged in Create Blood is Fuel!'s custom fluids";
        static String visceraTransparencyMultiplier = "The vision range through viscera will be multiplied by this factor";
        static String bloodTransparencyMultiplier = "The vision range through blood will be multiplied by this factor";
        static String enrichedBloodTransparencyMultiplier = "The vision range through enriched blood will be multiplied by this factor";
    }

}
