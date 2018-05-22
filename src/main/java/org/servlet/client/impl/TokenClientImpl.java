package org.servlet.client.impl;

import org.jboss.resteasy.client.jaxrs.BasicAuthentication;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;
import org.servlet.client.AbstractRestClient;
import org.servlet.client.ResourceClient;
import org.servlet.client.TokenClient;
import org.servlet.model.TokenRequest;
import org.servlet.model.TokenResponse;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * Created by isuri on 5/17/18.
 */
public class TokenClientImpl extends AbstractRestClient implements TokenClient {

    public TokenClientImpl(String targetServiceUrl, MultivaluedMap<String, Object> headers) {

        super(targetServiceUrl, headers);
    }


    @Override
    public TokenResponse getToken(Form tokenRequest) throws Exception{

        Response response = null;
        try {
            Entity<Form> entity = Entity.form(tokenRequest);
            response = super.post(this.targetServiceUrl+ "token", entity,MediaType.APPLICATION_FORM_URLENCODED_TYPE,new BasicAuthentication("Fnn7qZ2uMs8uRj5bv0w4fGULDP0a","yybnDJrcHqooyIzpkYwKTf_L5UEa"));
            TokenResponse tokenResponse = response.readEntity(TokenResponse.class);
            return tokenResponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            close(response);
        }
    }

    @Override
    public String getCode() throws Exception {
        Response response = null;
        try {
            MultivaluedMap queryParams = new MultivaluedMapImpl();
            queryParams.add("response_type", "code");
            queryParams.add("client_id","ib2SaymkCqecsnovshJcKFfN8bAa");
            queryParams.add("redirect_uri","https://localhost/callback");
            queryParams.add("scope","uma_protection");
            response = super.get(this.targetServiceUrl+"authorize",queryParams);
            TokenResponse tokenResponse = response.readEntity(TokenResponse.class);
            return tokenResponse.getAccess_token();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            close(response);
        }
    }
}
