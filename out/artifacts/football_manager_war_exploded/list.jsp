<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anh Tuan
  Date: 6/13/2018
  Time: 8:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/display?action=create">Create player</a>
</p>
<p>
<h1>TEAMS</h1>
<table border="1">
    <tr>
        <td>#</td>
        <td>Name</td>
        <td>Age</td>
        <td>Height</td>
        <td>Nationality</td>
        <td>Position</td>
        <td>Team</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items='${requestScope["x1"]}' var="view">
        <tr>
            <td><a href="/display?action=view&id=${view.getId()}">${view.getId()}</a></td>
            <td>${view.getName()}</td>
            <td>${view.getAge()}</td>
            <td>${view.getHeight()}</td>
            <td>${view.getNationality()}</td>
            <td>${view.getPostion()}</td>
            <td><a href="/display?action=edit&id=${view.getId()}">edit</a></td>
            <td><a href="/display?action=delete&id=${view.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</p>
</body>
</html>
