package com.kts.ciscorc.data.model.phonebook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ContactId")
    @Expose
    private String contactId;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Tag")
    @Expose
    private String tag;
    @SerializedName("ContactMethod")
    @Expose
    private ContactMethod contactMethod;
    @SerializedName("_item")
    @Expose
    private String item;
    @SerializedName("_maxOccurrence")
    @Expose
    private String maxOccurrence;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public ContactMethod getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(ContactMethod contactMethod) {
        this.contactMethod = contactMethod;
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