<%--
<html>
&lt;%&ndash;<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">&ndash;%&gt;
<link rel="stylesheet" href="css/bootstrap.css">
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="/get-resource.jsp">Get resource</a></li>
            <li><a href="/get-all-resources.jsp">Get All Resources</a></li>
            <li><a href="/delete-resource.jsp">Delete Resources</a></li>
            <li><a href="/register-resource.jsp">Register Resources</a></li>
            <li><a href="/update-resource.jsp">Update Resources</a></li>
            <li><a href="/grant/client-token.jsp">Token</a></li>
            <li><a href="request-permission.jsp">permission</a></li>
        </ul>
    </div>
</nav>
</body>
</html>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>User Managed Access 2.0</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <style>
        a:link, a:visited {
            background-color: #000;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }
        
        a:hover, a:active {
            background-color: #ff640a;
        }
    </style>

</head>
<body>

<div class="container">
    <br>
    <center>
        <h1>User Managed Access 2.0</h1>
        <br>
        <div class="well well-lg">
            <h2>Welcome to UMA 2.0 sample app. Click below links to test out the flows.</h2>
            <br>
            <h4>Resource Server - Authorization Server (Protection API)</h4>
            <a href="admin_console.jsp" >Resource Registration Endpoint</a>
            <br>
            <br>
            <a href="request-permission.jsp" >Permission Endpoint</a>
            <br><br>
            <h4>Client - Authorization Server (UMA grant)</h4>
            <a href="grant/client-token.jsp">Access token (RPT) request</a>
        </div>
    </center>
</div>

</body>
</html>
