package com.kts.ciscorc.data.model.status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("SystemUnit")
    @Expose
    private SystemUnit systemUnit;
    @SerializedName("_product")
    @Expose
    private String product;
    @SerializedName("_version")
    @Expose
    private String version;
    @SerializedName("_apiVersion")
    @Expose
    private String apiVersion;
    @SerializedName("UserInterface")
    @Expose
    private UserInterface userInterface;
    @SerializedName("Network")
    @Expose
    private Network network;

    public SystemUnit getSystemUnit() {
        return systemUnit;
    }

    public void setSystemUnit(SystemUnit systemUnit) {
        this.systemUnit = systemUnit;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }



    public UserInterface getUserInterface() {
        return userInterface;
    }

    public void setUserInterface(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

}