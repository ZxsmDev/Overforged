package overforged.modid.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import overforged.modid.Overforged;
import overforged.modid.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup OVERFORGED_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Overforged.MOD_ID, "overforged_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.items[0]))
                    .displayName(Text.translatable("itemgroup.overforged.overforged_items"))
                    .entries((displayContext, entries) -> {
                        for  (Item item : ModItems.items) {
                            entries.add(item);
                        }
                    }).build());

    public static final ItemGroup OVERFORGED_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Overforged.MOD_ID, "overforged_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.blocks[0]))
                    .displayName(Text.translatable("itemgroup.overforged.overforged_blocks"))
                    .entries((displayContext, entries) -> {
                        for  (Block block : ModBlocks.blocks) {
                            entries.add(block);
                        }
                    }).build());

    public static void registerItemGroups() {
        Overforged.LOGGER.info("Registering Item Groups for " + Overforged.MOD_ID);
    }
}
