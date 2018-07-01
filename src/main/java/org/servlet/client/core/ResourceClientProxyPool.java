package org.servlet.client.core;

import org.jboss.resteasy.specimpl.MultivaluedMapImpl;
import org.servlet.client.PermissionClient;
import org.servlet.client.ResourceClient;
import org.servlet.client.TokenClient;
import org.servlet.client.impl.PermissionClientImpl;
import org.servlet.client.impl.ResourceClientImpl;
import org.servlet.client.impl.TokenClientImpl;

import javax.ws.rs.core.MultivaluedMap;

public class ResourceClientProxyPool {

    private static ResourceClientProxyPool instance = null;

    protected String targetBaseServiceURL = null;

    private ResourceClient resourceClient;

    private TokenClient tokenClient;

    private PermissionClient permissionClient;

    protected ResourceClientProxyPool(final String targetBaseServiceURL) {

        this.targetBaseServiceURL = targetBaseServiceURL;
    }

    public static ResourceClientProxyPool getInstance() {

        String targetUrl = "https://localhost:9443/api/identity/oauth2/uma/resourceregistration/v1.0/resource/";
        if (instance == null) {
            instance = new ResourceClientProxyPool(targetUrl);

        }
        return instance;
    }

    public ResourceClient getResourceClient() {

        if (resourceClient == null) {
            MultivaluedMap headers = new MultivaluedMapImpl();
            headers.add("Authorization", "Bearer 8e4a431a-2777-3263-9a55-e46d45b7b90f");
            resourceClient = new ResourceClientImpl(targetBaseServiceURL, headers);
        }
        return resourceClient;
    }

    public TokenClient getOauthToken() {

        if (tokenClient == null) {
            MultivaluedMap headers = new MultivaluedMapImpl();
            headers.add("Authorization", "Basic Ulh4T2R0UVg3QXljb2hkdURKclRQdXAzZkw0YTpYMXdSbW42NlNFWUpQYTVqSVo1S0VqMGhFbVlh");
            tokenClient = new TokenClientImpl("https://localhost:9443/oauth2/", headers);
        }
        return tokenClient;
    }

    public PermissionClient getPermissionClient() {

        if (permissionClient == null) {
            MultivaluedMap headers = new MultivaluedMapImpl();
            headers.add("Authorization", "Bearer 8e4a431a-2777-3263-9a55-e46d45b7b90f");
            permissionClient = new PermissionClientImpl("https://localhost:9443/api/identity/oauth2/uma/permission/v1.0/permission", headers);
        }

        return permissionClient;
    }

}
