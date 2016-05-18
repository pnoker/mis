/*返回到首页*/
function index() {
	window.location.href = ctxPath + "/user/index.do";
}

/* 商品活动页面 */
function active() {
	window.location.href = ctxPath + "/user/active.do";
}

/* 购物车结算页面 */
function checkout() {
	window.location.href = ctxPath + "/user/checkout.do";
}

/* 更多more */
function more(name) {
	window.location.href = ctxPath + "/user/" + name + ".do";
}

function detail(id) {
	window.location.href = ctxPath + "/user/detail.do" + "?id=" + id;
}

function car(){
	window.location.href = ctxPath + "/user/car.do"
	
}

