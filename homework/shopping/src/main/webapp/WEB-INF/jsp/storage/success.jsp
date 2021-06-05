<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/4
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>${storage.gid}商品《${storage.gname}》成功出库</h1>
<br>
<br>
点击<a href="${pageContext.request.contextPath}/storage/all">返回</a>查看商品库存信息
</body>
</html>
