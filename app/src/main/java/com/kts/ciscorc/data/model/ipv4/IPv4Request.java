package com.kts.ciscorc.data.model.ipv4;

public class IPv4Request
{
    private Status status;

    public Status getStatus ()
    {
        return status;
    }

    public void setStatus (Status status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [status = "+ status +"]";
    }
}