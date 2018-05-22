package org.servlet.model.ResourceModel;


public class SaveResourceResponse {

    private String resourceId;
    private String policy_uri;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getPolicy_uri() {
        return policy_uri;
    }

    public void setPolicy_uri(String policy_uri) {
        this.policy_uri = policy_uri;
    }
}
