package com.kts.ciscorc.data.model.contactinfo;

public class ContactMethod
{
    private String item;

    private String number;

    private String maxOccurrence;

    public String getItem ()
    {
        return item;
    }

    public void setItem (String item)
    {
        this.item = item;
    }

    public String getNumber ()
    {
        return number;
    }

    public void setNumber (String number)
    {
        this.number = number;
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
        return "ClassPojo [item = "+item+", number = "+ number +", maxOccurrence = "+maxOccurrence+"]";
    }
}