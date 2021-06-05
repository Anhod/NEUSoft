<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>添加一级标题</title>
		<link rel="stylesheet" href="../../../css/common1.css" />
	</head>
	<body>
		<div class="container">
			<div class="box">
				<div class="title">
					<span>添加一级标题</span>
				</div>
				<div class="content">
					<form action="${pageContext.request.contextPath}/first/insert" method="post">
						<table>
							<tr>
								<td><span>一级标题名称</span></td><td><input type="text" name="titleName"/></td>
							</tr>
							<tr>
								<td><span>创建者</span></td><td><input type="text" name="creator" value="管理员"/></td>
							</tr>
							<tr>
								<td></td><td><input type="submit" value="添加"/></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
