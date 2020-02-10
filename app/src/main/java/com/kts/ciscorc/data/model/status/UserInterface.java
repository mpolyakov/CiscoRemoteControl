package com.kts.ciscorc.data.model.status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInterface {

    @SerializedName("ContactInfo")
    @Expose
    private ContactInfo contactInfo;

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

}