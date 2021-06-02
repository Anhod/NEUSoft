<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/2
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/book/update" method="post">
    <table border="1" width="300">
        <tr>
            <td>书籍编号：</td>
            <td><input type="text" name="bid" value="${book.bid}"></td>
        </tr>
        <tr>
            <td>书籍名称：</td>
            <td><input type="text" name="bname" value="${book.bname}"></td>
        </tr>
        <tr>
            <td>作者：</td>
            <td><input type="text" name="author" value="${book.author}"></td>
        </tr>
        <tr>
            <td>出版社：</td>
            <td><input type="text" name="publish" value="${book.publish}"></td>
        </tr>
        <tr>
<%--            将date对象以这种方式呈现--%>
            <td>出版日期：</td>
            <td><input type="date" name="publishDate" value="<fmt:formatDate value='${book.publishDate}' pattern='yyyy-MM-dd'/>"></td>
        </tr>
        <tr>
            <td>页数：</td>
            <td><input type="text" name="page" value="${book.page}"></td>
        </tr>
        <tr>
            <td>价格：</td>
            <td><input type="text" name="price" value="${book.price}"></td>
        </tr>
        <tr>
            <td>摘要：</td>
            <td><input type="text" name="content" value="${book.content}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
