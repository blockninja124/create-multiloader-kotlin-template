package net.electrisoma.bloodisfuel.infrastructure.data.advancements;

import net.electrisoma.bloodisfuel.infrastructure.data.advancements.CreateAdvancement.Builder;
import net.electrisoma.bloodisfuel.registry.BIF_Fluids;

import com.google.common.collect.Sets;

import net.electrisoma.bloodisfuel.registry.BIF_Items;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.PackOutput.PathProvider;
import net.minecraft.resources.ResourceLocation;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import static net.electrisoma.bloodisfuel.infrastructure.data.advancements.CreateAdvancement.TaskType.*;


public class AllAdvancements implements DataProvider {

    public static final List<CreateAdvancement> ENTRIES = new ArrayList<>();
    public static final CreateAdvancement START = null,

    /*
     * Some ids have trailing 0's to modify their vertical position on the tree
     * (Advancement ordering seems to be deterministic but hash based)
     */

    ROOT = create("root", b -> b
            .icon(BIF_Items.GROUND_MEAT)
            .title("Blood is Fuel!")
            .description("Here Be Meat")
            .awardedForFree()
            .special(NORMAL)),

    // Blood - Start

    VISCERA = create("viscera", b -> b
            .icon(() -> BIF_Fluids.VISCERA.getBucket().get().getDefaultInstance().getItem())
            .title("Into the Fire")
            .description("The meat hath begun...")
            .after(ROOT)
            .whenIconCollected()
            .special(NORMAL)),

    BLOOD = create("blood", b -> b
            .icon(() -> BIF_Fluids.BLOOD.getBucket().get().getDefaultInstance().getItem())
            .title("The Meatgrinder")
            .description("Obtain a bucket of blood")
            .after(VISCERA)
            .whenIconCollected()
            .special(NORMAL)),

    // Blood - Enrichment
    ENRICHED_BLOOD = create("enriched_blood", b -> b
            .icon(() -> BIF_Fluids.ENRICHED_BLOOD.getBucket().get().getDefaultInstance().getItem())
            .title("Double Down")
            .description("Obtain a bucket of enriched blood")
            .after(BLOOD)
            .whenIconCollected()
            .special(NORMAL)),

    // Blood - Oil
    OIL_ENRICHED_BLOOD = create("oil_enriched_blood", b -> b
            .icon(() -> BIF_Fluids.OIL_ENRICHED_BLOOD.getBucket().get().getDefaultInstance().getItem())
            .title("A One Machine Army")
            .description("Obtain a bucket of oil enriched blood")
            .after(ENRICHED_BLOOD)
            .whenIconCollected()
            .special(NOISY)),
    // Blood - Hidden

    //
    END = null;

    private static CreateAdvancement create(String id, UnaryOperator<Builder> b) {
        return new CreateAdvancement(id, b);
    }

    // Datagen

    private final PackOutput output;

    public AllAdvancements(PackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        PathProvider pathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "advancements");
        List<CompletableFuture<?>> futures = new ArrayList<>();

        Set<ResourceLocation> set = Sets.newHashSet();
        Consumer<Advancement> consumer = (advancement) -> {
            ResourceLocation id = advancement.getId();
            if (!set.add(id))
                throw new IllegalStateException("Duplicate advancement " + id);
            Path path = pathProvider.json(id);
            futures.add(DataProvider.saveStable(cache, advancement.deconstruct()
                    .serializeToJson(), path));
        };

        for (CreateAdvancement advancement : ENTRIES)
            advancement.save(consumer);

        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName() {
        return "Blood is Fuel's Advancements";
    }

    public static void provideLang(BiConsumer<String, String> consumer) {
        for (CreateAdvancement advancement : ENTRIES)
            advancement.provideLang(consumer);
    }

    public static void register() {}

}