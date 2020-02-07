package com.kts.ciscorc.data.model.systemunit;

public class SystemUnitRequest
{
    private Status Status;

    public Status getStatus ()
    {
        return Status;
    }

    public void setStatus (Status Status)
    {
        this.Status = Status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Status = "+Status+"]";
    }
}
