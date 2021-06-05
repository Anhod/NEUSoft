<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/4
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="${pageContext.request.contextPath}/storage/submit?count=${count}" method="post">
        <h1>商品出库</h1>

        请选择您要出库的商品：
        <select name="gid">
            <c:forEach items="${list}" var="storage">
                <option value="${storage.gid}">${storage.gname}</option>
            </c:forEach>
        </select>

        <br><br><br>

        请输入要输出的数量：<input name="count">


        <input type="submit" value="提交">
        <input type="submit" value="取消">
        <br>
        <br>

        <a href="${pageContext.request.contextPath}/storage/all">查看全部商品信息</a>
    </form>
</center>
</body>
</html>
