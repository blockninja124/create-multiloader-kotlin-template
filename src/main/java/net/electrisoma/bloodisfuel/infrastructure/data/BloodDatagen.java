package net.electrisoma.bloodisfuel.infrastructure.data;

import com.tterrag.registrate.providers.ProviderType;
import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.electrisoma.bloodisfuel.infrastructure.data.recipe.BloodProcessingRecipeGen;
import net.electrisoma.bloodisfuel.registry.BloodLangPartial;
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

			BloodProcessingRecipeGen.registerAll(generator, output);
		}
	}

	private static void addExtraRegistrateData() {
		BloodIsFuel.REGISTRATE.addDataGenerator(ProviderType.LANG, provider -> {
			BiConsumer<String, String> langConsumer = provider::add;

			providePartialLang(langConsumer);
		});
	}

	private static void providePartialLang(BiConsumer<String, String> consumer) {
		BloodLangPartial.provideLang(consumer);
	}}