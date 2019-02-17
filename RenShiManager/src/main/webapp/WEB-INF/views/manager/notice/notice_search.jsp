<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="f" uri="/spring-form"%>
<%@taglib prefix="s" uri="/spring"%>
<%@taglib prefix="c" uri="/jstl-core"%>
<%@ taglib uri="/jstl-fmt" prefix="fmt"%>
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
<title>公告查询</title>
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
				<div id="right_title">当前位置:公告管理>公告查询</div>
				<div id="right_find">
					<form action="notice/noticeSearch" method="post" >
						<div class="find_item">
							<label>公告:</label> <input type="text" name="name" /> <input
								type="submit" value="查询" style="width: 50px; margin-left: 5px" />
						</div>
					</form>
					<div id="right_table">
						<c:choose>
							<c:when
								test="${requestScope.notice_list != null && requestScope.notice_list.size() > 0 }">
								<table border="1">
									<tr>
										<th>公告名称</th>
										<th>发布时间</th>
										<th>发布人</th>
										<th>操作</th>
									</tr>

									<c:forEach items="${requestScope.notice_list }"
										var="var_notice">
										<tr align="center">
											<td>${var_notice.title }</td>
											<td><fmt:formatDate value="${var_notice.createDate }"
													pattern="yyyy年MM月DD日" /></td>
											<td>${var_notice.user.realName }</td>
											<td>
												<button onclick="notice_delete(${var_notice.id})">删除</button>
												<button onclick="notice_modify(${var_notice.id})">修改</button>
												<button onclick="notice_show(this)">查看详情</button>
												<div class="show_detail" style="height: 500px;">
														<h3 align="center">${var_notice.title }</h3>
														
														<div style="width: 500px;margin-top: 30px;text-align: center;">
															${var_notice.content }
														</div>
												</div>
											</td>
										</tr>
									</c:forEach>
								</table>
								<div id="right_page">
									<c:if test="${requestScope.pageInfo.pageNum > 1 }">
										<a
											href="notice/noticeSearch?curPage=1&name=${requestScope.name}">首页</a>
										<a
											href="notice/noticeSearch?curPage=${ requestScope.pageInfo.pageNum - 1}&name=${requestScope.name}">上一页</a>
									</c:if>
									<c:if
										test="${requestScope.pageInfo.pageNum < requestScope.pageInfo.pages }">
										<a
											href="notice/noticeSearch?curPage=${ requestScope.pageInfo.pageNum + 1}&name=${requestScope.name}">下一页</a>
										<a
											href="notice/noticeSearch?curPage=${ requestScope.pageInfo.pages}&name=${requestScope.name}">尾页</a>
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