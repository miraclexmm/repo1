<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="f" uri="/spring-form"%>
<%@taglib prefix="s" uri="/spring" %>
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
<title>修改用户信息</title>
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/validator/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/layer/layer.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/main_function.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div id="big">

		<div id="header">
			<jsp:include page="../../main-element/title.jsp" />
		</div>

		<div id="content">

			<div id="left">
				<jsp:include page="../../main-element/left.jsp" />

			</div>

			<div id="right">
				<div id="right_title">当前位置:用户管理>修改用户信息</div>
				<div id="right_add">
					<f:form action="user/userModify" method="post" modelAttribute="user" id="user_form">
						<div class="add_item">
							<label>登录名:</label><f:input path="loginName"/><f:errors path="loginName" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>密码:</label><f:password path="password" /><f:errors path="password" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>姓名:</label><f:input path="realName" /><f:errors path="realName" cssClass="error"/>
						</div>
						<div id="add_submit">
							<input type="submit" value="修改" /> <input type="reset" value="取消" />
						</div>
					</f:form>
				</div>
			</div>

		</div>

	</div>
</body>
</html>