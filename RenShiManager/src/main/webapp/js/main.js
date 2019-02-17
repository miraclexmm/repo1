$(function() {

	$(".item_a").click(function() {
		$(this).next().slideToggle();
	});

	// 用户表单
	$("#user_form").validate({
		rules : {
			loginName : "required",
			password : {
				required : true,
				minlength : 5
			},
			realName : "required"
		},
		messages : {
			loginName : {
				required : "用户名不能为空!"
			},
			password : {
				required : "密码不能为空!",
				minlength : "密码长度不能低于5位!"
			},
			realName : {
				required : "真实姓名不能为空!"
			}
		},
		errorPlacement : function(error, element) {
			if (element.is(":radio"))
				error.appendTo(element.parent().next().next());
			else if (element.is(":checkbox"))
				error.appendTo(element.next());
			else
				error.appendTo(element.parent());
		},
		errorElement : "span",
		// set this class to error-labels to indicate valid fields
		success : function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("true");
		},
		highlight : function(element, errorClass) {
			$(element).parent().find("." + errorClass).removeClass("true");
		}
	});

	// 部门表单
	$("#dept_form").validate({
		rules : {
			name : "required",
		},
		messages : {
			name : {
				required : "部门名不能为空!"
			}
		},
		errorPlacement : function(error, element) {
			if (element.is(":radio"))
				error.appendTo(element.parent().next().next());
			else if (element.is(":checkbox"))
				error.appendTo(element.next());
			else
				error.appendTo(element.parent());
		},
		errorElement : "span",
		// set this class to error-labels to indicate valid fields
		success : function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("true");
		},
		highlight : function(element, errorClass) {
			$(element).parent().find("." + errorClass).removeClass("true");
		}
	});

	// 文件表单
	$("#document_form").validate({
		rules : {
			title : "required",
			file : "required",
		},
		messages : {
			title : {
				required : "文件标题不能为空!"
			},
			file : {
				required : "文件未选择!"
			}
		},
		errorPlacement : function(error, element) {
			if (element.is(":radio"))
				error.appendTo(element.parent().next().next());
			else if (element.is(":checkbox"))
				error.appendTo(element.next());
			else
				error.appendTo(element.parent());
		},
		errorElement : "span",
		// set this class to error-labels to indicate valid fields
		success : function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("true");
		},
		highlight : function(element, errorClass) {
			$(element).parent().find("." + errorClass).removeClass("true");
		}

	});

	// 员工表单
	$("#employee_form").validate({
		rules : {
			name : "required",
			cardId : {
				required : true,
				digits : true
			},
			sex : "required",
			age : {
				required : true,
				range : [ 18, 50 ]
			},
			jobId : "required",
			education : "required",
			email : {
				required : true,
				email : true
			},
			qq : "required",
			race : "required",
			address : "required",
			hobby : "required",
			postCode : "required",
			deptId : "required"
		},
		messages : {
			name:{
				required:"员工名不能为空!"
			},
			cardId:{
				required:"身份证号不能为空!",
				digits:"身份证号不合法!"
			},
			sex:{
				required:"性别未选取!",
			},
			age:{
				required:"年龄不能为空!",
				range:"年龄必须在18~50岁之间"
			},
			jobId:{
				required:"职位未选取!"
			},
			education:{
				required:"学历未选取!"
			},
			email:{
				required:"邮箱不能为空!",
				email:"邮箱不合法!"
			},
			qq:{
				required:"qq不能为空!"
			},
			race:{
				required:"民族未选取!"
			},
			address:{
				required:"地址不能为空!"
			},
			hobby:{
				required:"爱好不能为空!"
			},
			postCode:{
				required:"邮编不能为空!"
			},
			deptId:{
				required:"部门未选取!"
			}
			
		},
		errorPlacement : function(error, element) {
			if (element.is(":radio"))
				error.appendTo(element.parent().next().next());
			else if (element.is(":checkbox"))
				error.appendTo(element.next());
			else
				error.appendTo(element.parent());
		},
		errorElement : "span",
		// set this class to error-labels to indicate valid fields
		success : function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("true");
		},
		highlight : function(element, errorClass) {
			$(element).parent().find("." + errorClass).removeClass("true");
		}
	});

	// 职位表单
	$("#job_form").validate({
		rules : {
			name:"required"
		},
		messages : {
			name:{
				required:"职位名不能为空!"
			}
		},
		errorPlacement : function(error, element) {
			if (element.is(":radio"))
				error.appendTo(element.parent().next().next());
			else if (element.is(":checkbox"))
				error.appendTo(element.next());
			else
				error.appendTo(element.parent().next());
		},
		errorPlacement : function(error, element) {
			if (element.is(":radio"))
				error.appendTo(element.parent().next().next());
			else if (element.is(":checkbox"))
				error.appendTo(element.next());
			else
				error.appendTo(element.parent());
		},
		errorElement : "span",
		// set this class to error-labels to indicate valid fields
		success : function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("true");
		},
		highlight : function(element, errorClass) {
			$(element).parent().find("." + errorClass).removeClass("true");
		}

	});

	// 公告表单
	$("#notice_form").validate({
		rules : {
			title:"required",
			content:"required"
		},
		messages : {
			title:{
				required:"公告标题不能为空!"
			},
			content:{
				required:"公告内容不能为空!"
			}
		},
		errorPlacement : function(error, element) {
			if (element.is(":radio"))
				error.appendTo(element.parent().next().next());
			else if (element.is(":checkbox"))
				error.appendTo(element.next());
			else
				error.appendTo(element.parent());
		},
		errorElement : "span",
		// set this class to error-labels to indicate valid fields
		success : function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("true");
		},
		highlight : function(element, errorClass) {
			$(element).parent().find("." + errorClass).removeClass("true");
		}
	});
});
