<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="f" uri="/spring-form"%>
<%@taglib prefix="s" uri="/spring"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div id="big">
		<div id="title">
			<h3>人事管理Hrm1.0系统</h3>
		</div>
		<div id="form">
			<div id="error">${requestScope.message }</div>
			<form action="login" method="post">
				<div class="login_item">
					<input type="text" name="loginName" placeholder="账号" />
				</div>
				<div class="login_item">
					<input type="password" name="password" placeholder="密码" />
				</div>
				<div id="submit">
					<input type="submit" value="登录" />
				</div>
			</form>
		</div>
	</div>
	<div id="remark">Copyright © 2017 All Rights Reserved.强哥科技 版权所有.</div>
</body>
</html>