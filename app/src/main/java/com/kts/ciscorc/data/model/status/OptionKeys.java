
package com.kts.ciscorc.data.model.status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OptionKeys {

    @SerializedName("Encryption")
    @Expose
    private String encryption;
    @SerializedName("MultiSite")
    @Expose
    private String multiSite;
    @SerializedName("RemoteMonitoring")
    @Expose
    private String remoteMonitoring;

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    public String getMultiSite() {
        return multiSite;
    }

    public void setMultiSite(String multiSite) {
        this.multiSite = multiSite;
    }

    public String getRemoteMonitoring() {
        return remoteMonitoring;
    }

    public void setRemoteMonitoring(String remoteMonitoring) {
        this.remoteMonitoring = remoteMonitoring;
    }

}