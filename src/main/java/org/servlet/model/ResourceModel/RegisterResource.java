package org.servlet.model.ResourceModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class RegisterResource implements Serializable {
    private List<String> resource_scope = new ArrayList<String>();
    private String name="Res";
    private String type;
    private String icon_uri;
    private String description;

    public List<String> getResource_scope() {
        return resource_scope;
    }

    public void setResource_scope(List<String> resource_scope) {
        this.resource_scope = resource_scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon_uri() {
        return icon_uri;
    }

    public void setIcon_uri(String icon_uri) {
        this.icon_uri = icon_uri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
