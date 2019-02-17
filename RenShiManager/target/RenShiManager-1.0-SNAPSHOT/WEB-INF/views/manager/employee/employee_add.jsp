<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/spring-form" prefix="f" %>
<%@taglib prefix="c" uri="/jstl-core"%>
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
<title>添加员工</title>
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
				<div id="right_title">当前位置:员工管理>添加员工</div>
				<div id="right_add">
					<f:form action="employee/emloyeeAdd" method="post" modelAttribute="employee" id="employee_form">
						<div class="add_item">
							<label>姓名:</label><input type="text" name="name" /><f:errors path="name" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>身份证号:</label><input type="text" name="cardId" /><f:errors path="cardId" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>性别:</label>
							<select name="sex">
								<option value="">--请选择性别--</option>
								<option value="男">男</option>
								<option value="女">女</option>
							</select><f:errors path="sex" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>年龄:</label><input type="text" name="age" /><f:errors path="age" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>职位:</label>
							<select name="jobId">
								<option value="">--请选择职位--</option>
								<c:forEach items="${requestScope.job_list}" var="var_job">
									<option value="${var_job.id }">${var_job.name }</option>
								</c:forEach>
							</select><f:errors path="jobId" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>学历:</label>
							<select name="education">
								<option value="">--请选择学历--</option>
								<option value="硕士">硕士</option>
								<option value="研究生">研究生</option>
								<option value="本科">本科</option>
								<option value="专职">专职</option>
								<option value="高中">高中</option>
								<option value="初中">初中</option>
								<option value="小学">小学</option>
							</select><f:errors path="education" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>邮箱:</label><input type="text" name="email" /><f:errors path="email" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>QQ:</label><input type="text" name="qq" /><f:errors path="qq" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>民族:</label>
							<select name="race">
								<option value="">--请选择--</option>
								<option value="汉族">汉</option>
								<option value="少数民族">少数民族</option>
								<option value="外籍">外籍</option>
							</select><f:errors path="race" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>联系地址:</label><input type="text" name="address" /><f:errors path="address" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>爱好:</label><input type="text" name="hobby" /><f:errors path="hobby" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>邮政编码:</label><input type="text" name="postCode" />
						</div>
						<div class="add_item">
							<label>所属部门:</label>
							<select name="deptId">
								<option value="">--请选择--</option>
								<c:forEach items="${requestScope.dept_list }" var="var_dept">
									<option value="${var_dept.id }">${var_dept.name }</option>
								</c:forEach>
							</select><f:errors path="deptId" cssClass="error"/>
						</div>
						<div class="add_item">
							<label>备注:</label><input type="text" name="remark" />
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