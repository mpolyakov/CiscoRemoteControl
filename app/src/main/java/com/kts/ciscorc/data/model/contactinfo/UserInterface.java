package com.kts.ciscorc.data.model.contactinfo;

public class UserInterface
{
    private ContactInfo contactInfo;

    public ContactInfo getContactInfo ()
    {
        return contactInfo;
    }

    public void setContactInfo (ContactInfo contactInfo)
    {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [contactInfo = "+ contactInfo +"]";
    }
}