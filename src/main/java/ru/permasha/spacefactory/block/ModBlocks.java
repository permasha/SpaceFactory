package ru.permasha.spacefactory.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.permasha.spacefactory.SpaceFactory;
import ru.permasha.spacefactory.item.ModCreativeModeTab;
import ru.permasha.spacefactory.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SpaceFactory.MODID);

    public static final RegistryObject<Block> ALUMINIUM_BLOCK = registryBlock("aluminium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f)
                    .requiresCorrectToolForDrops()),
            ModCreativeModeTab.MOD_TAB);

    public static final RegistryObject<Block> ALUMINIUM_ORE = registryBlock("aluminium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f)
                    .requiresCorrectToolForDrops()),
            ModCreativeModeTab.MOD_TAB);

    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
