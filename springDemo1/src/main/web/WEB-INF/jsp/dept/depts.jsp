<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/1
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户名：${userName}
<br>
<a href="${ pageContext.request.contextPath }/dept/getInsertPage">添加部门</a>
<br>

<form action="${pageContext.request.contextPath}/dept/batchDelete" method="post">
    <input type="submit" value="批量删除">

    <table border="1" width="500">
        <thead>
        <tr>
            <td>&nbsp;</td>
            <td>部门编号</td>
            <td>部门名称</td>
            <td>部门位置</td>
            <td>操作</td>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${depts}" var="dept">
            <tr>
                <td>
                        <%--复选框--%>
                    <input type="checkbox" name="deptno" value="${dept.deptno}">
                </td>
                <td>${dept.deptno}</td>
                <td>${dept.dname}</td>
                <td>${dept.loc}</td>
                <td>
                    <a href="${ pageContext.request.contextPath }/dept/delete?deptno=${ dept.deptno }">删除</a>
                    <a href="${ pageContext.request.contextPath }/dept/edit?deptno=${ dept.deptno }">编辑</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>

