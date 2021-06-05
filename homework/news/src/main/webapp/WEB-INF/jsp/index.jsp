<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>新闻资讯首页</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
</head>

<body>
<%--	头部导航栏--%>
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

<%--图片引入--%>
<div class="banner">
    <img src="../../img/0news.jpg"/>
</div>

<div class="hengban"></div>

<div class="container">
    <div class="newsType">
        <div></div>
        <p>新闻分类</p>
        <div></div>
    </div>
    <%--			此处动态加载数据中的--%>
    <div class="content">
        <ul>
            <c:forEach items="${list}" var="firstTitle">
                <li>
                    <a href="${pageContext.request.contextPath}/getSecond?firstId=${firstTitle.fid}">${firstTitle.titleName}</a>
                </li>
            </c:forEach>

            <div class="clear"></div>
        </ul>
    </div>
</div>

<div class="hengban"></div>
<div class="footer">
    <p>&copy; 版权所有 http://www.XXXX.com &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/">后台管理</a></p>
</div>
</body>
</html>
