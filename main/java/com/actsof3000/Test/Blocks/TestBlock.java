package com.actsof3000.Test.Blocks;

import com.actsof3000.Test.Reference.reference;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import com.actsof3000.Test.CreativeTabs.CreativeTab;
import net.minecraft.client.renderer.texture.IIconRegister;


public class TestBlock extends Block
{
    public TestBlock(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTab.TestMod);
    }

    public TestBlock()
    {
        this(Material.rock);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", reference.MOD_ID + ":", getUnwrappedUnlocalizedName(super
                .getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName
                ())));
    }


    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
