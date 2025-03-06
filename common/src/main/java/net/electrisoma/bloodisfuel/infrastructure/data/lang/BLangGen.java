package net.electrisoma.bloodisfuel.infrastructure.data.lang;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simibubi.create.foundation.utility.FilesHelper;
import com.tterrag.registrate.providers.RegistrateLangProvider;

import java.util.Map;
import java.util.function.BiConsumer;

public class BLangGen {
    public static void generate(RegistrateLangProvider provider) {
        BiConsumer<String, String> langConsumer = provider::add;

        providePartialLang(langConsumer);
        //BAdvancements.provideLang(langConsumer);
    }

    private static void providePartialLang(BiConsumer<String, String> consumer) {
        BLangPartial.provideLang(consumer);
    }
}
