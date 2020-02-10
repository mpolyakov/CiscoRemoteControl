
package com.kts.ciscorc.data.model.status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Network {

    @SerializedName("IPv4")
    @Expose
    private IPv4 iPv4;
    @SerializedName("_item")
    @Expose
    private String item;
    @SerializedName("_maxOccurrence")
    @Expose
    private String maxOccurrence;

    public IPv4 getIPv4() {
        return iPv4;
    }

    public void setIPv4(IPv4 iPv4) {
        this.iPv4 = iPv4;
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