<%--
  Created by IntelliJ IDEA.
  User: Anh Tuan
  Date: 6/15/2018
  Time: 8:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <p>
    <h1>Delete Team ${requestScope["delete"].getName()}</h1>
    <h3>Are You Sure?</h3>
    </p>
    <p>
        <input type="submit" value="delete team">
    </p>
</form>
</body>
</html>
