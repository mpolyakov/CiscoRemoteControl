package com.kts.ciscorc.data.model.phonebook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhonebookRequest {

    @SerializedName("Command")
    @Expose
    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

}