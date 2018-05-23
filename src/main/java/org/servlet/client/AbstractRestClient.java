/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.servlet.client;

import org.jboss.resteasy.client.jaxrs.BasicAuthentication;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;
import org.servlet.client.exception.ClientException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * @author USER
 */
public class AbstractRestClient {

    protected String targetServiceUrl;
    private MultivaluedMap<String, Object> headers;

    public AbstractRestClient(String targetServiceUrl, MultivaluedMap<String, Object> headers) {
        this.targetServiceUrl = targetServiceUrl;
        this.headers = headers;
    }

    public ResteasyWebTarget createTarget(final String serviceUrl) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(serviceUrl);
        return target;
    }

    public Invocation.Builder createBuilder(final String serviceUrl) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(serviceUrl);

        return target.request();
    }

    public Response post(final String url, final Entity<?> entity) throws Exception {
        Response response = createTarget(url).request().headers(headers).post(entity);
        /*if (!isSuccess(response)) {

            throw new Exception("ERROR");
        }*/
        return response;
    }
    public Response post(final String url, final Entity<?> entity, MediaType applicationFormUrlencodedType, final BasicAuthentication basicAuthentication) throws Exception {
        Response response = createTarget(url).register(basicAuthentication).request().headers(headers).post(entity);
        /*if (!isSuccess(response)) {

            throw new Exception("ERROR");
        }*/
        return response;
    }

    public Response put(final String url, final Entity<?> entity) throws Exception {

        Response response = createTarget(url).request().headers(headers).put(entity);

        if (!isSuccess(response)) {

            throw new Exception("ERROR");
        }
        return response;
    }

    /**
     * Delete entity form given url and headers
     *
     * @param url WS url path for delete request
     * @return {@link Response}
     * @throws Exception throws when exception occurred in WS side
     */
    public Response delete(final String url) throws Exception {

        Response response = createTarget(url).request().headers(headers).delete();

        if (response.getStatus()!=204) {

            throw new Exception("ERROR");
        }
        return response;
    }

    /**
     * Get the server resource from given url and headers.
     *
     * @param url        Service URL for given resource
     * @param parameters MultivaluedMap with query headers.
     * @return Response
     * @throws Exception throws if any server exception occurred.
     */
    public Response get(final String url, final MultivaluedMap<String, Object> parameters) throws Exception {

        Response response = createTarget(url).queryParams(parameters).request().get();

        if (!isSuccess(response)) {

            throw new ClientException(response);
        }
        return response;
    }

    /**
     * get the server resource form given url
     *
     * @param url URL of the resource
     * @return Response
     * @throws Exception if a server error occurred
     */
    public Response get(final String url) throws Exception {

        Response response = createTarget(url).request().headers(headers).get();
        if (!isSuccess(response)) {
            throw new ClientException(response);
        }
        return response;
    }

    public Response getJson(final String url) throws Exception {

        Response response = createTarget(url).request().accept(MediaType.APPLICATION_FORM_URLENCODED_TYPE).get();
        if (!isSuccess(response)) {
            processException(response);
        }
        return response;
    }

    /**
     * Check the server response whether success or other failures.
     *
     * @param response Rest server response
     * @return true if server returns 200 as response code
     */
    public boolean isSuccess(final Response response) {
        return response.getStatus() == Response.Status.OK.getStatusCode() || response.getStatus() == Response.Status.CREATED.getStatusCode();
    }

    /**
     * Close the response.
     *
     * @param response Response
     */
    public void close(final Response response) {

        if (response != null) {

            response.close();
        }
    }


    public void processException(Response response) throws Exception {
        if(response.getStatus()==401){
            throw new Exception("Token Expired");
        } else if (response.getStatus() == 404) {
            throw new Exception("Not found");
        } else {
            throw new Exception("ERROR");
        }


    }

}
