package org.servlet.controller;

import org.servlet.client.ResourceClient;
import org.servlet.client.core.ResourceClientProxyPool;
import org.servlet.model.ResourceModel.RegisterResource;
import org.servlet.model.ResourceModel.SaveResourceResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "RegisterResource" , urlPatterns = "/register")
public class RegisterResourceServlet extends HttpServlet {

    private ResourceClient resourceClient;

    @Override
    public void init() throws ServletException {
        super.init();
        resourceClient = ResourceClientProxyPool.getInstance().getResourceClient();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SaveResourceResponse saveResourceResponse= null;
        try {
            saveResourceResponse = resourceClient.saveResource(getResource(req));
            req.setAttribute("registerResource",saveResourceResponse);
            RequestDispatcher dispatcher = req.getRequestDispatcher("register-resource.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private RegisterResource getResource(HttpServletRequest request){
        RegisterResource registerResource = new RegisterResource();
        registerResource.setName(request.getParameter("resource_name"));
        registerResource.setDescription(request.getParameter("description"));
        registerResource.setIcon_uri(request.getParameter("icon_uri"));
        registerResource.setType(request.getParameter("type"));
        String[] scopesList=request.getParameter("scopes").split(",");
        List<String> scopes = new ArrayList<>();
        for (String s:scopesList){
            scopes.add(s);
        }
        registerResource.setResource_scope(scopes);
        return registerResource;
    }
}
