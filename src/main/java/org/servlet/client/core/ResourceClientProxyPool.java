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
            headers.add("Authorization", "Bearer 7e2c5f1c-03af-3b2a-8dc4-b0f0665663ff");
            resourceClient = new ResourceClientImpl(targetBaseServiceURL, headers);
        }
        return resourceClient;
    }

    public TokenClient getOauthToken() {

        if (tokenClient == null) {
            MultivaluedMap headers = new MultivaluedMapImpl();
            headers.add("Authorization", "Basic Rm5uN3FaMnVNczh1Umo1YnYwdzRmR1VMRFAwYTp5eWJuREpyY0hxb295SXpwa1l3S1RmX0w1VUVh");
            tokenClient = new TokenClientImpl("https://localhost:9443/oauth2/", headers);
        }
        return tokenClient;
    }

    public PermissionClient getPermissionClient() {

        if (permissionClient == null) {
            MultivaluedMap headers = new MultivaluedMapImpl();
            headers.add("Authorization", "Bearer 7e2c5f1c-03af-3b2a-8dc4-b0f0665663ff");
            permissionClient = new PermissionClientImpl("https://localhost:9443/api/identity/oauth2/uma/permission/v1.0/permission", headers);
        }

        return permissionClient;
    }

}
