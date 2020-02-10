
package com.kts.ciscorc.data.model.status;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactInfo {

    @SerializedName("ContactMethod")
    @Expose
    private List<ContactMethod> contactMethod = null;
    @SerializedName("Name")
    @Expose
    private String name;

    public List<ContactMethod> getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(List<ContactMethod> contactMethod) {
        this.contactMethod = contactMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}