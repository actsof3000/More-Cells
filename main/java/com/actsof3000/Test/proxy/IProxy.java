package com.actsof3000.Test.proxy;


public interface IProxy
{
    public abstract ClientProxy getClientProxy();

    public abstract void registerEventHandlers();
}
