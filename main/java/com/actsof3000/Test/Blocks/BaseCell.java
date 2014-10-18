package com.actsof3000.Test.Blocks;


import com.actsof3000.Test.CreativeTabs.CreativeTab;
import com.actsof3000.Test.Reference.Names;
import com.actsof3000.Test.TileEntity.BaseCellTE;
import com.actsof3000.Test.Utilities.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;

import java.util.List;

public class BaseCell extends TestBlock implements ITileEntityProvider
{

    public static final String[] Cells = {"Red", "Green", "Blue", "Purple"};
    private static final int TYPES = Cells.length - 1;
    public static IIcon[] textures_sides;
    public static IIcon[] textures_top;
    public static IIcon[] textures_In_Out;

    public BaseCell()
    {
        super();
        this.setBlockName(Names.Blocks.BASE_CELL);
        this.setCreativeTab(CreativeTab.TestMod);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        textures_sides = new IIcon[Cells.length];
        textures_top = new IIcon[Cells.length];
        textures_In_Out = new IIcon[2];
        for (int i = 0; i < Cells.length; i++) {
            textures_sides[i] = iconRegister.registerIcon("Test:BaseCell_" + Cells[i] + "_Side");
            textures_top[i] = iconRegister.registerIcon("Test:BaseCell_" + Cells[i] + "_Top");
        }
        textures_In_Out[0] = iconRegister.registerIcon("Test:Cell_Side_In");
        textures_In_Out[1] = iconRegister.registerIcon("Test:Cell_Side_Out");
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        if (meta < 0 || meta > Cells.length) {
            meta = 0;
        }
        if(side <= 1) {
            return textures_top[meta];
        }
        else
            return textures_sides[meta];
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (player.isSneaking())
        {
            ((BaseCellTE)world.getTileEntity(x,y,z)).changeSide(par6);
            LogHelper.info(((BaseCellTE)world.getTileEntity(x,y,z)).getSendRecv(par6));
            return false;
        }
        else
        {
            if (!world.isRemote)
            {
                if (world.getTileEntity(x, y, z) instanceof BaseCellTE)
                {
                    //TODO open gui
//                    player.openGui(EquivalentExchange3.instance, GUIs.CALCINATOR.ordinal(), world, x, y, z);
                }
            }

            return true;
        }
    }

    @Override
    public boolean onBlockEventReceived(World world, int x, int y, int z, int eventId, int eventData)
    {
        super.onBlockEventReceived(world, x, y, z, eventId, eventData);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        return tileentity != null && tileentity.receiveClientEvent(eventId, eventData);
    }

    @Override
    public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list)
    {
        for (int meta = 0; meta < Cells.length; meta++)
        {
            list.add(new ItemStack(block, 1, meta));
        }
    }

    @Override
    public int damageDropped(int meta)
    {
        return meta & TYPES;
    }

    @Override
    public int getDamageValue(World world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z) & TYPES;
    }


    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new BaseCellTE(meta);
    }
}
