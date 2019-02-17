<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="f" uri="/spring-form"%>
<%@taglib prefix="s" uri="/spring"%>
<%@taglib prefix="c" uri="/jstl-core"%>
<%@taglib prefix="fmt" uri="/jstl-fmt"%>
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
<title>员工查询</title>
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
				<div id="right_title">当前位置:员工管理>员工查询</div>
				<div id="right_find">
					<form action="employee/employeeSearch" method="post" >
						<div class="find_item">
							<label>所属部门:</label> <select name="dept_id">
								<option value="">--请选择部门</option>
								<c:forEach items="${requestScope.dept_list }" var="var_dept">
									<option value="${var_dept.id }">${var_dept.name }</option>>
								  </c:forEach>
							</select> <label>所属职位:</label> <select name="job_id">
								<option value="">--请选择职位--</option>
								<c:forEach items="${requestScope.job_list }" var="var_job">
									<option value="${var_job.id}">${var_job.name }</option>
								</c:forEach>
							</select>
						</div>
						<div class="find_item">
							<label>姓名:</label> <input type="text" name="name" /> <label>性别:</label>
							<select name="sex">
								<option value="">--请选择性别--</option>
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</div>
						<div class="find_item">
							<label>身份证号码:</label> <input type="text" name="cardId" /> <label>QQ号:</label>
							<input type="text" name="qq" />
						</div>
						<div id="find_submit">
							<input type="submit" value="查询" />
						</div>
					</form>

					<div id="right_table">
						<c:choose>
							<c:when
								test="${requestScope.employee_list != null && requestScope.employee_list.size() > 0 }">
								<table border="1">
									<tr>
										<th>姓名</th>
										<th>性别</th>
										<th>部门</th>
										<th>职位</th>
										<th>入职日期</th>
										<th>操作</th>
									</tr>

									<c:forEach items="${requestScope.employee_list }"
										var="var_employee">
										<tr align="center">
											<td>${var_employee.name }</td>
											<td>${var_employee.sex }</td>
											<td>${var_employee.dept.name }</td>
											<td>${var_employee.job.name }</td>
											<td><fmt:formatDate value="${var_employee.createDate }"
													pattern="yyyy年MM月DD日" /></td>
											<td>
												<button onclick="employee_delete(${var_employee.id})">删除</button>
												<button onclick="employee_modify(${var_employee.id})">修改</button>
												<button onclick="employee_show(this)">查看详情</button>
	<div class="show_detail">
			<div class="show_item">
				<div class="show_item_label">姓名:</div>
				<div class="show_item_content">${var_employee.name }</div>
			</div>
			<div class="show_item">
				<div class="show_item_label">所属部门:</div>
				<div class="show_item_content">${var_employee.dept.name }</div>
			</div>
			<div class="show_item">
				<div class="show_item_label">职位:</div>
				<div class="show_item_content">${var_employee.job.name }</div>
			</div>
			<div class="show_item">
				<div class="show_item_label">年龄:</div>
				<div class="show_item_content">${var_employee.age }</div>
			</div>
			<div class="show_item">
				<div class="show_item_label">性别:</div>
				<div class="show_item_content">${var_employee.sex }</div>
			</div>
			<div class="show_item">
				<div class="show_item_label">身份证号码:</div>
				<div class="show_item_content">${var_employee.cardId }</div>
			</div>
			<div class="show_item">
				<div class="show_item_label">地址:</div>
				<div class="show_item_content">${var_employee.address }</div>
			</div>
			<div class="show_item">
				<div class="show_item_label">邮编:</div>
				<div class="show_item_content">${var_employee.postCode }</div>
			</div>
			<div class="show_item">
				<div class="show_item_label">qq:</div>
				<div class="show_item_content">${var_employee.qq }</div>
			</div>
			<div class="show_item">
				<div class="show_item_label">邮箱:</div>
				<div class="show_item_content">${var_employee.email }</div>
			</div>
			<div class="show_item">
				<div class="show_item_label">入职时间:</div>
				<div class="show_item_content">
					<fmt:formatDate value="${var_employee.createDate }" pattern="yyyy年MM月DD日" />
				</div>
			</div>
			<div class="show_item">
				<div class="show_item_label">民族:</div>
				<div class="show_item_content">${var_employee.race }</div>
			</div>
			<div class="show_item">
				<div class="show_item_label">学历:</div>
				<div class="show_item_content">${var_employee.education }</div>
			</div>
			<div class="show_item">
				<div class="show_item_label">爱好:</div>
				<div class="show_item_content">${var_employee.hobby }</div>
			</div>
			<div class="show_item">
				<div class="show_item_label">备注:</div>
				<div class="show_item_content">${var_employee.remark }</div>
			</div>
	</div>
											</td>
										</tr>
									</c:forEach>
								</table>
								<div id="right_page">
									<c:if test="${requestScope.pageInfo.pageNum > 1 }">
										<a
											href="employee/employeeSearch?curPage=1&name=${requestScope.employee.name}&dept_id=${requestScope.employee.dept.id}
												  &job_id=${requestScope.employee.job.id}
												  &sex=${requestScope.employee.sex}
												  &qq=${requestScope.employee.qq}
												  &cardId=${requestScope.employee.cardId}">首页</a>
										<a
											href="employee/employeeSearch?curPage=${ requestScope.pageInfo.pageNum - 1}&name=${requestScope.employee.name}&dept_id=${requestScope.employee.dept.id}
												  &job_id=${requestScope.employee.job.id}
												  &sex=${requestScope.employee.sex}
												  &qq=${requestScope.employee.qq}
												  &cardId=${requestScope.employee.cardId}">上一页</a>
									</c:if>
									<c:if
										test="${requestScope.pageInfo.pageNum < requestScope.pageInfo.pages }">
										<a
											href="employee/employeeSearch?curPage=${ requestScope.pageInfo.pageNum + 1}&name=${requestScope.employee.name}&dept_id=${requestScope.employee.dept.id}
												  &job_id=${requestScope.employee.job.id}
												  &sex=${requestScope.employee.sex}
												  &qq=${requestScope.employee.qq}
												  &cardId=${requestScope.employee.cardId}">下一页</a>
										<a
											href="employee/employeeSearch?curPage=${ requestScope.pageInfo.pages}&name=${requestScope.employee.name}&dept_id=${requestScope.employee.dept.id}
												  &job_id=${requestScope.employee.job.id}
												  &sex=${requestScope.employee.sex}
												  &qq=${requestScope.employee.qq}
												  &cardId=${requestScope.employee.cardId}">尾页</a>
									</c:if>
									${requestScope.pageInfo.pageNum }/${requestScope.pageInfo.pages }页&nbsp;共查询到${requestScope.pageInfo.total }条
								</div>
							</c:when>
							<c:otherwise>
								<div id="right_no_result">暂无查询结果!</div>
							</c:otherwise>
						</c:choose>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>