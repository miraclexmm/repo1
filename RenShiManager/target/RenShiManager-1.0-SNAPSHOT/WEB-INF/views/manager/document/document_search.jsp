<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="f" uri="/spring-form"%>
<%@taglib prefix="s" uri="/spring"%>
<%@ taglib uri="/jstl-core" prefix="c" %>
<%@ taglib uri="/jstl-fmt" prefix="fmt" %>
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
<title>文档查询</title>
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
				<div id="right_title">当前位置:文档管理>文档查询</div>
				<div id="right_find">
					<form action="document/documentSearch" method="post" >
						<div class="find_item">
							<label>文件标题:</label> <input type="text" name="name" /> <input
								type="submit" value="查询" style="width: 50px; margin-left: 5px" />
						</div>
					</form>
					<div id="right_table">
						<c:choose>
							<c:when
								test="${requestScope.document_list != null && requestScope.document_list.size() > 0 }">
								<table border="1">
									<tr>
										<th>文件标题</th>
										<th>发布时间</th>
										<th>发布人</th>
										<th>描述</th>
										<th>操作</th>
									</tr>

									<c:forEach items="${requestScope.document_list }"
										var="var_document">
										<tr align="center">
											<td>${var_document.title }</td>
											<td>${var_document.user.realName }</td>
											<td>${var_document.remark }</td>
											<td>
												<fmt:formatDate value="${var_document.createDate }" pattern="yyyy年MM月DD日"/>	
											</td>
											<td>
												<button onclick="document_delete(${var_document.id})">删除</button>
												<button onclick="download(${var_document.id})">下载</button>
											</td>
										</tr>
									</c:forEach>
								</table>
								<div id="right_page">
									<c:if test="${requestScope.pageInfo.pageNum > 1 }">
										<a
											href="document/documentSearch?curPage=1&name=${requestScope.name}">首页</a>
										<a
											href="document/documentSearch?curPage=${ requestScope.pageInfo.pageNum - 1}&name=${requestScope.name}">上一页</a>
									</c:if>
									<c:if
										test="${requestScope.pageInfo.pageNum < requestScope.pageInfo.pages }">
										<a
											href="document/documentSearch?curPage=${ requestScope.pageInfo.pageNum + 1}&name=${requestScope.name}">下一页</a>
										<a
											href="document/documentSearch?curPage=${ requestScope.pageInfo.pages}&name=${requestScope.name}">尾页</a>
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