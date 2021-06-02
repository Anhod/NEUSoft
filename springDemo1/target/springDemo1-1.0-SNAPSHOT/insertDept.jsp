<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/5/31
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/InsertDeptServlet" method="post">
    <table border="1" width="300">
        <tr>
            <td>编号：</td>
            <td><input type="text" name="deptno" value="${dept.deptno}"></td>
            <td>名称：</td>
            <td><input type="text" name="dname" value="${dept.dname}"></td>
            <td>地址：</td>
            <td><input type="text" name="loc" value="${dept.loc}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
