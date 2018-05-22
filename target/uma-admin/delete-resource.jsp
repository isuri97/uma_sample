<%--
  Created by IntelliJ IDEA.
  User: isuri
  Date: 5/3/18
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8"/>
    
    <title>Delete Resource details</title>

</head>
<body>
<%@include file="Common/navbar.html" %>
<div class="container">
    <div id="register" class="animate form">
        <form id="contact" action="/delete" method="post">
            <h1>
                <center> Delete Resource Details</center>
            </h1>
            <p>
                <%-- <label>Resource ID : </label> <input type="text" name="resource_id" id="resource_id">--%>
                <label for="resource_id" class="rid">Resource Id :</label></p>
            <fieldset>
                <input id="resource_id" name="resource_id" required="required" type="text" size="40"/>
            </fieldset>
            <fieldset>
                <button name="submit" type="submit" id="contact-submit" value="Register resource"> Delete resource
                    Details
                </button>
            </fieldset>
            <fieldset>
                <button name="reset " type="reset" value="Reset" id="contact-reset" value="clear Studio">Clear form
                </button>
            </fieldset>
            
            
            <%--<body>
            <div class="container">
            <h2>-------Delete Resource---------</h2><hr>
            <form id="form-dresource" action="/delete" method="post">
            Add registerResource Id : <input type="text" name="resource_id" id="resource_id"><br><br>
                <hr>
                <div class="wrapper">
            <input type="submit" name="del_reso" value="Delete Resource" style="width: 400px">
                </div>
            </form>--%>
            <%
                if (request.getAttribute("delete") != null) {
                    String delete = (String) request.getAttribute("delete");
            %>
            
            
            <h1>Resource</h1>
            <p><%=delete%>
            </p>
            <% } %>
            <%--   <div class="wrapper">
               <a href="index.jsp"><input type="submit" value="Back" name=BackButton style="width: 400px"></a>
           </div>--%>
        </form>
    </div>
</div>
</body>
</html>
