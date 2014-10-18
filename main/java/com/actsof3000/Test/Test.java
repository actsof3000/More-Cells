package com.actsof3000.Test;


import com.actsof3000.Test.Init.TestModBlocks;
import com.actsof3000.Test.Init.TestModItems;
import com.actsof3000.Test.Reference.reference;
import com.actsof3000.Test.Utilities.LogHelper;
import com.actsof3000.Test.proxy.IProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = reference.MOD_ID, name = reference.MOD_NAME, version = reference.VERISION)
public class Test {

    @Mod.Instance("assets.Test")
    public static Test instance;

    @SidedProxy(clientSide = reference.CLIENT_PROXY, serverSide = reference.SERVER_PROXY)
    public static IProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        TestModItems.init();
        TestModBlocks.init();
        LogHelper.info("Registering events");
        proxy.registerEventHandlers();

    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }


}
