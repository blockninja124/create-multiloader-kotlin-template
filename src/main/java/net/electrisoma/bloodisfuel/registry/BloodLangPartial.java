package net.electrisoma.bloodisfuel.registry;

import java.util.function.BiConsumer;

@SuppressWarnings({"unused"})
public class BloodLangPartial {
    public static void provideLang(BiConsumer<String, String> consumer) {
        consume(consumer, "itemGroup.bloodisfuel.base", "Create: Blood is Fuel!");
    }

    private static void consume(BiConsumer<String, String> consumer, String key, String enUS) {
        consumer.accept(key, enUS);
    }
}
