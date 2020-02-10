
package com.kts.ciscorc.data.model.status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SystemUnit {

    @SerializedName("Hardware")
    @Expose
    private Hardware hardware;
    @SerializedName("ProductId")
    @Expose
    private String productId;
    @SerializedName("ProductPlatform")
    @Expose
    private String productPlatform;
    @SerializedName("ProductType")
    @Expose
    private String productType;
    @SerializedName("Software")
    @Expose
    private Software software;
    @SerializedName("State")
    @Expose
    private State state;
    @SerializedName("Uptime")
    @Expose
    private String uptime;

    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductPlatform() {
        return productPlatform;
    }

    public void setProductPlatform(String productPlatform) {
        this.productPlatform = productPlatform;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

}