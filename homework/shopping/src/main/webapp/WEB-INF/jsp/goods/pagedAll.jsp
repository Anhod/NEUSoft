<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2021/6/3
  Time: 15:47
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
        <td>价格</td>
        <td>生产地</td>
        <td>出厂日期</td>
        <td>商品描述</td>
        <td>操作</td>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${pageInfo.list}" var="good">
        <tr>
            <td>${good.gid}</td>
            <td>${good.gname}</td>
            <td>${good.price}</td>
            <td>${good.company}</td>
            <td>${good.leave_date}</td>
            <td>${good.desc}</td>

            <td>
                <a href="${ pageContext.request.contextPath }/goods/buy?gid=${ good.gid}">点击购买</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

    <%--        分页--%>
    <tfoot>
    <td colspan="7">
        <c:if test="${! pageInfo.isFirstPage}">
            <a href="${pageContext.request.contextPath}/goods/getPaged?pageNum=1&pageSize=${pageInfo.pageSize}">首页</a>
            <a href="${pageContext.request.contextPath}/goods/getPaged?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}">上一页</a>
        </c:if>

        <c:if test="${! pageInfo.isLastPage}">
            <a href="${pageContext.request.contextPath}/goods/getPaged?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}">下一页</a>
            <a href="${pageContext.request.contextPath}/goods/getPaged?pageNum=${pageInfo.navigateLastPage}&pageSize=${pageInfo.pageSize}">末页</a>
        </c:if>
    </td>
    </tfoot>
</table>
<script type="text/javascript">

</script>
</body>
</html>
