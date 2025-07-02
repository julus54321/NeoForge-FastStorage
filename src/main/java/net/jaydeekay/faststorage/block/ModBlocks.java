package net.jaydeekay.faststorage.block;

import java.util.function.Supplier;

import net.jaydeekay.faststorage.FastStorage;
import net.jaydeekay.faststorage.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
        DeferredRegister.createBlocks(FastStorage.MOD_ID);

    public static final DeferredBlock<Block> QUANTUM_ORE = registerBlock(
        () -> new Block(BlockBehaviour.Properties.of().setId(
                ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("faststorage:quantum_ore")))));

    private static <T extends Block> DeferredBlock<T> registerBlock(Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register("quantum_ore", block);
        registerBlockItem(toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(DeferredBlock<T> block) {
        ModItems.ITEMS.register("quantum_ore", () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}