
<%@ page import="org.servlet.client.impl.PermissionClientImpl" %>
<%@ page import="org.servlet.model.ResourceModel.Ptmodel.PermissionTicketResponse" %>
<%@ page import="org.servlet.model.ResourceModel.Ptmodel.ErrorResponse" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8"/>
    <title>Request Permission</title>
</head>
<body>
<%@include file="Common/navbar.html" %>
<div class="container">
    <div id="register" class="animate form">
        <form id="contact" action="/permission" method="post">
<h1>----- Request Permission -----</h1>

    <table>
        <tr>
            <td>Add resource id :</td>
            <td> <input type="text" name="resource_id" id="resource_id"></td>
        </tr>
        <tr>
            <td>Add resource scopes :</td>
            <td> <input type="text" name="resource_scopes" id="resource_scopes"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add more permissions" name="act"></td>
            <td><input type="submit" value="Send request" name="act"></td>
        </tr>
    </table>



<%
    if (request.getAttribute("permissionRequest") != null) {
        PermissionTicketResponse permissionTicketResponse = (PermissionTicketResponse) request.getAttribute("permissionRequest");

%>
<h4>Permission ticket created successfully.</h4>
<div>Http status code: <%=PermissionClientImpl.httpStatusCode%></div>
<div>Permission ticket: <%= permissionTicketResponse.getTicket()%></div>

<% } %>
<br>
<%
    if (request.getAttribute("errorMessage") != null) {
        ErrorResponse permissionTicketResponse = (ErrorResponse) request.getAttribute("errorMessage");

%>
<h4>Error in the request.</h4>
<div>Http status code: <%=PermissionClientImpl.httpStatusCode%></div>
<div>error: <%= permissionTicketResponse.getError()%></div>
<div>error_description: <%= permissionTicketResponse.getErrorDescription()%></div>
<% } %>

        </form>
    </div>
</div>
</body>
</html>
