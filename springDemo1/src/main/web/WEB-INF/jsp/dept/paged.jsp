<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/dept/batchDelete" method="post">
    <input type="submit" value="批量删除">

    <table border="1" width="700">
        <thead>
        <tr>
            <td>&nbsp;</td>
            <td>部门编号</td>
            <td>部门名称</td>
            <td>部门位置</td>
            <td>操作</td>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${pageInfo.list}" var="dept">
            <tr>
                <td>
                        <%--复选框--%>
                    <input type="checkbox" name="deptno" value="${dept.deptno}">
                </td>
                <td>${dept.deptno}</td>
                <td>${dept.dname}</td>
                <td>${dept.loc}</td>
                <td>
                    <a href="${ pageContext.request.contextPath }/dept/delete?deptno=${ dept.deptno }">删除</a>
                    <a href="${ pageContext.request.contextPath }/dept/edit?deptno=${ dept.deptno }">编辑</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

<%--        分页--%>
        <tfoot>
            <td colspan="5">
                共${pageInfo.total}条记录
                第${pageInfo.pageNum}页/共${pageInfo.pages}页

                <c:if test="${! pageInfo.isFirstPage}">
                    <a href="${pageContext.request.contextPath}/dept/getPaged?pageNum=1&pageSize=${pageInfo.pageSize}">第一页</a>
                    <a href="${pageContext.request.contextPath}/dept/getPaged?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}">上一页</a>
                </c:if>


                <c:forEach items="${pageInfo.navigatepageNums}" var="numbers">
                    <c:if test="${numbers == pageInfo.pageNum}">
                        <a>[${numbers}]</a>
                    </c:if>
                    <c:if test="${numbers != pageInfo.pageNum}">
                        <a href="${pageContext.request.contextPath}/dept/getPaged?pageNum=${numbers}&pageSize=${pageInfo.pageSize}">[${numbers}]</a>
                    </c:if>
                </c:forEach>

                <c:if test="${! pageInfo.isLastPage}">
                    <a href="${pageContext.request.contextPath}/dept/getPaged?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}">下一页</a>
                    <a href="${pageContext.request.contextPath}/dept/getPaged?pageNum=${pageInfo.navigateLastPage}&pageSize=${pageInfo.pageSize}">最后一页</a>
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
        location.href = "${pageContext.request.contextPath}/dept/getPaged?pageNum="+goPageNum;
    }

    function changePageSize() {
        var currPageSize = document.getElementById("currPageSize").value;
        location.href = "${pageContext.request.contextPath}/dept/getPaged?pageNum=1&pageSize="+currPageSize;

    }
</script>

</body>
</html>

