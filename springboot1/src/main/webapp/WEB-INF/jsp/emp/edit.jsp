<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/3
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/emp/update" method="post">
    <table width="350" border="1">
<%--        隐藏域--%>
        <input type="hidden" name="empno" value="${emp.empno}">
<%--        <tr>--%>
<%--            <td>员工编号：</td>--%>
<%--            <td><input type="text" value="${emp.empno}" disabled></td>--%>
<%--        </tr>--%>

        <tr>
            <td>员工姓名：</td>
            <td><input type="text" value="${emp.ename}" name="ename"></td>
        </tr>

        <tr>
            <td>员工岗位:</td>
            <td><input type="text" value="${emp.job}" name="job"></td>
        </tr>

        <tr>
            <td>入职日期：</td>
            <td><input type="date" name="hiredate" value='<fmt:formatDate value="${ emp.hiredate }" pattern="yyyy-MM-dd"/>'></td>

        </tr>

        <tr>
            <td>员工经理</td>
            <td><input type="text" name="mgr" value="${emp.mgr}"></td>
        </tr>

        <tr>
            <td>员工薪水：</td>
            <td><input type="text" name="sal" value="${emp.sal}"></td>
        </tr>

        <tr>
            <td>员工奖金：</td>
            <td><input type="text" name="comm" value="${emp.comm}"></td>
        </tr>

        <tr>
            <td>员工部门：</td>
            <td>
                <select name="dept.deptno">
                    <c:forEach items="${depts}" var="dept">
                        <option ${dept.deptno == emp.dept.deptno ?"selected":""}
                                value="${dept.deptno}"> ${ dept.dname }</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
