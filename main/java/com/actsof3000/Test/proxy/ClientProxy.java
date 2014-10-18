package com.actsof3000.Test.proxy;

import com.actsof3000.Test.events.Events;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerEventHandlers()
    {
        Events events = new Events();
        super.registerEventHandlers();
        MinecraftForge.EVENT_BUS.register(events);
    }

    @Override
    public ClientProxy getClientProxy()
    {
        return this;
    }
}
