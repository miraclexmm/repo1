/*
 * 文档操作
 */
function download(id){
	location.href="document/documentDownload?id="+id
}
function document_delete(id){
	layer.confirm("确定要删除吗?",
			{
				title:"提示",
				icon:3
			},function(){
				var wait = layer.load(1);
				$.post("document/documentDelete",
						{
							id:id
						},function(data){
							layer.close(wait);
							if(data == "OK"){
								layer.alert("删除成功!",
										{
											title:"提示",
											icon:6,
											closeBtn:0
										},function(){
											location.href="document/documentSearch";
										});
							}else if(data == "NO_FILE"){
								layer.alert("文件不存在!",
										{
											title:"提示",
											icon:3,
											closeBtn:0
										});
							}else {
								layer.alert("删除出错!",
										{
											title:"提示",
											icon:3,
											closeBtn:0
								});
							}
						});
			});
}
//End 文件操作

//公告操作
function notice_modify(id){
	location.href="notice/noticeModifyIndex?id="+id;
}
function notice_delete(id){
	layer.confirm("确定要删除吗?",
			{
				title:"提示",
				icon:3
			},function(){
				var wait = layer.load(1);
				$.post("notice/noticeDelete",
						{
							id:id
						},function(data){
							layer.close(wait);
							if(data == "OK"){
								layer.alert("删除成功!",
										{
											title:"提示",
											icon:6,
											closeBtn:0
										},function(){
											location.href="notice/noticeSearch";
										});
							}else {
								layer.alert("删除出错!",
										{
											title:"提示",
											icon:5,
											closeBtn:0
								});
							}
						});
			});
}

function notice_show(ob){
	layer.open({
				type:1,
				title:"预览公告",
				area:"600px",
				content:$(ob).next()
	});
}
//End公告

//用户
function logout(){
	layer.confirm("确定要注销吗?",
			{
				title:"提示",
				icon:3,
			},function(){
				location.href="user/userLogout";
			});
}

//End用户
//部门
function dept_modify(id){
	location.href="dept/deptModifyIndex?id="+id;
}
function dept_delete(id){
	layer.confirm("确定要删除吗?",
			{
				title:"提示",
				icon:3
			},function(){
				var wait = layer.load(1);
				$.post("dept/deptDelete",
						{
							id:id
						},function(data){
							layer.close(wait);
							if(data == "OK"){
								layer.alert("删除成功!",
										{
											title:"提示",
											icon:6,
											closeBtn:0
										},function(){
											location.href="dept/deptSearch";
										});
							}else {
								layer.alert("删除出错!",
										{
											title:"提示",
											icon:5,
											closeBtn:0
								});
							}
						});
			});
}
//End部门
//员工
function employee_modify(id){
	location.href="employee/employeeModifyIndex?id="+id;
}
function employee_delete(id){
	layer.confirm("确定要删除吗?",
			{
				title:"提示",
				icon:3
			},function(){
				var wait = layer.load(1);
				$.post("employee/employeeDelete",
						{
							id:id
						},function(data){
							layer.close(wait);
							if(data == "OK"){
								layer.alert("删除成功!",
										{
											title:"提示",
											icon:6,
											closeBtn:0
										},function(){
											location.href="employee/employeeSearch";
										});
							}else {
								layer.alert("删除出错!",
										{
											title:"提示",
											icon:5,
											closeBtn:0
								});
							}
						});
			});
}

function employee_show(ob){
	layer.open({
				type:1,
				title:"员工详细信息",
				area:"600px",
				content:$(ob).next()
	});
}
//End员工
//职位
function job_modify(id){
	location.href="job/jobModifyIndex?id="+id;
}
function job_delete(id){
	layer.confirm("确定要删除吗?",
			{
				title:"提示",
				icon:3
			},function(){
				var wait = layer.load(1);
				$.post("job/jobDelete",
						{
							id:id
						},function(data){
							layer.close(wait);
							if(data == "OK"){
								layer.alert("删除成功!",
										{
											title:"提示",
											icon:6,
											closeBtn:0
										},function(){
											location.href="job/jobSearch";
										});
							}else {
								layer.alert("删除出错!",
										{
											title:"提示",
											icon:5,
											closeBtn:0
								});
							}
						});
			});
}
//End职位

//用户
function user_delete(id){
	layer.confirm("确定要删除吗?",
			{
				title:"提示",
				icon:3
			},function(){
				var wait = layer.load(1);
				$.post("user/userDelete",
						{
							id:id
						},function(data){
							layer.close(wait);
							if(data == "OK"){
								layer.alert("删除成功!",
										{
											title:"提示",
											icon:6,
											closeBtn:0
										},function(){
											location.href="user/userSearch";
										});
							}else {
								layer.alert("删除出错!",
										{
											title:"提示",
											icon:5,
											closeBtn:0
								});
							}
						});
			});
}
function user_modify(id){
	location.href="user/userModifyIndex?id="+id;
}

