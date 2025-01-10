package net.electrisoma.bloodisfuel.utils;

import com.simibubi.create.foundation.utility.Components;
import com.simibubi.create.foundation.utility.LangBuilder;
import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.minecraft.network.chat.MutableComponent;

public class Lang extends com.simibubi.create.foundation.utility.Lang {

    public static MutableComponent translateDirect(String key, Object... args) {
        return Components.translatable(BloodIsFuel.MOD_ID + "." + key, resolveBuilders(args));
    }

    public static LangBuilder builder() {
        return new LangBuilder(BloodIsFuel.MOD_ID);
    }
}