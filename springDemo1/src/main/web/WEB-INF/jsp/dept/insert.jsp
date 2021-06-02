<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/1
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--空串空数组都可以判断是否为空--%>
<c:if test="${ !(empty errorList)}">
    <c:forEach items="${errorList}" var="error">
        ${error.defaultMessage}<br>
    </c:forEach>
</c:if>

<form action="${pageContext.request.contextPath}/dept/insert" method="post">
    <table border="1" width="300">
        <tr>
            <td>编号：</td>
            <td><input type="text" name="deptno" value="${param.deptno}"></td>
            <td>名称：</td>
            <td><input type="text" name="dname" value="${param.dname}"></td>
            <td>地址：</td>
            <td><input type="text" name="loc" value="${param.loc}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
