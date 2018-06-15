<%--
  Created by IntelliJ IDEA.
  User: Anh Tuan
  Date: 6/15/2018
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/teams">Back</a>
</p>
<p>
<h1>View Team</h1>
</p>
<h2>
    <p>
        <tr>
            <td>${requestScope["view"].getName()}</td>
        </tr>
    </p>
</h2>
</body>
</html>
