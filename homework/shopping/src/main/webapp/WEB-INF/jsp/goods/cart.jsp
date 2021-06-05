<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/3
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <style>
        .table2_2 table {
            width: 100%;
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
<center>
<table border="1" width="500px" class="table2_2">
    <h2>购物车</h2>
<thead>
<tr>
    <td>商品id</td>
    <td>商品名称</td>
    <td>单价</td>
    <td>数量</td>
    <td>小计</td>
</tr>
</thead>

<tbody>
<c:forEach items="${carts}" var="cart">
    <tr>
        <td>${cart.bid}</td>
        <td>${cart.bname}</td>
        <td>${cart.price}</td>
        <td>${cart.count}</td>
        <td>${cart.price*cart.count}</td>
    </tr>
</c:forEach>
</tbody>

    <tfoot>
    <td colspan="5">
        <a href="${ pageContext.request.contextPath }/goods/getPaged">返回</a>
        <a href="${ pageContext.request.contextPath }/goods/submit">购买</a>
    </td>
    </tfoot>
</table>
</center>
</body>
</html>
