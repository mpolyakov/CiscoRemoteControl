package com.kts.ciscorc.data.model.ipv4;

public class IPv4
{
    private String address;

    private String gateway;

    private String subnetMask;

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getGateway ()
    {
        return gateway;
    }

    public void setGateway (String gateway)
    {
        this.gateway = gateway;
    }

    public String getSubnetMask ()
    {
        return subnetMask;
    }

    public void setSubnetMask (String subnetMask)
    {
        this.subnetMask = subnetMask;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [address = "+ address +", gateway = "+ gateway +", subnetMask = "+ subnetMask +"]";
    }
}