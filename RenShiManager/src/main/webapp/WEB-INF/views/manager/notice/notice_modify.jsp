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
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/validator/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/layer/layer.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/main_function.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>公告修改</title>
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
				<div id="right_title">当前位置:公告管理>公告修改</div>
				<div id="right_add">
					<f:form action="notice/noticeModify" method="post" modelAttribute="notice" id="notice_form">
						<div class="add_item">
							<label>公告标题:</label><f:input path="title"/><f:errors path="title" cssClass="error"/>
						</div>
						<div class="add_item" style="height: 180px;">
							<label>公告内容:</label>
							<textarea rows="10" cols="40" name="content" id="txt_content">
								
							</textarea><f:errors path="content" cssClass="error"/>
						</div>
						<div id="add_submit">
							<input type="submit" value="添加"/> <input type="reset"
								value="取消" />
						</div>
					</f:form>
				</div>
			</div>

		</div>

	</div>
</body>
</html>