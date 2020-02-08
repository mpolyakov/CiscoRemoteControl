package com.kts.ciscorc.data.model.systemunit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Module {

    @SerializedName("CompatibilityLevel")
    @Expose
    private String compatibilityLevel;
    @SerializedName("SerialNumber")
    @Expose
    private String serialNumber;

    public String getCompatibilityLevel() {
        return compatibilityLevel;
    }

    public void setCompatibilityLevel(String compatibilityLevel) {
        this.compatibilityLevel = compatibilityLevel;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

}