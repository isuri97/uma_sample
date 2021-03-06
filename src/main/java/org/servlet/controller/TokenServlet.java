package org.servlet.controller;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.servlet.client.ResourceClient;
import org.servlet.client.TokenClient;
import org.servlet.client.core.ResourceClientProxyPool;
import org.servlet.model.TokenRequest;
import org.servlet.model.TokenResponse;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Form;

/**
 * Created by isuri on 5/15/18.
 */
@WebServlet(name = "TokenServlet", urlPatterns = "/getToken")
public class TokenServlet extends HttpServlet {

    private TokenClient tokenClient;

    @Override
    public void init() throws ServletException {
        super.init();
        tokenClient = ResourceClientProxyPool.getInstance().getOauthToken();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TokenResponse tokenResponse = null;
        try {

            tokenResponse = tokenClient.getToken(getTokenRequest(req));
            req.setAttribute("token", tokenResponse);
            RequestDispatcher dispatcher = req.getRequestDispatcher("grant/client-token.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Form getTokenRequest(HttpServletRequest httpServletRequest){
        Form tokenRequest = new Form();
        TokenRequest tokenRequest1 = new TokenRequest();
        tokenRequest.param("grant_type",httpServletRequest.getParameter("grant_type"));
        tokenRequest.param("grantType",httpServletRequest.getParameter("grantType"));
        tokenRequest.param("permissionTicket",httpServletRequest.getParameter("permissionTicket"));
        tokenRequest.param("idtoken",httpServletRequest.getParameter("idtoken"));
        tokenRequest.param("redirect_uri","https://localhost/callback");
        return tokenRequest;
    }
}
