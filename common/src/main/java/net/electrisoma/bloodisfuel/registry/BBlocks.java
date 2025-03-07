package net.electrisoma.bloodisfuel.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;


public class BBlocks {
	private static final CreateRegistrate REGISTRATE =
			BloodIsFuel.registrate();

	public static final BlockEntry<Block> EXAMPLE_BLOCK =
			REGISTRATE.block("example_block", Block::new)
					.initialProperties(SharedProperties::softMetal)

					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GRAY))
					.properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
					.properties(p -> p.lightLevel(state -> 15))
					.properties(p -> p.strength(1.0F,3600000.0F)) // Unexplodable
					.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)

					.transform(pickaxeOnly())
					.addLayer(() -> RenderType::cutoutMipped)
					.tag(BTags.AllBlockTags.EXAMPLE.tag)
					.lang("Example Block")
					.simpleItem()
					.register();

	public static void register() {
		// load the class and register everything
		BloodIsFuel.LOGGER.info("Registering blocks for " + BloodIsFuel.NAME);
	}
}
