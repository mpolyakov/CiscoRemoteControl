package com.kts.ciscorc.data.model.systemunit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SystemUnitRequest {

    @SerializedName("Status")
    @Expose
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}