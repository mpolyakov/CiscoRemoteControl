
package com.kts.ciscorc.data.model.status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactMethodArr {

    @SerializedName("Number")
    @Expose
    private String number;
    @SerializedName("_item")
    @Expose
    private String item;
    @SerializedName("_maxOccurrence")
    @Expose
    private String maxOccurrence;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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