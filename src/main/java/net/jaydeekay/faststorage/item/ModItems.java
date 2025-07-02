package net.jaydeekay.faststorage.item;

import net.jaydeekay.faststorage.FastStorage;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FastStorage.MOD_ID);

    //public static final DeferredItem<Item> SILICON = ITEMS.register("silicon",
    //    () -> new Item(new Item.Properties().stacksTo(64)));

    public static final DeferredItem<Item> SILICON = ITEMS.register("silicon", () -> new Item(new Item.Properties().useItemDescriptionPrefix().setId(
        ResourceKey.create(Registries.ITEM, ResourceLocation.parse("faststorage:silicon")))));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

}
