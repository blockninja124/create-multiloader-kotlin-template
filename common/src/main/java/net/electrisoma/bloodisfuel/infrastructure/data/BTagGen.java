package net.electrisoma.bloodisfuel.infrastructure.data;


import net.electrisoma.bloodisfuel.registry.BTags;
import net.electrisoma.bloodisfuel.registry.BTags.AllBlockTags;
import net.electrisoma.bloodisfuel.registry.BTags.AllItemTags;
import net.electrisoma.bloodisfuel.registry.BTags.AllFluidTags;
import net.electrisoma.bloodisfuel.registry.BBlocks;

import com.tterrag.registrate.providers.RegistrateTagsProvider;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.electrisoma.bloodisfuel.registry.fluids.BFluids;
import net.electrisoma.bloodisfuel.registry.items.BItems;
import net.minecraft.data.tags.TagsProvider.TagAppender;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BTagGen {
    private static final Map<TagKey<Block>, List<ResourceLocation>> OPTIONAL_TAGS = new HashMap<>();

    @SafeVarargs
    public static void addOptionalTag(ResourceLocation id, TagKey<Block>... tags) {
        for (TagKey<Block> tag : tags) {
            OPTIONAL_TAGS.computeIfAbsent(tag, (e) -> new ArrayList<>()).add(id);
        }
    }

    public static void generateBlockTags(RegistrateTagsProvider<Block> prov) {

        prov.addTag(BTags.AllBlockTags.EXAMPLE.tag)
                .add(BBlocks.EXAMPLE_BLOCK.get())
        ;


        for (BTags.AllBlockTags tag : BTags.AllBlockTags.values()) {
            if (tag.alwaysDatagen) {
                tagAppender(prov, tag);
            }
        }
        for (TagKey<Block> tag : OPTIONAL_TAGS.keySet()) {
            var appender = tagAppender(prov, tag);
            for (ResourceLocation loc : OPTIONAL_TAGS.get(tag))
                appender.addOptional(loc);
        }
    }

    public static void generateItemTags(RegistrateTagsProvider<Item> prov) {
        prov.addTag(BTags.AllItemTags.CARBOHYDRATES.tag)
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
                        Items.GLOW_BERRIES,
                        Items.COCOA_BEANS,
                        Items.APPLE
                )

                //Create
                .addOptional(new ResourceLocation("create:sweet_roll"))
                .addOptional(new ResourceLocation("create:chocolate_glazed_berries"))
                .addOptional(new ResourceLocation("create:honeyed_apple"))
                .addOptional(new ResourceLocation("create:bar_of_chocolate"))

                //CC&A
                .addOptional(new ResourceLocation("createaddition:chocolate_cake"))

                //Garnished
                .addOptionalTag(new ResourceLocation("garnished:garnished_foods"))
                .addOptionalTag(new ResourceLocation("garnished:aversion_foods"))

                //Confectionery
                .addOptional(new ResourceLocation("create_confectionery:bar_of_caramel"))
                .addOptional(new ResourceLocation("create_confectionery:bar_of_black_chocolate"))
                .addOptional(new ResourceLocation("create_confectionery:bar_of_white_chocolate"))
                .addOptional(new ResourceLocation("create_confectionery:bar_of_ruby_chocolate"))
                .addOptional(new ResourceLocation("create_confectionery:full_chocolate_bar"))
                .addOptional(new ResourceLocation("create_confectionery:full_black_chocolate_bar"))
                .addOptional(new ResourceLocation("create_confectionery:full_white_chocolate_bar"))
                .addOptional(new ResourceLocation("create_confectionery:full_ruby_chocolate_bar"))
                .addOptional(new ResourceLocation("create_confectionery:caramel_glazed_berries"))
                .addOptional(new ResourceLocation("create_confectionery:dark_chocolate_glazed_berries"))
                .addOptional(new ResourceLocation("create_confectionery:white_chocolate_glazed_berries"))
                .addOptional(new ResourceLocation("create_confectionery:ruby_chocolate_glazed_berries"))
                .addOptional(new ResourceLocation("create_confectionery:marshmallow"))
                .addOptional(new ResourceLocation("create_confectionery:marshmallow_on_a_stick"))
                .addOptional(new ResourceLocation("create_confectionery:caramelized_marshmellow_on_a_stick"))
                .addOptional(new ResourceLocation("create_confectionery:chocolate_glazed_marshmallow"))
                .addOptional(new ResourceLocation("create_confectionery:black_chocolate_glazed_marshmallow"))
                .addOptional(new ResourceLocation("create_confectionery:white_chocolate_glazed_marshmallow"))
                .addOptional(new ResourceLocation("create_confectionery:ruby_chocolate_glazed_marshmallow"))
                .addOptional(new ResourceLocation("create_confectionery:candy_cane"))
                .addOptional(new ResourceLocation("create_confectionery:crushed_cocoa"))
                .addOptional(new ResourceLocation("create_confectionery:cocoa_butter"))
                .addOptional(new ResourceLocation("create_confectionery:cocoa_powder"))
                .addOptional(new ResourceLocation("create_confectionery:gingerbread"))
                .addOptional(new ResourceLocation("create_confectionery:gingerbread_man"))
                .addOptional(new ResourceLocation("create_confectionery:honey_candy"))
                .addOptional(new ResourceLocation("create_confectionery:chocolate_candy"))
                .addOptional(new ResourceLocation("create_confectionery:chocolate_candy_1"))
                .addOptional(new ResourceLocation("create_confectionery:chocolate_candy_2"))
                .addOptional(new ResourceLocation("create_confectionery:chocolate_candy_3"))
                .addOptional(new ResourceLocation("create_confectionery:dark_chocolate_candy"))
                .addOptional(new ResourceLocation("create_confectionery:dark_chocolate_candy_1"))
                .addOptional(new ResourceLocation("create_confectionery:dark_chocolate_candy_2"))
                .addOptional(new ResourceLocation("create_confectionery:dark_chocolate_candy_3"))
                .addOptional(new ResourceLocation("create_confectionery:white_chocolate_candy"))
                .addOptional(new ResourceLocation("create_confectionery:white_chocolate_candy_1"))
                .addOptional(new ResourceLocation("create_confectionery:white_chocolate_candy_2"))
                .addOptional(new ResourceLocation("create_confectionery:white_chocolate_candy_3"))
                .addOptional(new ResourceLocation("create_confectionery:ruby_chocolate_candy"))
                .addOptional(new ResourceLocation("create_confectionery:ruby_chocolate_candy_1"))
                .addOptional(new ResourceLocation("create_confectionery:ruby_chocolate_candy_2"))
                .addOptional(new ResourceLocation("create_confectionery:ruby_chocolate_candy_3"))

                //Biomancy
                .addOptional(new ResourceLocation("biomancy:nutrient_paste"))
                .addOptional(new ResourceLocation("biomancy:nutrient_bar"))

                //BiC
                .addOptional(new ResourceLocation("born_in_chaos_v1:mint_candy"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:mint_ice_cream"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:coffee_candy"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:gummy_vampire_teeth"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:chocolate_heart"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:caramel_pepper"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:holiday_candy"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:magical_holiday_candy"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:eternal_candy"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:creepy_cookies_with_milk"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:spiritual_gingerbread"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:spiritual_dust"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:intoxicating_decoction"))
        ;

        prov.addTag(BTags.AllItemTags.MEATS.tag)
                //Vanilla
                .add(
                        Items.BEEF,
                        Items.PORKCHOP,
                        Items.MUTTON,
                        Items.CHICKEN,
                        Items.RABBIT,
                        Items.ROTTEN_FLESH,
                        Items.SPIDER_EYE,
                        Items.FERMENTED_SPIDER_EYE
                )

                //BIF
                .add(BItems.DRAINED_MEAT.getId())

                //BiC
                .addOptional(new ResourceLocation("born_in_chaos_v1:monster_flesh"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:bloody_gadfly_eye"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:corpse_maggot"))
                .addOptional(new ResourceLocation("born_in_chaos_v1:ethereal_spirit"))

                //Farmer's Delight
                .addOptional(new ResourceLocation("farmersdelight:bacon"))
                .addOptional(new ResourceLocation("farmersdelight:minced_beef"))
                .addOptional(new ResourceLocation("farmersdelight:chicken_cuts"))
                .addOptional(new ResourceLocation("farmersdelight:mutton_chops"))
                .addOptional(new ResourceLocation("farmersdelight:ham"))
        ;



        for (AllItemTags tag : AllItemTags.values()) {
            if (tag.alwaysDatagen)
                tagAppender(prov, tag);
        }
    }

    public static void generateFluidTags(RegistrateTagsProvider<Fluid> prov){

        prov.addTag(BTags.AllFluidTags.VISCERA.tag)
                //BoP
                .addOptional(new ResourceLocation("biomesoplenty:blood"))

                //TConstruct
                .addOptional(new ResourceLocation("tconstruct:meat_soup"))
        ;

        prov.addTag(BTags.AllFluidTags.FUEL.tag)
                //BIF
                .add(BFluids.VISCERA.getId())
                .add(BFluids.BLOOD.getId())
                .add(BFluids.ENRICHED_BLOOD.getId())
                .add(BFluids.OIL_ENRICHED_BLOOD.getId())
                //.add(TagEntry.element(BFluids.DIESEL_INFUSED_BLOOD.getId()))
                //.add(TagEntry.element(BFluids.GASOLINE_INFUSED_BLOOD.getId()))
        ;

        prov.addTag(BTags.AllFluidTags.LIQUID_CARBOHYDRATES.tag)
                //Create
                .addOptional(new ResourceLocation("create:honey"))
                .addOptional(new ResourceLocation("create:chocolate"))
                .addOptional(new ResourceLocation("create:tea"))

                //Garnished
                .addOptional(new ResourceLocation("garnished:apple_cider"))
                .addOptional(new ResourceLocation("garnished:garnish"))
                .addOptional(new ResourceLocation("garnished:sweet_tea"))

                //Confectionery
                .addOptional(new ResourceLocation("create_confectionery:caramel"))
                .addOptional(new ResourceLocation("create_confectionery:black_chocolate"))
                .addOptional(new ResourceLocation("create_confectionery:white_chocolate"))
                .addOptional(new ResourceLocation("create_confectionery:ruby_chocolate"))
                .addOptional(new ResourceLocation("create_confectionery:hot_chocolate"))
                .addOptional(new ResourceLocation("create_confectionery:soothing_hot_chocolate"))

                //Biofactory
                .addOptional(new ResourceLocation("biofactory:nutrients_fluid"))
        ;

        for (AllFluidTags tag : AllFluidTags.values()) {
            if (tag.alwaysDatagen)
                tagAppender(prov, tag);
        }
    }


    public static TagAppender<Fluid> tagAppender(RegistrateTagsProvider<Fluid> prov, AllFluidTags tag) {
        return tagAppender(prov, tag.tag);
    }


    public static TagAppender<Item> tagAppender(RegistrateTagsProvider<Item> prov, AllItemTags tag) {
        return tagAppender(prov, tag.tag);
    }

    public static TagAppender<Block> tagAppender(RegistrateTagsProvider<Block> prov, AllBlockTags tag) {
        return tagAppender(prov, tag.tag);
    }

    @ExpectPlatform // this has to be platformed out because addTag on fabric has a signature that includes FabricTagProvider$FabricTagBuilder
    public static <T> TagAppender<T> tagAppender(RegistrateTagsProvider<T> prov, TagKey<T> tag) {
        throw new AssertionError();
    }
}
