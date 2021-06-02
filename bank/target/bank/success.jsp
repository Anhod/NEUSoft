<%@ page import="com.neu.po.Account" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/5/31
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Account account =(Account) request.getAttribute("account");%>
<table border="1" width="500">
    <thead>
    <tr>
        <td>用户id</td>
        <td>用户名称</td>
        <td>余额</td>
    </tr>
    </thead>

    <tbody>
        <tr>
            <td><%=account.getUserId()%></td>
            <td><%=account.getUserName()%></td>
            <td><%=account.getBalance()%></td>
        </tr>
    </tbody>
</table>
</body>
</html>
