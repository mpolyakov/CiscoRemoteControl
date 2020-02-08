package com.kts.ciscorc.data.model.ipv4;

public class Network
{
    private String item;

    private IPv4 ipv4;

    private String maxOccurrence;

    public String getItem ()
    {
        return item;
    }

    public void setItem (String item)
    {
        this.item = item;
    }

    public IPv4 getIpv4()
    {
        return ipv4;
    }

    public void setIpv4(IPv4 ipv4)
    {
        this.ipv4 = ipv4;
    }

    public String getMaxOccurrence ()
    {
        return maxOccurrence;
    }

    public void setMaxOccurrence (String maxOccurrence)
    {
        this.maxOccurrence = maxOccurrence;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [item = "+item+", ipv4 = "+ ipv4 +", maxOccurrence = "+maxOccurrence+"]";
    }
}