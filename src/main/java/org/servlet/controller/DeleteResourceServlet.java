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


@WebServlet(name = "DeleteResource",urlPatterns = "/delete")
public class DeleteResourceServlet extends HttpServlet {
    private ResourceClient resourceClient;

    @Override
    public void init() throws ServletException {
        super.init();
        resourceClient = ResourceClientProxyPool.getInstance().getResourceClient();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = resourceClient.deleteResource(req.getParameter("resource_id"));
            req.setAttribute("delete", id);
            RequestDispatcher dispatcher = req.getRequestDispatcher("delete-resource.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
