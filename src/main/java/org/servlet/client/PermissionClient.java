package org.servlet.client;



import org.servlet.model.ResourceModel.Ptmodel.Permissions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PermissionClient {

    void requestPermissions(Permissions permissions, HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
