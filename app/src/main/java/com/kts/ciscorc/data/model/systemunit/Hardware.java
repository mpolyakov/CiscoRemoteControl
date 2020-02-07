package com.kts.ciscorc.data.model.systemunit;

public class Hardware
{
    private Module Module;

    public Module getModule ()
    {
        return Module;
    }

    public void setModule (Module Module)
    {
        this.Module = Module;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Module = "+Module+"]";
    }
}