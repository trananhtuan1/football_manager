<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anh Tuan
  Date: 6/14/2018
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/teams?action=create">Create Team</a>
</p>
<p>
<table border="1">
    <tr>
        <td>#</td>
        <td>Name</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["x1"]}' var="view">
        <tr>
            <td><a href="/teams?action=id&view=${view.getId()}">${view.getId()}</a></td>
            <td>${view.getName()}</td>
            <td><a href="/teams?action=id&edit=${view.getId()}">Edit</a></td>
            <td><a href="/teams?action=id&delete=${view.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</p>
</body>
</html>
