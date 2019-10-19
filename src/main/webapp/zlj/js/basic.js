$(function(){
	$.get("member/check",null,function(data){
		var str = "";
	 	if(data.mno) {
			str += '<div class="login_btn fl"><a href="#">欢迎您 &nbsp;['+data.nickName+']</a><span> | </span>';
			str += '<a href="javascript:menberLogin()">注销</a><span> | </span><a href="register.html">注册</a></div>';
		} else {
			str += '<div class=cart_infos"login_btn fl">';
			str += '<a href="javascript:menberLogin()">登录</a><span> | </span><a href="register.html">注册</a></div>';
		}
		str += '<div class="user_link fl"><span> | </span><a href="#">用户中心</a><span> | </span>';
		str += '<a href="front/cart.html">我的购物车</a><span> | </span><a href="#">我的订单</a></div> ';
		$("#head_info").append($(str));
		
		
	},"json")
	
})
function menberLogin(){
	//html5中提供LocalStorage对象可以长期存在客户端里面，直达认为清除
	localStorage.setItem("targetURL",location.href);
	location.href="login.html";
}

var cart_infos = undefined;
function getCartInfo(){
	$.get("cart/getInfo",null,function(data){
		console.log(data);
		cart_infos = data;
		
		$("#show_count").text( Object.keys(data).length );
		
	},"json");
}

