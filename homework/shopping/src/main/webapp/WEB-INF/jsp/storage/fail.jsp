<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/4
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<h1>出错啦：货物库存数量不足</h1>
<table border="1" width="300">
    <tbody>
    <tr>
        <td>上皮编号：</td>
        <td><input type="text" name="deptno" value="${storage.gid}"></td>
    </tr>
    <tr>
        <td>商品名称：</td>
        <td><input type="text" name="dname" value="${storage.gname}"></td>
    </tr>
    <tr>
        <td>入库日期：</td>
        <td><input type="text" name="loc" value="<fmt:formatDate value="${ storage.gin_date }" pattern="yyyy-MM-dd"/>"></td>
    </tr>
    <tr>
        <td>生产日期：</td>
        <td><input type="text" name="loc" value="<fmt:formatDate value="${ storage.gpro_date }" pattern="yyyy-MM-dd"/>"></td>
    </tr>
    <tr>
        <td>库存数量：</td>
        <td><input type="text" name="loc" value="${storage.g_count}"></td>
    </tr>
    <tr>
        <td>仓库名称：</td>
        <td><input type="text" name="loc" value="${storage.storage_name}"></td>
    </tr>
    </tbody>

    <tfoot>

        点击<a href="${pageContext.request.contextPath}/storage/all">返回</a>查看商品库存信息

    </tfoot>
</table>
</body>
</html>
