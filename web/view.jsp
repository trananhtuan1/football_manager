<%--
  Created by IntelliJ IDEA.
  User: Anh Tuan
  Date: 6/13/2018
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/display">Back</a>
</p>
<p>
<fieldset>
    <legend>Detail Name</legend>
    <table>
        <tr>
            <td>Name</td>
            <td>${requestScope["view"].getName()}</td>
        </tr>
        <tr>
            <td>Age</td>
            <td>${requestScope["view"].getAge()}</td>
        </tr>
        <tr>
            <td>Height</td>
            <td>${requestScope["view"].getHeight()}</td>
        </tr>
        <tr>
            <td>Nationality</td>
            <td>${requestScope["view"].getNationality()}</td>
        </tr>
        <tr>
            <td>Postion</td>
            <td>${requestScope["view"].getPostion()}</td>
        </tr>
    </table>
</fieldset>
</p>
</body>
</html>
