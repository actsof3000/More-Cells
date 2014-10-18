package com.actsof3000.Test.TileEntity;



import com.actsof3000.Test.Blocks.BaseCell;
import com.actsof3000.Test.Utilities.NBTHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import cofh.api.energy.*;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

public class BaseCellTE extends TileEntity implements IEnergyHandler
{
    protected EnergyStorage storage = new EnergyStorage(32000);
    private int[] SendRecv = {0,0,0,0,0,0};

    public BaseCellTE(int meta)
    {
        if(meta == 0)
        {
            this.storage.setCapacity(1000);
        }
        else if(meta == 1)
        {
            this.storage.setCapacity(10000);
        }
    }

    public int getEnergyStored()
    {
        return this.storage.getEnergyStored();
    }

    public void setEnergyStored(int amount)
    {
        this.storage.setEnergyStored(amount);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        storage.writeToNBT(nbt);
        nbt.setIntArray("SendRecv", SendRecv);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {

        super.readFromNBT(nbt);
        storage.readFromNBT(nbt);
        SendRecv = nbt.getIntArray("SendRecv");
    }

    public void changeSide(int side)
    {
        if(SendRecv[side] < 2)
            SendRecv[side] += 1;
        else
            SendRecv[side] = 0;

    }

    public int getSendRecv(int side)
    {
        return SendRecv[side];
    }

    /* IEnergyHandler */
    @Override
    public boolean canConnectEnergy(ForgeDirection from) {

        return true;
    }

    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {

        return storage.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {

        return storage.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {

        return storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {

        return storage.getMaxEnergyStored();
    }

    public IIcon getTexture(int side, int meta)
    {
        if(side <= 1)
        {
            switch(SendRecv[side]) {
                case 0: return BaseCell.textures_top[meta];
                case 1: return BaseCell.textures_In_Out[0];
                case 2: return BaseCell.textures_In_Out[1];
            }
        }
        else
        {
            switch(SendRecv[side]) {
                case 0: return BaseCell.textures_sides[meta];
                case 1: return BaseCell.textures_In_Out[0];
                case 2: return BaseCell.textures_In_Out[1];
            }
        }
        return null;

    }
}
