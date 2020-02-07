package com.kts.ciscorc.data.model.systemunit;

public class SystemUnit
{
    private String Uptime;

    private State State;

    private String ProductType;

    private Hardware Hardware;

    private String ProductId;

    private Software Software;

    private String ProductPlatform;

    public String getUptime ()
    {
        return Uptime;
    }

    public void setUptime (String Uptime)
    {
        this.Uptime = Uptime;
    }

    public State getState ()
    {
        return State;
    }

    public void setState (State State)
    {
        this.State = State;
    }

    public String getProductType ()
    {
        return ProductType;
    }

    public void setProductType (String ProductType)
    {
        this.ProductType = ProductType;
    }

    public Hardware getHardware ()
    {
        return Hardware;
    }

    public void setHardware (Hardware Hardware)
    {
        this.Hardware = Hardware;
    }

    public String getProductId ()
    {
        return ProductId;
    }

    public void setProductId (String ProductId)
    {
        this.ProductId = ProductId;
    }

    public Software getSoftware ()
    {
        return Software;
    }

    public void setSoftware (Software Software)
    {
        this.Software = Software;
    }

    public String getProductPlatform ()
    {
        return ProductPlatform;
    }

    public void setProductPlatform (String ProductPlatform)
    {
        this.ProductPlatform = ProductPlatform;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Uptime = "+Uptime+", State = "+State+", ProductType = "+ProductType+", Hardware = "+Hardware+", ProductId = "+ProductId+", Software = "+Software+", ProductPlatform = "+ProductPlatform+"]";
    }
}