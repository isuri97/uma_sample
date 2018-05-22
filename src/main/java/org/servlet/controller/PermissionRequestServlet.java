package org.servlet.controller;

import org.servlet.client.PermissionClient;
import org.servlet.client.core.ResourceClientProxyPool;
import org.servlet.model.Ptmodel.Permissions;
import org.servlet.model.Ptmodel.RequestPermission;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by isuri on 5/21/18.
 */
@WebServlet(name = "RequestPermission" , urlPatterns = "/permission")
public class PermissionRequestServlet extends HttpServlet {

    private PermissionClient permissionClient;
    static Permissions permissions = new Permissions();


    @Override
    public void init() throws ServletException {
        super.init();
        permissionClient = ResourceClientProxyPool.getInstance().getPermissionClient();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String act = req.getParameter("act");
        if (act == null) {
            //no button has been selected
        } else if (act.equals("Add more permissions")) {
            //add button was pressed
            permissions.add(getResource(req));
            resp.sendRedirect("/request-permission.jsp");
        } else if (act.equals("Send request")) {
            //send button was pressed
            permissions.add(getResource(req));
            try {
                permissionClient.x(permissions, req, resp);
                RequestDispatcher dispatcher = req.getRequestDispatcher("request-permission.jsp");
            dispatcher.forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException(e);
            }

        } else {
            //someone has altered the HTML and sent a different value!
        }
    }
    private RequestPermission getResource(HttpServletRequest request){
        RequestPermission requestPermission = new RequestPermission();

        requestPermission.setResourceId(request.getParameter("resource_id"));
        String[] scopesList=request.getParameter("resource_scopes").split(",");
        List<String> scopes = new ArrayList<>();
        for (String s:scopesList){
            scopes.add(s);
        }
        requestPermission.setResource_scopes(scopes);


        return requestPermission;
    }

}