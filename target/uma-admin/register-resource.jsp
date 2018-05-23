<%@ page import="org.servlet.model.ResourceModel.RegisterResource" %>
<%@ page import="org.servlet.model.ResourceModel.SaveResourceResponse" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: isuri
  Date: 5/3/18
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8"/>
    
    <title>Register Resource details</title>

</head>
<body>
<%@include file="Common/navbar.html" %>
<div class="container">
    <div id="register" class="animate form">
        <form id="contact" action="/register" method="post">
            <h1>
                <center> Register Resource</center>
            </h1>
            <p>
                <label for="resource_name" class="rname">Resource Name :</label></p>
            <fieldset>
                <input id="resource_name" name="resource_name" required="required" type="text" size="40"/>
            </fieldset>
            
            <p>
                <label for="scopes" class="uname">Resource Scopes :</label></p>
            <fieldset>
                <input id="scopes" name="scopes" required="required" type="text" size="25"/>
            </fieldset>
            <p>
                <label for="type" class="uname">Type of the resource :</label></p>
            <fieldset>
                <input id="type" name="type" required="required" type="text" size="25"/>
            </fieldset>
            <p>
                <label for="icon_uri" class="uname">Icon URI of the resource :</label></p>
            <fieldset>
                <input id="icon_uri" name="icon_uri" required="required" type="text" size="25"/>
            </fieldset>
            
            <p>
                <label for="description" class="uname">Resource Description :</label></p>
            <fieldset>
                <input id="description" name="description" required="required" type="text" size="25"/>
            </fieldset>
            <fieldset>
                
                <button name="submit" type="submit" id="contact-submit" value="Register resource">Register resource details
                </button>
            
            </fieldset>
            
            <fieldset>
                <button name="reset " type="reset" value="Reset" id="contact-reset" value="clear Studio">Clear form
                </button>
            
            </fieldset>
            
            
            <%--
                <h3>----- Register Resource -----</h3>
                <hr>
                
                <form id="form-registerResource" action="/register" method="post">
                    &lt;%&ndash; Enter registerResource details which should be added &ndash;%&gt;
                    <label>Add Resource Name :</label>&nbsp&nbsp&nbsp<input type="text" name="resource_name" id="resource_name"><br><br>
                    <label>Add Resource Scopes :</label>&nbsp<input type="text" name="scopes" id="scopes"><br><br>
                    <label>Add Resource type :</label>&nbsp<input type="text" name="type" id="type"><br><br>
                    <label>Add Resource icon uri :</label>&nbsp<input type="text" name="icon_uri" id="icon_uri"><br><br>
                    <label>Add Resource description :</label>&nbsp<input type="text" name="description" id="description"><br><br>
                    <hr>
                    <div class="wrapper">
                        <input type="submit" value="Register Resource" name="reg_reso" style="width: 400px"><br><br>
                        &lt;%&ndash; redirect page to the policy creation &ndash;%&gt;
                    </div>
                </form>--%>
            
            
            <%
                if (request.getAttribute("registerResource") != null) {
                    SaveResourceResponse saveResourceResponse = (SaveResourceResponse) request.getAttribute("registerResource");
            %>
            <h3>Register Resource</h3>
            <div>Resource Id: <%= saveResourceResponse.getResourceId()%>
            </div>
            
            <% } %>
            <%--  <div class="wrapper">
                  <a href="index.jsp"><input type="submit" value="Back" name=BackButton style="width: 400px"></a>
              </div>--%>

        </form>
    </div>
</div>
<%--
<hr>
<form action="" method="get">
    Get registerResource Id : <input type="text" name="reso_ID">
</form>
<hr>
--%>

<%--
<style>
    .container {
        background-color: lightsteelblue;
        font-family: "Noto Sans CJK JP Bold";
        margin-top: 10%;
        
    }
    
    .wrapper {
        text-align: center;
    }
    
    body {
        background-color: white;
    }
</style>
--%>

</body>
</html>
