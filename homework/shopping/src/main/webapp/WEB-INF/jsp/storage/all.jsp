<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/4
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<html>
<head>
    <title>查看全部商品信息</title>

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
<table border="1" width="1000" class="table2_2">
    <thead>
    <tr>
        <td>商品id</td>
        <td>商品名称</td>
        <td>入库日期</td>
        <td>生产日期</td>
        <td>库存数量</td>
        <td>所在仓库</td>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${pageInfo.list}" var="storage">
        <tr>
            <td>${storage.gid}</td>
            <td>${storage.gname}</td>
            <td><fmt:formatDate value="${ storage.gin_date }" pattern="yyyy-MM-dd"/>
            </td>
            <td><fmt:formatDate value="${ storage.gpro_date }" pattern="yyyy-MM-dd"/>
            </td>
            <td>${storage.g_count==0?'库存不足':storage.g_count}</td>
            <td>${storage.storage_name}</td>
        </tr>
    </c:forEach>
    </tbody>

    <%--        分页--%>
    <tfoot>
    <td colspan="7">
        <c:if test="${! pageInfo.isFirstPage}">
            <a href="${pageContext.request.contextPath}/storage/all?pageNum=1&pageSize=${pageInfo.pageSize}">首页</a>
            <a href="${pageContext.request.contextPath}/storage/all?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}">上一页</a>
        </c:if>

        <c:if test="${! pageInfo.isLastPage}">
            <a href="${pageContext.request.contextPath}/storage/all?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}">下一页</a>
            <a href="${pageContext.request.contextPath}v?pageNum=${pageInfo.navigateLastPage}&pageSize=${pageInfo.pageSize}">末页</a>
        </c:if>
        <a href="${pageContext.request.contextPath}/storage/first">返回出库页</a>
    </td>
    </tfoot>
</table>
</body>
</html>
