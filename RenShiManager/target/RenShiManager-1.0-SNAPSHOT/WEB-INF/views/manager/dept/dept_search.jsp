<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="f" uri="/spring-form"%>
<%@taglib prefix="s" uri="/spring"%>
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
<title>部门查询</title>
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
				<div id="right_title">当前位置:部门管理>查询部门</div>
				<div id="right_find">
					<form action="dept/deptSearch" method="post">
						<div class="find_item">
							<label>部门名:</label> <input type="text" name="name" /> <input
								type="submit" value="查询" style="width: 50px; margin-left: 5px" />
						</div>
					</form>
					<div id="right_table">
						<c:choose>
							<c:when
								test="${requestScope.dept_list != null && requestScope.dept_list.size() > 0 }">
								<table border="1">
									<tr>
										<th>部门名称</th>
										<th>详细信息</th>
										<th>操作</th>
									</tr>

									<c:forEach items="${requestScope.dept_list }" var="var_dept">
										<tr align="center">
											<td>${var_dept.name }</td>
											<td>${var_dept.remark }</td>
											<td>
												<button onclick="dept_delete(${var_dept.id})">删除</button>
												<button onclick="dept_modify(${var_dept.id})">修改</button>
											</td>
										</tr>
									</c:forEach>
								</table>
								<div id="right_page">
									<c:if test="${requestScope.pageInfo.pageNum > 1 }">
										<a href="dept/deptSearch?curPage=1&name=${requestScope.name}">首页</a>
										<a
											href="dept/deptSearch?curPage=${ requestScope.pageInfo.pageNum - 1}&name=${requestScope.name}">上一页</a>
									</c:if>
									<c:if
										test="${requestScope.pageInfo.pageNum < requestScope.pageInfo.pages }">
										<a
											href="dept/deptSearch?curPage=${ requestScope.pageInfo.pageNum + 1}&name=${requestScope.name}">下一页</a>
										<a
											href="dept/deptSearch?curPage=${ requestScope.pageInfo.pages}&name=${requestScope.name}">尾页</a>
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