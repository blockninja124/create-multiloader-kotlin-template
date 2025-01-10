package net.electrisoma.bloodisfuel.datagen;
import com.tterrag.registrate.providers.ProviderType;
import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.electrisoma.bloodisfuel.datagen.recipes.BloodProcessingRecipe;
import net.electrisoma.bloodisfuel.utils.LangPartial;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.function.BiConsumer;

public class BloodDatagen {
    public static void gatherData(GatherDataEvent event) {
        addExtraRegistrateData();

        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();

        if (event.includeServer()) {

            BloodProcessingRecipe.registerAll(generator, output);
        }
    }

    private static void addExtraRegistrateData() {
        BloodIsFuel.REGISTRATE.addDataGenerator(ProviderType.LANG, provider -> {
            BiConsumer<String, String> langConsumer = provider::add;

            providePartialLang(langConsumer);
            //providePonderLang();
        });
    }

    private static void providePartialLang(BiConsumer<String, String> consumer) {
        LangPartial.provideLang(consumer);
    }

    //private static void providePonderLang() {
    //    BloodPonderTags.register();
    //    BloodPonderIndex.register();
    //}
}