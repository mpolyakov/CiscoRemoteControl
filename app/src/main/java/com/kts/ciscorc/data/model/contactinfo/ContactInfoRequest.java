package com.kts.ciscorc.data.model.contactinfo;

public class ContactInfoRequest
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