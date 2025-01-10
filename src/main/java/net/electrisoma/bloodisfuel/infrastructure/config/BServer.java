package net.electrisoma.bloodisfuel.infrastructure.config;

import com.simibubi.create.foundation.config.ConfigBase;

public class BServer extends ConfigBase {

    public final ConfigGroup infrastructure =
            group(0, "infrastructure", Comments.infrastructure);

    @Override
    public String getName() {
        return "server";
    }

    private static class Comments {
        static String infrastructure =
                "The Backbone of Create: Blood is Fuel!";
    }

}
