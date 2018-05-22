package org.servlet.client;

import org.servlet.model.TokenRequest;
import org.servlet.model.TokenResponse;

import javax.ws.rs.core.Form;

/**
 * Created by isuri on 5/17/18.
 */
public interface TokenClient {

    TokenResponse getToken(Form tokenRequest) throws Exception;

    String getCode() throws Exception;
}
