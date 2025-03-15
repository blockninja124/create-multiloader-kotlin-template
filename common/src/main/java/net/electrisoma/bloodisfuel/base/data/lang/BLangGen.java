package net.electrisoma.bloodisfuel.base.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

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
