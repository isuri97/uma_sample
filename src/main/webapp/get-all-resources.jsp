<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: isuri
  Date: 5/3/18
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
              crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="Common/style.css">
        <meta charset="UTF-8"/>
        
        <title>Get All Resource details</title>
    
    </head>
<body>

<div class="container">
    <div id="register" class="animate form">
        <form id="contact" action="/get-resource" method="post">
            <h1>
                <center> Get All Resource Ids</center>
            </h1>
            
            <fieldset>
                <button name="submit" type="submit" id="contact-submit" value="Register resource"> Get resource Ids
                </button>
            </fieldset>
            
            
            &lt;%&ndash;<form id="form-registerResource" action="/all-resources" method="post"><br><hr>
                <input type="submit" value="Submit" style="width: 400px">
            </form>&ndash;%&gt;
            <h5>Resource Ids</h5>
            <ul>
                <%
                    if (request.getAttribute("resources") != null) {
                        List<String> resources = (List<String>) request.getAttribute("resources");
                        for (String s : resources) {
                %>
                <li><%=s%>
                </li>
                <%
                        }
                    }
                %>
            </ul>
        </form>
    </div>

</div>
</body>
</html>--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
              crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta charset="UTF-8"/>
        
        <title>Get All Resource details</title>
    
    </head>
<body>
<%@include file="Common/navbar.html" %>



<div class="container">
    <div id="register" class="animate form">
        <form id="contact" action="/all-resources" method="post">
            <h1>
                <center> Get All Resource Ids</center>
            </h1>
            
            <fieldset>
                <button name="submit" type="submit" id="contact-submit" value="Get all resource"> Get resource Ids
                </button>
            </fieldset>
            
    <h5>Resource Ids</h5>
    <ul>
        <%if (request.getAttribute("resources") != null){
            List<String> resources = (List<String>) request.getAttribute("resources");
            for (String s:resources) {%>
        <li><%=s%></li>
        <%}}%>
    </ul>
        </form>
        </div>
    </div>

</body>
</html>