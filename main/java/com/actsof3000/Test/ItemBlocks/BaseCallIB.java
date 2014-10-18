package com.actsof3000.Test.ItemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;


public class BaseCallIB extends ItemBlock
{
    public static final String[] Cells = {"Red", "Green", "Blue", "Purple"};
    private static final int TYPES = Cells.length - 1;

    public BaseCallIB(Block block)
    {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta & TYPES;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        int meta = itemStack.getItemDamageForDisplay() > TYPES ? 0 : itemStack.getItemDamageForDisplay();
        return super.getUnlocalizedName() + (new StringBuilder()).append(Cells[meta])
                .toString();
    }

    @Override
    public IIcon getIconFromDamage(int meta)
    {
        //TODO:	linkedBlock   getIcon
        return field_150939_a.getIcon(0, meta);
    }
}
