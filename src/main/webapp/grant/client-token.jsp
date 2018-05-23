<%@ page import="org.servlet.model.ResourceModel.SaveResourceResponse" %>
<%@ page import="org.servlet.model.TokenResponse" %><%--
  Created by IntelliJ IDEA.
  User: isuri
  Date: 5/15/18
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Requesting OAuth token</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../style.css">
    <meta charset="UTF-8"/>

</head>

<body>
<%@include file="../Common/navbar.html" %>
<div class="container">
    <div id="register" class="animate form">
        <form id="contact" action="/getToken" method="post">
            <h1>
                <center> Obtain Token</center>
            </h1>
            <p>
                <%-- <label>Resource ID : </label> <input type="text" name="resource_id" id="resource_id">--%>
                <label for="grant_type" >Grant Type :</label></p>
            <fieldset>
                <input id="grant_type" name="grant_type" required="required" type="text" size="40"/>
            </fieldset>
            <label for="grantType" >Grant Name:</label></p>
            <fieldset>
                <input id="grantType" name="grantType" required="required" type="text" size="40"/>
            </fieldset>
            <label for="permissionTicket" >Permission Ticket :</label></p>
            <fieldset>
                <input id="permissionTicket" name="permissionTicket" required="required" type="text" size="40"/>
            </fieldset>
            
            <fieldset>
                <button name="submit" type="submit" id="contact-submit" value="Register resource"> Get Token</button>
            </fieldset>
            <fieldset>
                <button name="reset " type="reset" value="Reset" id="contact-reset" value="clear Studio">Clear form
                </button>
            </fieldset>
            
            <%
                if (request.getAttribute("token") != null) {
                    TokenResponse tokenResponse = (TokenResponse) request.getAttribute("token");
    /*String token = (String) request.getAttribute("token");*/
            
            %>
            
            <p>Token <%=tokenResponse.getAccess_token()%>
            </p><%}%>
        </form>
    </div>
</div>
</body>
</html>

