package com.kts.ciscorc.data.model.phonebook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultInfo {

    @SerializedName("Offset")
    @Expose
    private String offset;
    @SerializedName("Limit")
    @Expose
    private String limit;
    @SerializedName("TotalRows")
    @Expose
    private String totalRows;

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(String totalRows) {
        this.totalRows = totalRows;
    }

}