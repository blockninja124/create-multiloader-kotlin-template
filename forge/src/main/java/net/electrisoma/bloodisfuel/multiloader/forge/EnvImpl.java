package net.electrisoma.bloodisfuel.multiloader.forge;

import net.electrisoma.bloodisfuel.multiloader.Env;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.jetbrains.annotations.ApiStatus.Internal;


public class EnvImpl {
    @Internal
    public static Env getCurrent() {
        return FMLEnvironment.dist ==
                Dist.CLIENT ?
                Env.CLIENT :
                Env.SERVER;
    }
}