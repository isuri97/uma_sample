<%--
  Created by IntelliJ IDEA.
  User: isuri
  Date: 5/16/18
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8"/>
    
    <title>Admin Panel</title>
</head>
<body>
<%@include file="Common/navbar.html"%>
<div class="container">
    <div id="admin" class="animate form">
        <form id="contact">
            <h1>
                <center> Admin Panel</center>
            </h1>
            <p>
                <%-- <label>Resource ID : </label> <input type="text" name="resource_id" id="resource_id">--%>
            <ul>
                <li><a href="register-resource.jsp"> <label>Register the resource.</label></a></li>
                <li><a href="delete-resource.jsp"> <label>Delete the resource details.</label></a></li>
                <li><a href="get-resource.jsp"> <label>Get the resource details.</label></a></li>
                <li><a href="update-resource.jsp"> <label>Update the resource details.</label></a></li>
                <li><a href="get-all-resources.jsp"> <label>Get all resource details.</label></a></li>
            </ul>
        </form>
    </div>
</div>
</body>
</html>
