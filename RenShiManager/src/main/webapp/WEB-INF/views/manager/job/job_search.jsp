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
<title>职位查询</title>
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
				<div id="right_title">当前位置:职位管理>查询职位</div>
				<div id="right_find">
					<form action="job/jobSearch" method="post" >
						<div class="find_item">
							<label>职位名:</label> <input type="text" name="name" /> <input
								type="submit" value="查询" style="width: 50px; margin-left: 5px" />
						</div>
					</form>
					<div id="right_table">
						<c:choose>
							<c:when
								test="${requestScope.job_list != null && requestScope.job_list.size() > 0 }">
								<table border="1">
									<tr>
										<th width="250px">职位名称</th>
										<th width="250px">详细信息</th>
										<th>操作</th>
									</tr>

									<c:forEach items="${requestScope.job_list }" var="var_job">
										<tr align="center">
											<td>${var_job.name }</td>
											<td>${var_job.remark }</td>
											<td>
												<button onclick="job_delete(${var_job.id})">删除</button>
												<button onclick="job_modify(this)">修改</button>
												<div class="modify">
												<form action="job/jobModify" method="post" id="job_form">
													<input type="hidden" name="id" value="${var_job.id}"/>
													<div class="add_item" style="margin-top: 50px;">
														<label>职位名称:</label><input type="text" name="name" value="${var_job.name}"/>
													</div>
													<div class="add_item">
														<label>描述:</label><input type="text" name="remark" value="${var_job.remark}"/>
													</div>
													<div id="add_submit">
														<input type="submit" value="修改" /> <input type="reset"
															value="取消" />
													</div>
												</form>
												</div>
											</td>
										</tr>
									</c:forEach>
								</table>
								<div id="right_page">
									<c:if test="${requestScope.pageInfo.pageNum > 1 }">
										<a href="job/jobSearch?curPage=1&name=${requestScope.name}">首页</a>
										<a
											href="job/jobSearch?curPage=${ requestScope.pageInfo.pageNum - 1}&name=${requestScope.name}">上一页</a>
									</c:if>
									<c:if
										test="${requestScope.pageInfo.pageNum < requestScope.pageInfo.pages }">
										<a
											href="job/jobSearch?curPage=${ requestScope.pageInfo.pageNum + 1}&name=${requestScope.name}">下一页</a>
										<a
											href="job/jobSearch?curPage=${ requestScope.pageInfo.pages}&name=${requestScope.name}">尾页</a>
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