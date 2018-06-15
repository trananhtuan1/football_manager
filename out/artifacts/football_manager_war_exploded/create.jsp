<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anh Tuan
  Date: 6/13/2018
  Time: 8:52 AM
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
    <a href="/display">Back</a>
</p>
<p>
<h1>Create new player</h1>
</p>
<form method="post">
    <p>
    <fieldset>
        <legend>Post Information</legend>
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="text" name="age" id="age"></td>
            </tr>
            <tr>
                <td>Height</td>
                <td><input type="text" name="height" id="height"></td>
            </tr>
            <tr>
                <td>Nationality</td>
                <td>
                    <select name="nationality" id="nationality">
                        <option value="KOREA">KOREA</option>
                        <option value="USA">USA</option>
                        <option value="Ha Noi">Ha Noi</option>
                        <option value="Viet Nam" selected>Viet Nam</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Position</td>
                <td>
                    <select name="postion" id="postion">
                        <option value="tien dao">tien dao</option>
                        <option value="tien ve">tien ve</option>
                        <option value="thu mon">thu mon</option>
                        <option value="hau ve" selected>hau ve</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Team</td>
                <td>
                    <select name="teamId" id="teamId">
                        <c:forEach var="teamName" items='${requestScope["teams"]}'>
                            <option value="${teamName.getId()}">
                                    ${teamName.getName()}
                            </option>
                        </c:forEach>

                        <%--<option value="Argentina" ${requestScope["view"].getNationality() == "Argentina"?"selected":""}>--%>
                        <%--Argentina--%>
                        <%--</option>--%>
                        <%--<option value="Korea" ${requestScope["view"].getNationality() == "Korea"?"selected":""}>Korea--%>
                        <%--</option>--%>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Create player"></td>
            </tr>
        </table>
    </fieldset>
    </p>
</form>
</body>
</html>
