<%@ page import="org.servlet.model.ResourceModel.UpdateResourceResponse" %><%--
  Created by IntelliJ IDEA.
  User: isuri
  Date: 5/3/18
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8"/>
    
    <title>Update Resource Details</title>

</head>
<body>
<%@include file="Common/navbar.html"%>
<div class="container">
    <div id="register" class="animate form">
        <form  id="contact" action="/update" method="post">
            <h1><center> Update Resource Details</center></h1>
            <p>
                <%-- <label>Resource ID : </label> <input type="text" name="resource_id" id="resource_id">--%>
                <label for="resource_id" class="rid" >Resource Id :</label></p>
            <fieldset>
                <input id="resource_id" name="resource_id" required="required" type="text" size="40" />
            </fieldset>
            <p>
                <label for="resource_name" class="rname" >Resource Name :</label></p>
            <fieldset>
                <input id="resource_name" name="resource_name" required="required" type="text" size="40" />
            </fieldset>
    
            <p>
                <label for="scopes" class="uname" >Resource Scopes :</label></p>
            <fieldset>
                <input id="scopes" name="scopes" required="required" type="text" size="25" />
            </fieldset>
            <p>
                <label for="type" class="uname" >Type of the resource :</label> </p>
            <fieldset>
                <input id="type" name="type" required="required" type="text" size="25"/>
            </fieldset>
            <p>
                <label for="icon_uri" class="uname" >Icon URI of the resource :</label></p>
            <fieldset>
                <input id="icon_uri" name="icon_uri" required="required" type="text" size="25" />
            </fieldset>
    
            <p>
                <label for="description" class="uname" >Resource Description :</label></p>
            <fieldset>
                <input id="description" name="description" required="required" type="text" size="25" />
            </fieldset>
            
            <fieldset>
                <button name="submit" type="submit" id="contact-submit" value="Register resource" > update resource details</button>
            </fieldset>
            <fieldset>
                <button name = "reset "type="reset" value="Reset" id="contact-reset" value="clear Studio">Clear form</button>
            </fieldset>
     <%--   </form>
    </div>--%>
<%--<div class="container">
<h4>-----Enter registerResource details------</h4><hr>
<form action="/update" method="post">
    &lt;%&ndash; Enter registerResource details which should be added &ndash;%&gt;
    Enter Resource ID : <input type="text" name="resource_id"><br><br>
    Add Resource Name : <input type="text" name="resource_name" id="resource_name"><br><br>
    Add Resource Scopes : <input type="text" name="scopes" id="scopes"><br><br>
    Add Resource type : <input type="text" name="type" id="type"><br><br>
    Add Resource icon uri: <input type="text" name="icon_uri" id="icon_uri"><br><br>
    Add Resource description : <input type="text" name="description" id="description"><br><br>
        <hr>
        <div class="wrapper">
    <input type="submit" value="Register Resource" name="reg_reso" style="width: 400px"><br>
    &lt;%&ndash; redirect page to the policy creation &ndash;%&gt;
        </div>
</form>
<div>--%>
    
        <%
            if (request.getAttribute("updatedResource") != null) {
                UpdateResourceResponse resource = (UpdateResourceResponse) request.getAttribute("updatedResource");%>

            <%=resource.getResourceId()+" Updated"%>
        <%}%>
    <%--<div class="wrapper">
    <a href="index.jsp"><input type="submit" value="Back" name=BackButton style="width: 400px"></a>
    </div>--%>
</form>
</div>
</div>
</body>
</html>
