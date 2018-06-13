<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anh Tuan
  Date: 6/13/2018
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <c:if test='${requestScope["message"]!=null}'>
        <span class="test">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/display">back</a>
</p>
<form method="post">
    <p>
    <fieldset>
        <legend>Edit</legend>
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name" value="${requestScope["edit"].getName()}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="edit"></td>
            </tr>
        </table>
    </fieldset>
    </p>
</form>
</body>
</html>
