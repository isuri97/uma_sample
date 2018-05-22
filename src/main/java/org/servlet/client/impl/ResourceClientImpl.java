package org.servlet.client.impl;

import org.servlet.client.AbstractRestClient;
import org.servlet.client.ResourceClient;
import org.servlet.model.ErrorResponse;
import org.servlet.model.ResourceModel.GetResource;
import org.servlet.model.ResourceModel.RegisterResource;
import org.servlet.model.ResourceModel.SaveResourceResponse;
import org.servlet.model.ResourceModel.UpdateResourceResponse;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.List;


public class ResourceClientImpl extends AbstractRestClient implements ResourceClient {

    //AbstractRestClient abstractRestClient;
    public static String message = null;

    public static ErrorResponse errorResponse = null;

    public ResourceClientImpl(String targetServiceUrl,MultivaluedMap<String, Object> headers) {
        super(targetServiceUrl,headers);
    }


    @Override
    public GetResource getResource(String id) throws Exception {
        Response response = null;
        try {
            response = super.get(this.targetServiceUrl + id);
            GetResource getResource= response.readEntity(GetResource.class);
            return getResource;
        } catch (Exception e) {
            /*errorResponse = new ErrorResponse();
            String errorcode = errorResponse.getError();
            String errorDescription = errorResponse.getErrorDescription();*/
            message = "The exception raised due to" + e;
            System.out.print(message);
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            close(response);
        }
    }

    @Override
    public SaveResourceResponse saveResource(RegisterResource registerResource) throws Exception {
        Response response = null;
        try {
            Entity<RegisterResource> entity = Entity.entity(registerResource, MediaType.APPLICATION_JSON_TYPE);

            response = super.post(this.targetServiceUrl, entity);
            SaveResourceResponse saveResourceResponse = response.readEntity(SaveResourceResponse.class);
            return saveResourceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            close(response);
        }
    }

    @Override
    public List<String> getAllResurces() throws Exception {
        Response response = null;
        try {
            response = super.get(this.targetServiceUrl);
            List<String> resources= response.readEntity(new GenericType<List<String>>() {
            });
            return resources;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            close(response);
        }
    }

    @Override
    public UpdateResourceResponse updateResource(String id,RegisterResource registerResource) throws Exception {
        Response response = null;
        try {
            Entity<RegisterResource> entity = Entity.entity(registerResource, MediaType.APPLICATION_JSON_TYPE);
            response = super.put(this.targetServiceUrl+id, entity);
            UpdateResourceResponse updateResourceResponse= response.readEntity(UpdateResourceResponse.class);
            return updateResourceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            close(response);
        }
    }

    @Override
    public String deleteResource(String id) throws Exception {
        Response response = null;
        try {
            response = super.delete(this.targetServiceUrl+id);
            return id+" Deleted";
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            close(response);
        }
    }
}