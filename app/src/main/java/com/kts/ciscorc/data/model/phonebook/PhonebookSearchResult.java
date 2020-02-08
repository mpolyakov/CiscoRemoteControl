package com.kts.ciscorc.data.model.phonebook;

public class PhonebookSearchResult
{
    private ResultInfo resultInfo;

    private String status;

    private Contact[] contact;

    public ResultInfo getResultInfo ()
    {
        return resultInfo;
    }

    public void setResultInfo (ResultInfo resultInfo)
    {
        this.resultInfo = resultInfo;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public Contact[] getContact ()
    {
        return contact;
    }

    public void setContact (Contact[] contact)
    {
        this.contact = contact;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [resultInfo = "+ resultInfo +", status = "+status+", contact = "+ contact +"]";
    }
}