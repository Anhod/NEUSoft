<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/5/31
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" width="500">
        <thead>
            <tr>
                <td>部门编号</td>
                <td>部门名称</td>
                <td>部门位置</td>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${depts}" var="dept">
                <tr>
                    <td>${dept.deptno}</td>
                    <td>${dept.dname}</td>
                    <td>${dept.loc}</td>
                    <td>
                        <a href="${ pageContext.request.contextPath }/DeleteDeptServlet?deptno=${ dept.deptno }">删除</a>
                        <a href="${ pageContext.request.contextPath }/EditDeptServlet?deptno=${ dept.deptno }">编辑</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
