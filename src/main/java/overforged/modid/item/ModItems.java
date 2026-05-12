package overforged.modid.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import overforged.modid.Overforged;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item[] items = new Item[]{
        registerItem("steel_ingot", new Item(new Item.Settings())),
        registerItem("raw_steel", new Item(new Item.Settings()))
    };

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Overforged.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Overforged.LOGGER.info("Registering Mod Items for " + Overforged.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            for  (Item item : items) {
                entries.add(item);
            }
        });
    }
}
