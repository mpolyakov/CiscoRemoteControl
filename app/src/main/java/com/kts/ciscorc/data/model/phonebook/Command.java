package com.kts.ciscorc.data.model.phonebook;

public class Command
{
    private PhonebookSearchResult phonebookSearchResult;

    public PhonebookSearchResult getPhonebookSearchResult ()
    {
        return phonebookSearchResult;
    }

    public void setPhonebookSearchResult (PhonebookSearchResult phonebookSearchResult)
    {
        this.phonebookSearchResult = phonebookSearchResult;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [phonebookSearchResult = "+ phonebookSearchResult +"]";
    }
}