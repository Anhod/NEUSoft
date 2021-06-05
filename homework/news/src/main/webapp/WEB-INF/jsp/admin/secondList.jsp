<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>二级标题列表</title>
		<link rel="stylesheet" href="../../../css/common1.css" />
	</head>
	<body>
		<div class="container">
			<div class="box">
				<div class="title">
					<span>二级标题列表</span>
				</div>

				<div class="content">
					<table class="dataList">
						<thead>
						<tr>
							<th>二级标题ID</th>
							<th>二级标题名称</th>
							<th>创建者</th>
							<th>创建时间</th>
							<th>所属一级标题</th>
							<th>操作</th>
						</tr>
						</thead>

						<tbody>
						<c:forEach items="${pageInfo.list}" var="second">
							<tr>
								<td style="width: 150px">${second.sid}</td>
								<td style="width: 380px">${second.titleName}</td>
								<td style="width: 200px">${second.creator}</td>
								<td style="width: 200px">${second.createTime}</td>
								<td style="width: 150px">${second.firstTitle.titleName}</td>

								<td style="width: 200px">
									<a href="${pageContext.request.contextPath}/second/update?sid=${second.sid}" style="color: blue">更新</a>
									<a href="${pageContext.request.contextPath}/second/delete?sid=${second.sid}" style="color: red">删除</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>

						<%--        分页--%>
						<tfoot>
						<td colspan="6">
							<div style="float: left">
								<a style="pointer-events: none;">共${pageInfo.total}条记录</a>
								<a style="pointer-events: none;">第${pageInfo.pageNum}页/共${pageInfo.pages}页</a>
							</div>

							<c:if test="${! pageInfo.isFirstPage}">
								<a href="${pageContext.request.contextPath}/second/secondList?pageNum=1&pageSize=${pageInfo.pageSize}">首页</a>
								<a href="${pageContext.request.contextPath}/second/secondList?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}">上一页</a>
							</c:if>

							<c:if test="${! pageInfo.isLastPage}">
								<a href="${pageContext.request.contextPath}/second/secondList?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}">下一页</a>
								<a href="${pageContext.request.contextPath}/second/secondList?pageNum=${pageInfo.navigateLastPage}&pageSize=${pageInfo.pageSize}">末页</a>
							</c:if>
						</td>
						</tfoot>
					</table>
				</div>

			</div>
		</div>
	</body>
</html>
