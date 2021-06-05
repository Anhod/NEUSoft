<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>登陆</title>
    <link rel="stylesheet" href="../../../css/common1.css"/>

    <style>
        .container {
            width: 400px;
            margin: 0 auto;
            margin-top: 100px;
            height: 300px;
        }

        .box {
            width: 400px;
            height: 300px;
        }

        .box .content img {
            width: 63px;
            height: 37px;
            display: inline;
            vertical-align: middle;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="box">
        <div class="title">
            <span>登陆</span>
        </div>
        <div class="content">
            <form action="${pageContext.request.contextPath}/admin/login" method="post">
                <table>
                    <tr>
                        <td><span>用户名</span></td>
                        <td><input type="text" name="userName"/></td>
                    </tr>
                    <tr>
                        <td><span>密码</span></td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="登陆"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
