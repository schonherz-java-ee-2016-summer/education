<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Sample Web App</title>
        <link href='https://fonts.googleapis.com/css?family=Oswald:300,400,700' rel='stylesheet' type='text/css'>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="css/common.css">
    </head>
    <body>
        <%@include file="/html/header.html"%>
        <h3 class="flex-center">Welcome ${user}!</h3>
    </body>
</html>
