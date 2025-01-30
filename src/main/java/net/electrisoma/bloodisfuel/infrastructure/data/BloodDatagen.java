package net.electrisoma.bloodisfuel.infrastructure.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simibubi.create.foundation.utility.FilesHelper;
import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.electrisoma.bloodisfuel.infrastructure.LangPartial;
import net.electrisoma.bloodisfuel.infrastructure.data.advancements.AllAdvancements;
import net.electrisoma.bloodisfuel.infrastructure.data.recipe.BloodProcessingRecipeGen;
import net.electrisoma.bloodisfuel.infrastructure.data.tags.BloodRegistrateTags;

import com.tterrag.registrate.providers.ProviderType;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import org.apache.logging.log4j.util.TriConsumer;

import java.util.Map;
import java.util.function.BiConsumer;


public class BloodDatagen {
	public static void gatherData(GatherDataEvent event) {
		addExtraRegistrateData();

		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();

		if (event.includeServer()) {

			generator.addProvider(true, new AllAdvancements(output));
			BloodProcessingRecipeGen.registerAll(generator, output);
		}
	}

	private static void addExtraRegistrateData() {
		BloodRegistrateTags.addGenerators();

		BloodIsFuel.REGISTRATE.addDataGenerator(ProviderType.LANG, provider -> {
			BiConsumer<String, String> langConsumer = provider::add;

			AllAdvancements.provideLang(langConsumer);
			providePartialLang(langConsumer);

		});

	}
	private static void providePartialLang(BiConsumer<String, String> consumer) {
		LangPartial.provideLang(consumer);
	}
}