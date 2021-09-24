<%@ page import="com.company.springDBApp.entities.*" %><%--
  Created by IntelliJ IDEA.
  User: elnur
  Date: 8/1/2021
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>user detail</title>
</head>
<body>

    <div>
        <form action="userDetail" method="post">
            <label for="name">name:</label>
            <input type="hidden" name="id" value="${user.id}">
            <input type="text" name="name" value="${user.name}">
            <br/>
            <label for="surname">surname:</label>
            <input type="text" name="surname" value="${user.surname}">
            <input type="submit" name="save" value="save">
        </form>
    </div>

</body>
</html>
