<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/3
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>

    <style>
        .table2_2 table {
            width: 100%;
            margin: 15px 0
        }

        .table2_2 thead {
            background-color: #C8D7FF;
            color: #000000;

        }

        .table2_2, .table2_2 thead, .table2_2 td {
            font-size: 0.95em;
            text-align: center;
            padding: 4px;
            border: 1px solid #dfe8fe;
            border-collapse: collapse
        }

        .table2_2 tr:nth-child(odd) {
            background-color: #ecf1fe;
        }

        .table2_2 tr:nth-child(even) {
            background-color: #fdfdfd;
        }
    </style>
</head>
<body>
<table width="1000" border="1" class="table2_2">
    <thead>
    <td>员工编号</td>
    <td>员工姓名</td>
    <td>岗位</td>
    <td>入职日期</td>
    <td>经理</td>
    <td>薪水</td>
    <td>奖金</td>
    <td>部门名称</td>
    <td>操作</td>
    </thead>
    <tbody>
    <c:forEach items="${emps}" var="emp">
        <tr>
            <td>${emp.empno}</td>
            <td>${emp.ename}</td>
            <td>${emp.job}</td>
            <td><fmt:formatDate value="${ emp.hiredate }" pattern="yyyy-MM-dd"/></td>
            <td>${emp.mgr}</td>
            <td>${emp.sal}</td>
            <td>${emp.comm}</td>
            <td>${emp.dept.dname}</td>

            <td>
                <a href="${pageContext.request.contextPath}/emp/edit?empno=${emp.empno}">编辑</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
