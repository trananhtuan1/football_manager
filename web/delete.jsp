<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anh Tuan
  Date: 6/13/2018
  Time: 10:17 AM
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
    <c:if test='${requestScope["message"]!=null}'>
        <span class="test">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
<h1>Deleting Team ${requestScope["delete"].getName()}</h1>
<h3>Are you sure?</h3>
</p>
<form method="post">
    <%--<fieldset>--%>
        <%--<legend>delete</legend>--%>
        <%--<table>--%>
            <%--<tr>--%>
                <%--<td>Name</td>--%>
                <%--<td>${requestScope["delete"].getName()}</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>Age</td>--%>
                <%--<td>${requestScope["delete"].getAge()}</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>Height</td>--%>
                <%--<td>${requestScope["delete"].getHeight()}</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>Nationality</td>--%>
                <%--<td>${requestScope["delete"].getNationality()}</td>--%>
            <%--</tr>--%>
            <tr>
                <td><input type="submit" value="delete"></td>
            </tr>
        <%--</table>--%>
    <%--</fieldset>--%>
</form>
</body>
</html>
