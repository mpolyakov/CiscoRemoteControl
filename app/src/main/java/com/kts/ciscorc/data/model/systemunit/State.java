
package com.kts.ciscorc.data.model.systemunit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class State {

    @SerializedName("NumberOfActiveCalls")
    @Expose
    private String numberOfActiveCalls;
    @SerializedName("NumberOfInProgressCalls")
    @Expose
    private String numberOfInProgressCalls;
    @SerializedName("NumberOfSuspendedCalls")
    @Expose
    private String numberOfSuspendedCalls;

    public String getNumberOfActiveCalls() {
        return numberOfActiveCalls;
    }

    public void setNumberOfActiveCalls(String numberOfActiveCalls) {
        this.numberOfActiveCalls = numberOfActiveCalls;
    }

    public String getNumberOfInProgressCalls() {
        return numberOfInProgressCalls;
    }

    public void setNumberOfInProgressCalls(String numberOfInProgressCalls) {
        this.numberOfInProgressCalls = numberOfInProgressCalls;
    }

    public String getNumberOfSuspendedCalls() {
        return numberOfSuspendedCalls;
    }

    public void setNumberOfSuspendedCalls(String numberOfSuspendedCalls) {
        this.numberOfSuspendedCalls = numberOfSuspendedCalls;
    }

}