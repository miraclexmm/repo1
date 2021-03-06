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
<title>职位添加</title>
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
				<div id="right_title">当前位置:职位管理>添加职位</div>
				<div id="right_add">
					<f:form action="job/jobAdd" method="post" modelAttribute="job" id="job_form">
						<div class="add_item">
							<label>职位名称:</label><input type="text" name="name" /><f:errors path="name" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>描述:</label><input type="text" name="remark" />
						</div>
						<div id="add_submit">
							<input type="submit" value="添加" /> <input type="reset"
								value="取消" />
						</div>
					</f:form>
				</div>
			</div>

		</div>

	</div>
</body>
</html>