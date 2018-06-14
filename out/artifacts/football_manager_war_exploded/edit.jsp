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
<p>
<h1>Edit player</h1>
</p>
<form method="post">
    <p>
    <fieldset>
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name" value="${requestScope["edit"].getName()}"></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="text" name="age" id="age" value="${requestScope["edit"].getAge()}"></td>
            </tr>
            <tr>
                <td>Height</td>
                <td><input type="text" name="height" id="height" value="${requestScope["edit"].getHeight()}"></td>
            </tr>
            <tr>
                <td>Nationality</td>
                <td>
                    <select name="nationality" id="nationality">
                        <option value="KOREA" ${requestScope["edit"].getNationality() == "KOREA"?"selected":""}>KOREA
                        </option>
                        <option value="USA" ${requestScope["edit"].getNationality() == "USA"?"selected":""}>USA</option>
                        <option value="Ha Noi" ${requestScope["edit"].getNationality() == "Ha Noi"?"selected":""}>Ha
                            Noi
                        </option>
                        <option value="Viet Nam" ${requestScope["edit"].getNationality() == "Viet Nam"?"selected":""}>
                            Viet Nam
                        </option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Position</td>
                <td>
                    <select name="postion" id="postion">
                        <option value="tien dao" ${requestScope["edit"].getPostion() == "tien dao"?"selected":""}>tien
                            dao
                        </option>
                        <option value="tien ve" ${requestScope["edit"].getPostion() == "tien ve"?"selected":""}>tien ve
                        </option>
                        <option value="thu mon" ${requestScope["edit"].getPostion() == "thu mon"?"selected":""}>thu mon
                        </option>
                        <option value="hau ve" ${requestScope["edit"].getPostion() == "hau ve"?"selected":""}>hau ve
                        </option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Update player"></td>
            </tr>
        </table>
    </fieldset>
    </p>
</form>
</body>
</html>
