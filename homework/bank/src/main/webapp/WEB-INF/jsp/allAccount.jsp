<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/1
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/account/batchDelete" method="post">
    <input type="submit" value="批量删除">

    <table border="1" width="500">
        <thead>
        <tr>
            <td>&nbsp;&nbsp;</td>
            <td>用户id</td>
            <td>用户名</td>
            <td>账户余额</td>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${accounts}" var="account">
            <tr>
                <td>
                        <%--复选框--%>
                    <input type="checkbox" name="accounts" value="${account.userId}">
                </td>
                <td>${account.userId}</td>
                <td>${account.userName}</td>
                <td>${account.balance}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>

