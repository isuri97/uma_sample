package org.servlet.controller;

import org.servlet.client.ResourceClient;
import org.servlet.client.core.ResourceClientProxyPool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllResources",urlPatterns = "all-resources")
public class GetAllResourcesServlet extends HttpServlet {
    private ResourceClient resourceClient;

    @Override
    public void init() throws ServletException {
        super.init();
        resourceClient = ResourceClientProxyPool.getInstance().getResourceClient();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<String> resources= resourceClient.getAllResurces();
            req.setAttribute("resources", resources);
            RequestDispatcher dispatcher = req.getRequestDispatcher("get-all-resources.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
