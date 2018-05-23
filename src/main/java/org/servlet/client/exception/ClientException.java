package org.servlet.client.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Created by isuri on 5/22/18.
 */
public class ClientException extends WebApplicationException {

    public ClientException(Response response) {

        super(response);
    }
}


