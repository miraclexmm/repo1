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
<title>上传文档</title>
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
				<div id="right_title">当前位置:文档管理>上传文档</div>
				<div id="right_add">
					<f:form action="document/documentAdd" method="post" enctype="multipart/form-data" modelAttribute="document" id="document_form">
						<div class="add_item">
							<label>文件标题:</label><f:input path="title"/><f:errors path="title" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>文件描述:</label>
							<input type="text" name="remark"/>
						</div>
						<div class="add_item">
							<label>文件:</label>
							 <input type="file" name="file"/><f:errors path="file" cssClass="error"/>
						</div>
						<div id="add_submit">
							<input type="submit" value="上传" /> <input type="reset"
								value="重置" />
						</div>
					</f:form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>