package com.kts.ciscorc.data.model.phonebook;

public class PhonebookRequest
{
    private Command command;

    public Command getCommand ()
    {
        return command;
    }

    public void setCommand (Command command)
    {
        this.command = command;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [command = "+ command +"]";
    }
}