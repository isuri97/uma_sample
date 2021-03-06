package org.servlet.model;

public class TokenRequest {

    private String grant_type;
    private String code;
    private String scope;
    private String redirect_uri;
    private String idtoken;

    private String grantType;
    private String permissionTicket;

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getGrantType() {

        return grantType;
    }

    public void setGrantType(String grantType) {

        this.grantType = grantType;
    }

    public String getPermissionTicket() {

        return permissionTicket;
    }

    public void setPermissionTicket(String permissionTicket) {

        this.permissionTicket = permissionTicket;
    }

    public String getIdtoken() {

        return idtoken;
    }

    public void setIdtoken(String idtoken) {

        this.idtoken = idtoken;
    }
}
