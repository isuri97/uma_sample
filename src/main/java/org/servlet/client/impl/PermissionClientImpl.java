package org.servlet.client.impl;



import org.servlet.client.AbstractRestClient;
import org.servlet.client.PermissionClient;
import org.servlet.model.ErrorResponse;
import org.servlet.model.Ptmodel.PermissionTicketResponse;
import org.servlet.model.Ptmodel.Permissions;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class PermissionClientImpl extends AbstractRestClient implements PermissionClient {

    public PermissionClientImpl(String targetServiceUrl, MultivaluedMap<String, Object> headers) {

        super(targetServiceUrl, headers);
    }

    public void x(Permissions permissions, HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Entity<Permissions> entity = Entity.entity(permissions, MediaType.APPLICATION_JSON_TYPE);
        Response response = super.post(this.targetServiceUrl, entity);
        if (response.getStatus() == 201) {
            req.setAttribute("permissionRequest", response.readEntity(PermissionTicketResponse.class));
            RequestDispatcher dispatcher = req.getRequestDispatcher("request-permission.jsp");
            dispatcher.forward(req, resp);
        } else if (response.getStatus() == 400) {
            req.setAttribute("errorMessage", response.readEntity(ErrorResponse.class));
            RequestDispatcher dispatcher = req.getRequestDispatcher("request-permission.jsp");
            dispatcher.forward(req, resp);
        } else {
            throw new Exception("Error");
        }
    }

}

