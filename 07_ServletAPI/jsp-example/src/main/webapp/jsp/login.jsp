<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Sample Web App - Login</title>
        <link href='https://fonts.googleapis.com/css?family=Oswald:300,400,700' rel='stylesheet' type='text/css'>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" type="text/css" href="css/forms.css">
    </head>
    <body>
        <%@include file="/html/header.html"%>
        <form class="form" method="POST" action="/login">
            <div id="login-header" class="flex-center">
                <span class="material-icons">person</span>
                <span>Please log in to the system, yo.</span>
            </div>
            <div class="form-element">
                <label for="user-name-input">User Name:</label>
                <input id="user-name-input" name="username" type="text">
            </div>

            <div class="form-element">
                <label for="password-input">Password:</label>
                <input id="password-input" name="password" type="text">
            </div>

            <div class="form-element">
                <button class="btn" type="submit">Log in!</button>
            </div>
        </form>
    </body>
</html>
