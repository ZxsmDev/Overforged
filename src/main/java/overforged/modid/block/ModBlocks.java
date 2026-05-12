package overforged.modid.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.ItemGroups;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import overforged.modid.Overforged;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block[] blocks = new Block[]{
            registerBlock("block_of_steel",
                    new Block(AbstractBlock.Settings
                            .create()
                            .strength(4f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.NETHERITE))),
            registerBlock("block_of_raw_steel",
                    new Block(AbstractBlock.Settings
                            .create()
                            .strength(3f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE_TILES))),
            registerBlock("steel_ore",
                    new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                            AbstractBlock.Settings
                            .create()
                            .strength(3f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.STONE))),
            registerBlock("deepslate_steel_ore",
                    new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                            AbstractBlock.Settings
                            .create()
                            .strength(4f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE))),
    };

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Overforged.MOD_ID + ":" + name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Overforged.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Overforged.LOGGER.info("Registering Mod Blocks for " + Overforged.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            for  (Block block : blocks) {
                entries.add(block);
            }
        });
    }
}
