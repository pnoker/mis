function regist() {
	window.location.href = ctxPath + "/regist.do";
}
function login_admin(){
	window.location.href = ctxPath = "/login_admin.do"
}
function login() {
	var phone = $.trim($("#phone").val());//获取手机账号
	var password = $.trim($("#password").val());
	$.ajax({// 异步请求
		type : "POST",
		url : ctxPath + "/user/login.do",
		dataType : "json",
		data : {
			"phone" : phone,
			"password" : $.md5(password)
		},
		success : function(data) {
			if (data.mes == "1000") {
				alert("用户名为空！");
			}
			if (data.mes == "1001") {
				alert("用户名不存在！");
			}
			if (data.mes == "1002") {
				alert("密码不能为空！");
			}
			if (data.mes == "1003") {
				alert("用户名和密码不匹配，请重新输入！");
			}
			if (data.mes == "1004") {
				window.location.href = ctxPath + "/user/index.do";
			} else {
				return true;
			}
		},
		error : function() {
			return true;
		}
	});
}