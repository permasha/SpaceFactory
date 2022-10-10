package ru.permasha.spacefactory.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MOD_TAB = new CreativeModeTab("spacefactorytab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ALUMINIUM_INGOT.get());
        }
    };

}
