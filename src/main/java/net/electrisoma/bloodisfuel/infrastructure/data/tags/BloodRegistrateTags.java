package net.electrisoma.bloodisfuel.infrastructure.data.tags;

import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.electrisoma.bloodisfuel.BloodIsFuel;
import com.simibubi.create.foundation.data.TagGen;
import net.electrisoma.bloodisfuel.registry.BIF_Fluids;
import net.electrisoma.bloodisfuel.registry.BloodTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

@SuppressWarnings({"deprecation"})
public class BloodRegistrateTags  {
	public static void addGenerators() {
		BloodIsFuel.REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, BloodRegistrateTags::genItemTags);
		BloodIsFuel.REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, BloodRegistrateTags::genBlockTags);
		BloodIsFuel.REGISTRATE.addDataGenerator(ProviderType.ENTITY_TAGS, BloodRegistrateTags::genEntityTags);
		BloodIsFuel.REGISTRATE.addDataGenerator(ProviderType.FLUID_TAGS, BloodRegistrateTags::genFluidTags);
	}
	private static void genItemTags(RegistrateTagsProvider<Item> provIn) {
		TagGen.CreateTagsProvider<Item> prov =
				new TagGen.CreateTagsProvider<>(provIn, Item::builtInRegistryHolder);

		prov.tag(BloodTags.AllItemTags.CARBOHYDRATES.tag)
				//Vanilla
				.add(
						Items.SUGAR,
						Items.COOKIE,
						Items.CAKE,
						Items.HONEYCOMB,
						Items.HONEY_BLOCK,
						Items.HONEYCOMB_BLOCK,
						Items.HONEY_BOTTLE,
						Items.SWEET_BERRIES,
						Items.COCOA_BEANS,
						Items.APPLE
				)
				//Create
				.addOptional(ResourceLocation.tryParse("create:sweet_roll"))
				.addOptional(ResourceLocation.tryParse("create:chocolate_glazed_berries"))
				.addOptional(ResourceLocation.tryParse("create:honeyed_apple"))
				.addOptional(ResourceLocation.tryParse("create:bar_of_chocolate"))

				//CC&A
				.addOptional(ResourceLocation.tryParse("createaddition:chocolate_cake"))

				//Biomancy
				.addOptional(ResourceLocation.tryParse("biomancy:nutrient_paste"))
				.addOptional(ResourceLocation.tryParse("biomancy:nutrient_bar"))

				//Biofactory
				.addOptional(ResourceLocation.tryParse("biofactory:nutrients_fluid"))
		;
		prov.tag(BloodTags.AllItemTags.MEATS.tag)
				//Vanilla
				.add(
						Items.BEEF,
						Items.PORKCHOP,
						Items.MUTTON,
						Items.CHICKEN,
						Items.RABBIT,
						Items.ROTTEN_FLESH
				)
		;
		prov.tag(BloodTags.AllItemTags.FISHES.tag)
				//Vanilla
				.add(
						Items.COD,
						Items.SALMON,
						Items.TROPICAL_FISH,
						Items.PUFFERFISH
				)
		;
	}

	private static void genBlockTags(RegistrateTagsProvider<Block> provIn) {
		TagGen.CreateTagsProvider<Block> prov =
				new TagGen.CreateTagsProvider<>(provIn, Block::builtInRegistryHolder);

	}

	private static void genEntityTags(RegistrateTagsProvider<EntityType<?>> provIn) {
		TagGen.CreateTagsProvider<EntityType<?>> prov =
				new TagGen.CreateTagsProvider<>(provIn, EntityType::builtInRegistryHolder);
	}

	private static void genFluidTags(RegistrateTagsProvider<Fluid> provIn) {
		TagGen.CreateTagsProvider<Fluid> prov =
				new TagGen.CreateTagsProvider<>(provIn, Fluid::builtInRegistryHolder);

		prov.tag(BloodTags.AllFluidTags.FUEL.tag)

				.add(TagEntry.element(BIF_Fluids.VISCERA.getId()))
				.add(TagEntry.element(BIF_Fluids.BLOOD.getId()))
				.add(TagEntry.element(BIF_Fluids.ENRICHED_BLOOD.getId()))
				.add(TagEntry.element(BIF_Fluids.OIL_ENRICHED_BLOOD.getId()))
				.add(TagEntry.element(BIF_Fluids.DIESEL_INFUSED_BLOOD.getId()))
				.add(TagEntry.element(BIF_Fluids.GASOLINE_INFUSED_BLOOD.getId()))
		;
	}

}
