package com.kts.ciscorc.data.model.contactinfo;

public class ContactInfo
{
    private ContactMethod[] contactMethod;

    private String name;

    public ContactMethod[] getContactMethod ()
    {
        return contactMethod;
    }

    public void setContactMethod (ContactMethod[] contactMethod)
    {
        this.contactMethod = contactMethod;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [contactMethod = "+ contactMethod +", name = "+ name +"]";
    }
}