package net.electrisoma.bloodisfuel.utils;

import java.util.function.BiConsumer;

@SuppressWarnings({"unused"})
public class LangPartial {
    public static void provideLang(BiConsumer<String, String> consumer) {
        consume(consumer, "creativetab.blood_tab", "Create: Blood is Fuel!");
    }

    private static void consume(BiConsumer<String, String> consumer, String key, String enUS) {
        consumer.accept(key, enUS);
    }
}
