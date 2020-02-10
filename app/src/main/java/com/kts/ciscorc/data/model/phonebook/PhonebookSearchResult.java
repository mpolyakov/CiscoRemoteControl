package com.kts.ciscorc.data.model.phonebook;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhonebookSearchResult {

    @SerializedName("Contact")
    @Expose
    private List<Contact> contact = null;
    @SerializedName("ResultInfo")
    @Expose
    private ResultInfo resultInfo;
    @SerializedName("_status")
    @Expose
    private String status;

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}