<%--
  Created by IntelliJ IDEA.
  User: isuri
  Date: 5/21/18
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="org.servlet.model.Ptmodel.PermissionTicketResponse" %>
<%@ page import="org.servlet.model.ErrorResponse" %>

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
<div class="container">
    <div id="register" class="animate form">
        <form id="contact" action="/permission" method="post">
            <center>
            <h1>
                Request Permission
            </h1>
<br>
    <table>
        <tr>
            <td>Add resource id :</td>
            <td> <input type="text" name="resource_id" id="resource_id"></td>
        </tr>
        <tr>
            <td>Add resource scopes :</td>
            <td> <input type="text" name="resource_scopes" id="resource_scopes"></td>
        </tr>
        <br>
        <tr>
            <td><button name="submit" type="submit" id="contact-submit" value="Add more permissions">Add more permissions</button></td>
            <td><button name="submit" type="submit" id="act" value="Send request">Send request</button></td>
        </tr>
    </table>



<%
    if (request.getAttribute("permissionRequest") != null) {
        PermissionTicketResponse permissionTicketResponse = (PermissionTicketResponse) request.getAttribute("permissionRequest");
%>
<h4>Permission ticket created successfully.</h4>
<div>Permission ticket: <%= permissionTicketResponse.getTicket()%></div>

<% } %>
<br>
<%
    if (request.getAttribute("errorMessage") != null) {
        ErrorResponse permissionTicketResponse = (ErrorResponse) request.getAttribute("errorMessage");
%>
<h4>Error in the request.</h4>
<div>error: <%= permissionTicketResponse.getError()%></div>
<div>error_description: <%= permissionTicketResponse.getErrorDescription()%></div>
<% } %>

            </center>
        </form>
    </div>
</div>
</body>
</html>