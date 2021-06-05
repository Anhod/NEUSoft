<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/3
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/emp/dealUpload" method="post" enctype="multipart/form-data">
        文件名：<input type="file" name="files"><br>
        文件名：<input type="file" name="files"><br>
        文件名：<input type="file" name="files"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
