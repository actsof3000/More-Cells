package com.actsof3000.Test.Items;


import com.actsof3000.Test.CreativeTabs.CreativeTab;
import com.actsof3000.Test.Reference.reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class TestItem extends Item
{
    public TestItem()
    {
        super();
        this.setCreativeTab(CreativeTab.TestMod);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super
                .getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super
                .getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
