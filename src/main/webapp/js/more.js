/*返回到首页*/
function index() {
	window.location.href = ctxPath + "/user/index.do";
}

/* 返回上一页 */
function back(type) {
	window.location.href = ctxPath + "/user/shopping.do" + "#" + type;
}

/*在线支付*/
function pay(phone){
	$.ajax({
		type : 'POST',
		url : ctxPath + "/user/pay.do",
		data : {
			"phone" : phone
		},
		befordSend : function(xhr){
			$('#order').disabled="disabled";
		},
		error : function(xhr, status) {
			alert('订单提交失败！');
		},
		success : function(data, status, xhr) {
			alert("订单已经提交给管理员!");
			$('#order').html("订单已提交，请勿重复操作！");
		}

	});
}
/* 搜索商品 */
function search() {
	var key = $.trim($("#key").val());
	$.ajax({
		type : 'POST',
		url : ctxPath + "/user/search.do",
		data : {
			"key" : key
		},
		error : function(xhr, status) {
			alert('加载失败！');
		},
		success : function(data, status, xhr) {
			$('#result').html(data);
		}

	});
}

/* 添加购物车 */
function checkout(id) {
	var number = $.trim($("#number").val());
	$.ajax({
		type : 'POST',
		url : ctxPath + "/user/checkout.do",
		data : {
			"id" : id,
			"number" : number
		},
		error : function(xhr, status) {
			alert('加载失败！');
		},
		success : function(data, status, xhr) {
			alert("添加购物车成功，快去购物车查看吧！");
			$('#addcheckout').html(data);
		}

	});
}

/* 删除购物车商品 */
function delect(ids) {
	window.location.href = ctxPath + "/user/car.do" + "?ids=" + ids;
}
/* 查看商品详情 */
function detail(id) {
	window.location.href = ctxPath + "/user/detail.do" + "?id=" + id;
}