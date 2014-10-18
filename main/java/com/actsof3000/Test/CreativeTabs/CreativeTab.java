package com.actsof3000.Test.CreativeTabs;


import com.actsof3000.Test.Blocks.BaseCell;
import com.actsof3000.Test.Reference.Names;
import com.actsof3000.Test.Reference.reference;
import com.actsof3000.Test.Utilities.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import com.actsof3000.Test.Init.TestModBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class CreativeTab
{
    public static final CreativeTabs TestMod = new CreativeTabs(reference.MOD_ID)
    {

        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getIconItemStack()
        {
            return new ItemStack(TestModBlocks.CellBase, 1, 0);
        }

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return getIconItemStack().getItem();
        }

    };
}
