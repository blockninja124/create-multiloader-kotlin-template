package net.electrisoma.bloodisfuel.utils;

import com.simibubi.create.foundation.utility.Lang;
import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collections;

@SuppressWarnings({"unused"})
public class BIF_Tags {
    public static <T> TagKey<T> optionalTag(IForgeRegistry<T> registry,
                                            ResourceLocation id) {
        return registry.tags()
                .createOptionalTagKey(id, Collections.emptySet());
    }

    public static <T> TagKey<T> forgeTag(IForgeRegistry<T> registry, String path) {
        return optionalTag(registry, new ResourceLocation("forge", path));
    }

    public static TagKey<Block> forgeBlockTag(String path) {
        return forgeTag(ForgeRegistries.BLOCKS, path);
    }

    public static TagKey<Item> forgeItemTag(String path) {
        return forgeTag(ForgeRegistries.ITEMS, path);
    }

    public static TagKey<Fluid> forgeFluidTag(String path) {
        return forgeTag(ForgeRegistries.FLUIDS, path);
    }

    public enum NameSpace {

        MOD(BloodIsFuel.MOD_ID, false, true),
        CREATE("create"),
        FORGE("forge"),
        TIC("tconstruct"),
        QUARK("quark")

        ;

        public final String id;
        public final boolean optionalDefault;
        public final boolean alwaysDatagenDefault;

        NameSpace(String id) {
            this(id, true, false);
        }

        NameSpace(String id, boolean optionalDefault, boolean alwaysDatagenDefault) {
            this.id = id;
            this.optionalDefault = optionalDefault;
            this.alwaysDatagenDefault = alwaysDatagenDefault;
        }
    }
    public enum AllItemTags {
        ;

        public final TagKey<Item> tag;
        public final boolean alwaysDatagen;

        AllItemTags() {
            this(NameSpace.MOD);
        }

        AllItemTags(NameSpace namespace) {
            this(namespace, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        AllItemTags(NameSpace namespace, String path) {
            this(namespace, path, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        AllItemTags(NameSpace namespace, boolean optional, boolean alwaysDatagen) {
            this(namespace, null, optional, alwaysDatagen);
        }

        AllItemTags(NameSpace namespace, String path, boolean optional, boolean alwaysDatagen) {
            ResourceLocation id = new ResourceLocation(namespace.id, path == null ? Lang.asId(name()) : path);
            if (optional) {
                tag = optionalTag(ForgeRegistries.ITEMS, id);
            } else {
                tag = ItemTags.create(id);
            }
            this.alwaysDatagen = alwaysDatagen;
        }

        @SuppressWarnings("deprecation")
        public boolean matches(Item item) {
            return item.builtInRegistryHolder()
                    .is(tag);
        }

        public boolean matches(ItemStack stack) {
            return stack.is(tag);
        }

        private static void init() {}

    }

    public enum AllFluidTags {

        VISCERA(NameSpace.MOD),
        BLOOD(NameSpace.FORGE),
        ENRICHED_BLOOD(NameSpace.MOD)

        ;

        public final TagKey<Fluid> tag;
        public final boolean alwaysDatagen;

        AllFluidTags() {
            this(NameSpace.MOD);
        }

        AllFluidTags(NameSpace namespace) {
            this(namespace, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        AllFluidTags(NameSpace namespace, String path) {
            this(namespace, path, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        AllFluidTags(NameSpace namespace, boolean optional, boolean alwaysDatagen) {
            this(namespace, null, optional, alwaysDatagen);
        }

        AllFluidTags(NameSpace namespace, String path, boolean optional, boolean alwaysDatagen) {
            ResourceLocation id = new ResourceLocation(namespace.id, path == null ? Lang.asId(name()) : path);
            if (optional) {
                tag = optionalTag(ForgeRegistries.FLUIDS, id);
            } else {
                tag = FluidTags.create(id);
            }
            this.alwaysDatagen = alwaysDatagen;
        }

        @SuppressWarnings("deprecation")
        public boolean matches(Fluid fluid) {
            return fluid.is(tag);
        }

        public boolean matches(FluidState state) {
            return state.is(tag);
        }

        private static void init() {}

    }
    public enum BloodRecipeSerializerTags {

        ;

        public final TagKey<RecipeSerializer<?>> tag;
        public final boolean alwaysDatagen;

        BloodRecipeSerializerTags() {
            this(NameSpace.MOD);
        }

        BloodRecipeSerializerTags(NameSpace namespace) {
            this(namespace, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        BloodRecipeSerializerTags(NameSpace namespace, String path) {
            this(namespace, path, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        BloodRecipeSerializerTags(NameSpace namespace, boolean optional, boolean alwaysDatagen) {
            this(namespace, null, optional, alwaysDatagen);
        }

        BloodRecipeSerializerTags(NameSpace namespace, String path, boolean optional, boolean alwaysDatagen) {
            ResourceLocation id = new ResourceLocation(namespace.id, path == null ? Lang.asId(name()) : path);
            if (optional) {
                tag = optionalTag(ForgeRegistries.RECIPE_SERIALIZERS, id);
            } else {
                tag = TagKey.create(Registries.RECIPE_SERIALIZER, id);
            }
            this.alwaysDatagen = alwaysDatagen;
        }

        public boolean matches(RecipeSerializer<?> recipeSerializer) {
            return ForgeRegistries.RECIPE_SERIALIZERS.getHolder(recipeSerializer).orElseThrow().is(tag);
        }

        private static void init() {}
    }

    public static void init() {
        AllItemTags.init();
        AllFluidTags.init();
        BloodRecipeSerializerTags.init();
    }


}
