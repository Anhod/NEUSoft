<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/2
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--空串空数组都可以判断是否为空--%>
<c:if test="${ !(empty errorList)}">
    <c:forEach items="${errorList}" var="error">
        ${error.defaultMessage}<br>
    </c:forEach>
</c:if>


<form action="${pageContext.request.contextPath}/book/insert" method="post">
    <table border="1" width="300">
        <tr>
            <td>书籍编号：</td>
            <td><input type="text" name="bid" value="${param.bid}"></td>
        </tr>
        <tr>
            <td>书籍名称：</td>
            <td><input type="text" name="bname" value="${param.bname}"></td>
        </tr>
        <tr>
            <td>作者：</td>
            <td><input type="text" name="author" value="${param.author}"></td>
        </tr>
        <tr>
            <td>出版社：</td>
            <td><input type="text" name="publish" value="${param.publish}"></td>
        </tr>
        <tr>
            <td>出版日期：</td>
            <td><input type="date" name="publishDate" value="${param.publishDate}"></td>
        </tr>
        <tr>
            <td>页数：</td>
            <td><input type="text" name="page" value="${param.page}"></td>
        </tr>
        <tr>
            <td>价格：</td>
            <td><input type="text" name="price" value="${param.price}"></td>
        </tr>
        <tr>
            <td>摘要：</td>
            <td><input type="text" name="content" value="${param.content}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
