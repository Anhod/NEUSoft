<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>后台管理首页</title>
		<link rel="stylesheet" href="../../../css/common1.css" />
	</head>
	<body>
		<div class="container">
			<div class="header">
				<h3>新闻资讯后台管理系统</h3>
				<p>管理员：习近平</p>
			</div>
			<div class="main">
				<div class="left">
					<ul>
						<li>菜单列表</li>
						<li><a href="${pageContext.request.contextPath}/first/add" target="manager">添加一级新闻标题</a></li>
						<li><a href="${pageContext.request.contextPath}/first/firstList" target="manager">一级新闻标题管理</a></li>
						<li><a href="${pageContext.request.contextPath}/second/addSecond" target="manager">添加二级新闻标题</a></li>
						<li><a href="${pageContext.request.contextPath}/second/secondList" target="manager">二级新闻标题管理</a></li>
					</ul>
				</div>
				<div class="right" style="margin-top: 15px">
					<iframe src="${pageContext.request.contextPath}/admin/welcome" name="manager" frameborder="no" scrolling="no"></iframe>
				</div>
			</div>
		</div>

	</body>
</html>
