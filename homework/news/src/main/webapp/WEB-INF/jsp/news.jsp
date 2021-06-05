<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8" />
		<title>新闻资讯内容</title>
		<link rel="stylesheet" href="../../css/common.css" />
		<link rel="stylesheet" href="../../css/news.css" />
	</head>
	<body>
		<div class="header">
			<div class="nav">
				<div class="logo"><strong><em>NEWS</em></strong></div>
				<ul>
					<li><a href="${pageContext.request.contextPath}/">首页</a></li>
					<li><a href="">联系我们</a></li>
					<li><a href="">客服中心</a></li>
					<li><a href="">问题反馈</a></li>
				</ul>
			</div>
		</div>
		<div class="banner">
			<img src="../../img/0news.jpg" />
		</div>
		<div class="hengban"></div>
		<div class="container">
			<div class="newsType">
				<div></div>
				<p>新闻内容</p>
				<div></div>
			</div>
			<div class="content">
				<h4>${secondTitle.titleName}</h4>
				<div>
					${secondTitle.newContent}
				</div>
				<p>${secondTitle.createTime}</p>
			</div>
		</div>
		<div class="hengban"></div>
		<div class="footer">
			<p>&copy; 版权所有 http://www.XXXX.com &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/">后台管理</a></p>
		</div>
	</body>
</html>
