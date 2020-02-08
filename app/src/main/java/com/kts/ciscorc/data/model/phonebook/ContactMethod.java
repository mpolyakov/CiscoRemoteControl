package com.kts.ciscorc.data.model.phonebook;

public class ContactMethod
{
    private String callRate;

    private String item;

    private String number;

    private String callType;

    private String maxOccurrence;

    private String protocol;

    private String contactMethodId;

    public String getCallRate ()
    {
        return callRate;
    }

    public void setCallRate (String callRate)
    {
        this.callRate = callRate;
    }

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

    public String getCallType ()
    {
        return callType;
    }

    public void setCallType (String callType)
    {
        this.callType = callType;
    }

    public String getMaxOccurrence ()
    {
        return maxOccurrence;
    }

    public void setMaxOccurrence (String maxOccurrence)
    {
        this.maxOccurrence = maxOccurrence;
    }

    public String getProtocol ()
    {
        return protocol;
    }

    public void setProtocol (String protocol)
    {
        this.protocol = protocol;
    }

    public String getContactMethodId ()
    {
        return contactMethodId;
    }

    public void setContactMethodId (String contactMethodId)
    {
        this.contactMethodId = contactMethodId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [callRate = "+ callRate +", item = "+item+", number = "+ number +", callType = "+ callType +", maxOccurrence = "+maxOccurrence+", protocol = "+ protocol +", contactMethodId = "+ contactMethodId +"]";
    }
}