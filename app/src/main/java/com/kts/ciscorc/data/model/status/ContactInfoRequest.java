package com.kts.ciscorc.data.model.status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactInfoRequest {

    @SerializedName("Status")
    @Expose
    private com.kts.ciscorc.data.model.status.Status status;

    public com.kts.ciscorc.data.model.status.Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}