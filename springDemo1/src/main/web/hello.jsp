<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/1
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="${ pageContext.request.contextPath }/hello" method="get">
    <input type="date" name="date">
    <input type="submit" value="提交">
</form>
</body>
</html>
