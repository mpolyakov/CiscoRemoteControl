package com.kts.ciscorc.data.model.phonebook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactMethod {

    @SerializedName("ContactMethodId")
    @Expose
    private String contactMethodId;
    @SerializedName("Number")
    @Expose
    private String number;
    @SerializedName("Protocol")
    @Expose
    private String protocol;
    @SerializedName("CallRate")
    @Expose
    private String callRate;
    @SerializedName("CallType")
    @Expose
    private String callType;
    @SerializedName("_item")
    @Expose
    private String item;
    @SerializedName("_maxOccurrence")
    @Expose
    private String maxOccurrence;

    public String getContactMethodId() {
        return contactMethodId;
    }

    public void setContactMethodId(String contactMethodId) {
        this.contactMethodId = contactMethodId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getCallRate() {
        return callRate;
    }

    public void setCallRate(String callRate) {
        this.callRate = callRate;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMaxOccurrence() {
        return maxOccurrence;
    }

    public void setMaxOccurrence(String maxOccurrence) {
        this.maxOccurrence = maxOccurrence;
    }

}