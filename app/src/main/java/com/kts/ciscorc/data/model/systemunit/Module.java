package com.kts.ciscorc.data.model.systemunit;

public class Module
{
    private String CompatibilityLevel;

    private String SerialNumber;

    public String getCompatibilityLevel ()
    {
        return CompatibilityLevel;
    }

    public void setCompatibilityLevel (String CompatibilityLevel)
    {
        this.CompatibilityLevel = CompatibilityLevel;
    }

    public String getSerialNumber ()
    {
        return SerialNumber;
    }

    public void setSerialNumber (String SerialNumber)
    {
        this.SerialNumber = SerialNumber;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [CompatibilityLevel = "+CompatibilityLevel+", SerialNumber = "+SerialNumber+"]";
    }
}