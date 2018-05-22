<%@ page import="org.servlet.model.ResourceModel.RegisterResource" %>
<%@ page import="org.servlet.model.ResourceModel.GetResource" %>
<%@ page import="org.servlet.model.ErrorResponse" %><%--
  Created by IntelliJ IDEA.
  User: isuri
  Date: 5/3/18
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8"/>
    
    <title>Get Resource details</title>

</head>
<body>
<%@include file="Common/navbar.html" %>
<div class="container">
    <div id="register" class="animate form">
        <form id="contact" action="/get-resource" method="post">
            <h1>
                <center> Get Resource details</center>
            </h1>
            <p>
                <%-- <label>Resource ID : </label> <input type="text" name="resource_id" id="resource_id">--%>
                <label for="resource_id" class="rid">Resource Id :</label></p>
            <fieldset>
                <input id="resource_id" name="resource_id" required="required" type="text" size="40"/>
            </fieldset>
            <fieldset>
                <button name="submit" type="submit" id="contact-submit" value="Register resource"> Get resource
                </button>
            </fieldset>
            <fieldset>
                <button name="reset " type="reset" value="Reset" id="contact-reset" value="clear Studio">Clear form
                </button>
            </fieldset>
            
            
            <%-- Display the registerResource details --%>
            <%-- <form id="form-registerResource" action="/get-resource" method="post">
                 <div class="form-group">
                     <label>Resource ID : </label> <input type="text" name="resource_id" id="resource_id">
                 </div>
                 <hr>
                 <div class="wrapper">
                 <input type="submit" value="Submit" class="btn btn-default" style="width: 400px;">
                 </div>
                 <br>
             </form>--%>
            <%
                if (request.getAttribute("resource") != null) {
                    GetResource getResource = (GetResource) request.getAttribute("resource");
            %>
            
            <h1>Resource</h1>
            <p>Name: <%= getResource.getName()%>
            </p>
            <p>Scopes: <%= getResource.getResource_scope()%>
            </p>
            <p>Type: <%= getResource.getType()%>
            </p>
            <p>Icon URI: <%= getResource.getIcon_uri()%>
            </p>
            <p>Description: <%= getResource.getDescription()%>
            </p>
            <% } %>
    
            <br>
            <%
                if (request.getAttribute("errorMessage") != null) {
                    String registerResource = (String) request.getAttribute("errorMessage");
            %>
            <h4>Error in the request.</h4>
            <div>error: <%= registerResource%></div>
           <%-- <div>error_description: <%= registerResource.getErrorDescription()%></div>--%>
            <% } %>
        </form>
    </div>
</div>
</body>
</html>