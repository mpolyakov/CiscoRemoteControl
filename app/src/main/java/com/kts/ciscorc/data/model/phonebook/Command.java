package com.kts.ciscorc.data.model.phonebook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Command {

    @SerializedName("PhonebookSearchResult")
    @Expose
    private PhonebookSearchResult phonebookSearchResult;

    public PhonebookSearchResult getPhonebookSearchResult() {
        return phonebookSearchResult;
    }

    public void setPhonebookSearchResult(PhonebookSearchResult phonebookSearchResult) {
        this.phonebookSearchResult = phonebookSearchResult;
    }

}