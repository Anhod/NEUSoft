<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>新闻资讯列表</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/list.css"/>
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
    <img src="../../img/0news.jpg"/>
</div>
<div class="hengban"></div>
<div class="container">
    <div class="newsType">
        <div></div>
        <p>新闻列表</p>
        <div></div>
    </div>
    <div class="content">
        <ul>
            <c:choose>
                <c:when test="${empty secondTitles}">
                    <center>
                        <div>暂无</div>
                    </center>

                </c:when>
                <c:otherwise>
                    <c:forEach items="${secondTitles}" var="secondTitle">
                        <li>
                            <a href="${pageContext.request.contextPath}/news?secondId=${secondTitle.sid}">${secondTitle.titleName}</a>
                        </li>
                    </c:forEach>
                </c:otherwise>
            </c:choose>


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
