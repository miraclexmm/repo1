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
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/validator/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/layer/layer.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/main_function.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>用户查询</title>
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

				<div id="right_title">当前位置:用户管理 > 用户查询</div>

				<div id="right_find">
					<form action="user/userSearch" method="post" id="#user_form">
						<div class="find_item">
							<label>用户名:</label> <input type="text" name="realName" /> <input
								type="submit" value="查询" style="width: 50px; margin-left: 5px" />
						</div>

					</form>
				</div>

				<div id="right_table">
					<c:choose>
						<c:when
							test="${requestScope.user_list != null && requestScope.user_list.size() > 0 }">
							<table border="1">
								<tr>
									<th>登录名</th>
									<th>密码</th>
									<th>真实姓名</th>
									<th>状态</th>
									<th>创建时间</th>
									<th>操作</th>
								</tr>

								<c:forEach items="${requestScope.user_list }" var="var_user">
									<tr align="center">
										<td>${var_user.loginName }</td>
										<td>${var_user.password }</td>
										<td>${var_user.realName }</td>
										<td><c:if test="${var_user.status == 1 }">正常</c:if> <c:if
												test="${var_user.status == 2 }">已锁定</c:if></td>
										<td><fmt:formatDate value="${var_user.createDate }"
												pattern="yyyy年MM月DD日" /></td>
										<td>
											<button onclick="user_delete(${var_user.id})">删除</button>
											<button onclick="user_modify(${var_user.id})">修改</button>
										</td>
									</tr>
								</c:forEach>
							</table>
							<div id="right_page">
								<c:if test="${requestScope.pageInfo.pageNum > 1 }">
									<a
										href="user/userSearch?curPage=1&realName=${requestScope.realName}">首页</a>
									<a
										href="user/userSearch?curPage=${ requestScope.pageInfo.pageNum - 1}&realName=${requestScope.realName}">上一页</a>
								</c:if>
								<c:if
									test="${requestScope.pageInfo.pageNum < requestScope.pageInfo.pages }">
									<a
										href="user/userSearch?curPage=${ requestScope.pageInfo.pageNum + 1}&realName=${requestScope.realName}">下一页</a>
									<a
										href="user/userSearch?curPage=${ requestScope.pageInfo.pages}&realName=${requestScope.realName}">尾页</a>
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
</body>
</html>