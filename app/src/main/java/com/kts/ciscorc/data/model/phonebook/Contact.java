package com.kts.ciscorc.data.model.phonebook;

public class Contact
{
    private String item;

    private String title;

    private String contactId;

    private String tag;

    private String maxOccurrence;

    private ContactMethod contactMethod;

    private String name;

    public String getItem ()
    {
        return item;
    }

    public void setItem (String item)
    {
        this.item = item;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getContactId ()
    {
        return contactId;
    }

    public void setContactId (String contactId)
    {
        this.contactId = contactId;
    }

    public String getTag ()
    {
        return tag;
    }

    public void setTag (String tag)
    {
        this.tag = tag;
    }

    public String getMaxOccurrence ()
    {
        return maxOccurrence;
    }

    public void setMaxOccurrence (String maxOccurrence)
    {
        this.maxOccurrence = maxOccurrence;
    }

    public ContactMethod getContactMethod ()
    {
        return contactMethod;
    }

    public void setContactMethod (ContactMethod contactMethod)
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
        return "ClassPojo [item = "+item+", title = "+ title +", contactId = "+ contactId +", tag = "+ tag +", maxOccurrence = "+maxOccurrence+", contactMethod = "+ contactMethod +", name = "+ name +"]";
    }
}