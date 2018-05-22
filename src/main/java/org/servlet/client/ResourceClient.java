package org.servlet.client;

import org.servlet.model.ResourceModel.GetResource;
import org.servlet.model.ResourceModel.RegisterResource;
import org.servlet.model.ResourceModel.SaveResourceResponse;
import org.servlet.model.ResourceModel.UpdateResourceResponse;

import java.util.List;

public interface ResourceClient {

    GetResource getResource(String id) throws Exception;

    SaveResourceResponse saveResource(RegisterResource registerResource) throws Exception;

    List<String> getAllResurces() throws Exception;

    UpdateResourceResponse updateResource(String id,RegisterResource registerResource) throws Exception;

    String deleteResource(String id) throws Exception;


}
