package net.electrisoma.bloodisfuel.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.electrisoma.bloodisfuel.BloodIsFuel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;


public class BBlocks {
	private static final CreateRegistrate REGISTRATE = BloodIsFuel.registrate();

	public static final BlockEntry<Block> EXAMPLE_BLOCK =
			REGISTRATE.block("example_block", Block::new)
					.initialProperties(() -> Blocks.IRON_BLOCK)
					.properties(p -> p
							.mapColor(MapColor.TERRACOTTA_YELLOW)
							.requiresCorrectToolForDrops()
							.sound(SoundType.DEEPSLATE))
					.tag(BlockTags.NEEDS_IRON_TOOL)
					.tag(BTags.AllBlockTags.EXAMPLE.tag)
					.lang("Example Block")
					.simpleItem()
					.register();

	public static void register() {
		// load the class and register everything
		BloodIsFuel.LOGGER.info("Registering blocks for " + BloodIsFuel.NAME);
	}
}
