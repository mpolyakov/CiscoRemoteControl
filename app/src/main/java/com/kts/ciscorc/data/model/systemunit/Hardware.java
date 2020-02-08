package com.kts.ciscorc.data.model.systemunit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hardware {

    @SerializedName("Module")
    @Expose
    private Module module;

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

}