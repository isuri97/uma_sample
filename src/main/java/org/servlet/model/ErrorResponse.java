package org.servlet.model;

import java.io.Serializable;

/**
 * Created by isuri on 5/21/18.
 */

public class ErrorResponse implements Serializable {

    private String error = null;
    private String errorDescription = null;

    public String getError() {

        return error;
    }

    public void setError(String error) {

        this.error = error;
    }

    public String getErrorDescription() {

        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {

        this.errorDescription = errorDescription;
    }

}


