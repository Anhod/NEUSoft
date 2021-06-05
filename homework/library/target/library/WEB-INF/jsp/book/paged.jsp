<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>

    <style>
        .table2_2 table {
            width:100%;
            margin:15px 0
        }
        .table2_2 thead {
            background-color:#C8D7FF;
            color:#000000
        }
        .table2_2,.table2_2 thead,.table2_2 td
        {
            font-size:0.95em;
            text-align:center;
            padding:4px;
            border:1px solid #dfe8fe;
            border-collapse:collapse
        }
        .table2_2 tr:nth-child(odd){
            background-color:#ecf1fe;
        }
        .table2_2 tr:nth-child(even){
            background-color:#fdfdfd;
        }
    </style>

</head>
<body>
<br>
<a href="${ pageContext.request.contextPath }/book/getInsertPage">添加书籍</a>
<br>

<form action="${pageContext.request.contextPath}/book/batchDelete" method="post">
    <br>
    <table border="1" width="1000" cellspacing="0" class=table2_2>
        <thead>
        <tr>
            <td>&nbsp;</td>
            <td>书籍编号</td>
            <td>书籍名称</td>
            <td>作者</td>
            <td>出版社</td>
            <td>出版时间</td>
            <td>页数</td>
            <td>价格</td>
            <td>摘要</td>
            <td>操作</td>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${pageInfo.list}" var="book">
            <tr>
                <td>
                        <%--复选框--%>
                    <input type="checkbox" name="bid" value="${book.bid}">
                </td>
                <td>${book.bid}</td>
                <td>${book.bname}</td>
                <td>${book.author}</td>
                <td>${book.publish}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${book.publishDate}" /></td>
<%--                <td>${book.publishDate}</td>--%>
                <td>${book.page}</td>
                <td>${book.price}</td>
                <td>${book.content}</td>

                <td>
                    <a href="${ pageContext.request.contextPath }/book/delete?bid=${ book.bid }">删除</a>
                    <a href="${ pageContext.request.contextPath }/book/edit?bid=${ book.bid }">编辑</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

        <%--        分页--%>
        <tfoot>
        <td colspan="10">
            共${pageInfo.total}条记录
            第${pageInfo.pageNum}页/共${pageInfo.pages}页

            <c:if test="${! pageInfo.isFirstPage}">
                <a href="${pageContext.request.contextPath}/book/getPaged?pageNum=1&pageSize=${pageInfo.pageSize}">第一页</a>
                <a href="${pageContext.request.contextPath}/book/getPaged?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}">上一页</a>
            </c:if>


            <c:forEach items="${pageInfo.navigatepageNums}" var="numbers">
                <c:if test="${numbers == pageInfo.pageNum}">
                    <a>[${numbers}]</a>
                </c:if>
                <c:if test="${numbers != pageInfo.pageNum}">
                    <a href="${pageContext.request.contextPath}/book/getPaged?pageNum=${numbers}&pageSize=${pageInfo.pageSize}">[${numbers}]</a>
                </c:if>
            </c:forEach>

            <c:if test="${! pageInfo.isLastPage}">
                <a href="${pageContext.request.contextPath}/book/getPaged?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}">下一页</a>
                <a href="${pageContext.request.contextPath}/book/getPaged?pageNum=${pageInfo.navigateLastPage}&pageSize=${pageInfo.pageSize}">最后一页</a>
            </c:if>

            跳转到 <input type="text" style="width: 25px;" id="goPageNum">页
            <input type="button" value="go" onclick="goPage()">

            <select onchange="changePageSize()" id="currPageSize">
                <option ${pageInfo.pageSize == 3 ? "selected":""}>3</option>
                <option ${pageInfo.pageSize == 4 ? "selected":""}>4</option>
                <option ${pageInfo.pageSize == 5 ? "selected":""}>5</option>
            </select>
        </td>
        </tfoot>
    </table>
</form>

<script type="text/javascript">
    function goPage() {
        var  goPageNum = document.getElementById("goPageNum").value;
        location.href = "${pageContext.request.contextPath}/book/getPaged?pageNum="+goPageNum;
    }

    function changePageSize() {
        var currPageSize = document.getElementById("currPageSize").value;
        location.href = "${pageContext.request.contextPath}/book/getPaged?pageNum=1&pageSize="+currPageSize;

    }
</script>

</body>
</html>

