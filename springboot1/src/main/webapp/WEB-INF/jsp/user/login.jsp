<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/4
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}user/login">
    用户名：<input type="text" name="userName"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="提交">
</form>


</body>
</html>
