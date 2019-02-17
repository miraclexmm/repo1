<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="f" uri="/spring-form"%>
<%@taglib prefix="s" uri="/spring"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body >
	<div class="item">
		<a href="javaScript:" class="item_a">用户管理</a>
		<div class="item_list">
			<ul>
				<li><a href="userSearchIndex" class="item_list_a">用户查询</a></li>
				<li><a href="user/userAddIndex" class="item_list_a">添加用户</a></li>
			</ul>
		</div>
	</div>
	
	<div class="item">
		<a href="javaScript:" class="item_a">部门管理</a>
		<div class="item_list">
			<ul>
				<li><a href="dept/deptSearchIndex" class="item_list_a">部门查询</a></li>
				<li><a href="dept/deptAddIndex" class="item_list_a">添加部门</a></li>
			</ul>
		</div>
	</div>
	<div class="item">
		<a href="javaScript:" class="item_a">职位管理</a>
		<div class="item_list">
			<ul>
				<li><a href="job/jobSearchIndex" class="item_list_a">职位查询</a></li>
				<li><a href="job/jobAddIndex" class="item_list_a">添加职位</a></li>
			</ul>
		</div>
	</div>
	<div class="item">
		<a href="javaScript:" class="item_a">员工管理</a>
		<div class="item_list">
			<ul>
				<li><a href="employee/employeeSearchIndex" class="item_list_a">员工查询</a></li>
				<li><a href="employee/employeeAddIndex" class="item_list_a">添加员工</a></li>
			</ul>
		</div>
	</div>
	<div class="item">
		<a href="javaScript:" class="item_a">公告管理</a>
		<div class="item_list">
			<ul>
				<li><a href="notice/noticeSearchIndex" class="item_list_a">公告查询</a></li>
				<li><a href="notice/noticeAddIndex" class="item_list_a">添加公告</a></li>
			</ul>
		</div>
	</div>
	<div class="item">
		<a href="javaScript:" class="item_a">下载中心</a>
		<div class="item_list">
			<ul>
				<li><a href="document/documentSearchIndex" class="item_list_a">文档查询</a></li>
				<li><a href="document/documentAddIndex" class="item_list_a">上传文档</a></li>
			</ul>
		</div>
	</div>
</body>
</html>