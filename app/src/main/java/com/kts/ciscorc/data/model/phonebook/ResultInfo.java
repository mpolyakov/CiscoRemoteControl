package com.kts.ciscorc.data.model.phonebook;

public class ResultInfo
{
    private String totalRows;

    private String limit;

    private String offset;

    public String getTotalRows ()
    {
        return totalRows;
    }

    public void setTotalRows (String totalRows)
    {
        this.totalRows = totalRows;
    }

    public String getLimit ()
    {
        return limit;
    }

    public void setLimit (String limit)
    {
        this.limit = limit;
    }

    public String getOffset ()
    {
        return offset;
    }

    public void setOffset (String offset)
    {
        this.offset = offset;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [totalRows = "+ totalRows +", limit = "+ limit +", offset = "+ offset +"]";
    }
}