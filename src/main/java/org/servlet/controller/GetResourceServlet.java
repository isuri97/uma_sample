package org.servlet.controller;

import org.servlet.client.ResourceClient;
import org.servlet.client.core.ResourceClientProxyPool;
import org.servlet.client.exception.ClientException;
import org.servlet.model.ResourceModel.ErrorMessage;
import org.servlet.model.ResourceModel.GetResource;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;

@WebServlet(name = "GetResource", urlPatterns = "get-resource")
public class GetResourceServlet extends HttpServlet {

    private ResourceClient resourceClient;

    @Override
    public void init() throws ServletException {
        super.init();
        resourceClient = ResourceClientProxyPool.getInstance().getResourceClient();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ProcessingException {

        GetResource getResource = null;
        Response response = null;
        try {
            getResource = resourceClient.getResource(req.getParameter("resource_id"));
            req.setAttribute("resource", getResource);
            RequestDispatcher dispatcher = req.getRequestDispatcher("get-resource.jsp");
            dispatcher.forward(req, resp);
        } catch (ClientException e) {
            ErrorMessage error = e.getResponse().readEntity(ErrorMessage.class);
            req.setAttribute("error", error);
            RequestDispatcher dispatcher = req.getRequestDispatcher("get-resource.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
