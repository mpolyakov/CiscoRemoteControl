package com.kts.ciscorc.data.model.status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Software {

    @SerializedName("DisplayName")
    @Expose
    private String displayName;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("OptionKeys")
    @Expose
    private OptionKeys optionKeys;
    @SerializedName("ReleaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("Version")
    @Expose
    private String version;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OptionKeys getOptionKeys() {
        return optionKeys;
    }

    public void setOptionKeys(OptionKeys optionKeys) {
        this.optionKeys = optionKeys;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}