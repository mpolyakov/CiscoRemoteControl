package com.kts.ciscorc.data.model.systemunit;

public class State
{
    private String NumberOfInProgressCalls;

    private String NumberOfActiveCalls;

    private String NumberOfSuspendedCalls;

    public String getNumberOfInProgressCalls ()
    {
        return NumberOfInProgressCalls;
    }

    public void setNumberOfInProgressCalls (String NumberOfInProgressCalls)
    {
        this.NumberOfInProgressCalls = NumberOfInProgressCalls;
    }

    public String getNumberOfActiveCalls ()
    {
        return NumberOfActiveCalls;
    }

    public void setNumberOfActiveCalls (String NumberOfActiveCalls)
    {
        this.NumberOfActiveCalls = NumberOfActiveCalls;
    }

    public String getNumberOfSuspendedCalls ()
    {
        return NumberOfSuspendedCalls;
    }

    public void setNumberOfSuspendedCalls (String NumberOfSuspendedCalls)
    {
        this.NumberOfSuspendedCalls = NumberOfSuspendedCalls;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [NumberOfInProgressCalls = "+NumberOfInProgressCalls+", NumberOfActiveCalls = "+NumberOfActiveCalls+", NumberOfSuspendedCalls = "+NumberOfSuspendedCalls+"]";
    }
}