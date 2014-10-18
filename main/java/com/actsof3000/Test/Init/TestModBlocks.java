package com.actsof3000.Test.Init;

import com.actsof3000.Test.Blocks.BaseCell;
import com.actsof3000.Test.ItemBlocks.BaseCallIB;
import com.actsof3000.Test.Reference.Names;
import com.actsof3000.Test.TileEntity.BaseCellTE;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TestModBlocks
{
    public static final Block CellBase = new BaseCell();

    public static void init()
    {
        GameRegistry.registerBlock(CellBase, BaseCallIB.class, Names.Blocks.BASE_CELL);
        GameRegistry.registerTileEntity(BaseCellTE.class, "BaseCellTE");
    }
}
