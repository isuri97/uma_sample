package org.servlet.client;


import org.servlet.model.Ptmodel.PermissionTicketResponse;
import org.servlet.model.Ptmodel.Permissions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PermissionClient {

    void x(Permissions permissions, HttpServletRequest req, HttpServletResponse resp) throws Exception;

}

